package br.com.rodrigoamora.controller;

import java.net.URI;

import br.com.rodrigoamora.controller.doc.PagamentoApiDoc;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rodrigoamora.dto.PagamentoDto;
import br.com.rodrigoamora.service.PagamentoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController implements PagamentoApiDoc {

	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@GetMapping
	public Page<PagamentoDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return this.pagamentoService.obterTodos(paginacao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PagamentoDto> detalhar(@PathVariable @NotNull Long id) {
		PagamentoDto dto = this.pagamentoService.obterPorId(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto dto,
												  UriComponentsBuilder uriBuilder) {
		PagamentoDto pagamento = this.pagamentoService.criarPagamento(dto);
		URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

		this.rabbitTemplate.convertAndSend("pagamentos.ex", "", pagamento);
        
		return ResponseEntity.created(endereco).body(pagamento);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PagamentoDto> atualizar(@PathVariable @NotNull Long id,
												  @RequestBody @Valid PagamentoDto dto) {
		PagamentoDto atualizado = this.pagamentoService.atualizarPagamento(id, dto);
        return ResponseEntity.ok(atualizado);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<PagamentoDto> remover(@PathVariable @NotNull Long id) {
		this.pagamentoService.excluirPagamento(id);
        return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}/confirmar")
	@CircuitBreaker(name = "atualizaPedido", fallbackMethod = "pagamentoAutorizadoComIntegracaoPendente")
	public void confirmarPagamento(@PathVariable @NotNull Long id) {
		this.pagamentoService.confirmarPagamento(id);
	}
	
	public void pagamentoAutorizadoComIntegracaoPendente(Long id, Exception e) {
		this.pagamentoService.alteraStatus(id);
	}
	
}

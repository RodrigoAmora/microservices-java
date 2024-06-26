package br.com.rodrigoamora.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rodrigoamora.dto.PedidoDto;
import br.com.rodrigoamora.dto.StatusDto;
import br.com.rodrigoamora.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping()
    public List<PedidoDto> listarTodos() {
        return this.pedidoService.obterTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> listarPorId(@PathVariable @NotNull Long id) {
        PedidoDto dto = this.pedidoService.obterPorId(id);
        return  ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<PedidoDto> realizaPedido(@RequestBody @Valid PedidoDto dto, UriComponentsBuilder uriBuilder) {
        PedidoDto pedidoRealizado = this.pedidoService.criarPedido(dto);

        URI endereco = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedidoRealizado.getId()).toUri();

        return ResponseEntity.created(endereco).body(pedidoRealizado);

    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PedidoDto> atualizaStatus(@PathVariable Long id, @RequestBody StatusDto status){
       PedidoDto dto = this.pedidoService.atualizaStatus(id, status);
       return ResponseEntity.ok(dto);
    }


    @PutMapping("/{id}/pago")
    public ResponseEntity<Void> aprovaPagamento(@PathVariable @NotNull Long id) {
    	this.pedidoService.aprovaPagamentoPedido(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/porta")
    public String retornaPorta(@Value("${local.server.port}") String porta) {
    	return String.format("Requisição respondida pela instância executando na porta %s", porta);
    }
    
}

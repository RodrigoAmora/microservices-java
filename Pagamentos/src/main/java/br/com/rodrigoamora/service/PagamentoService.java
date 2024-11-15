package br.com.rodrigoamora.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rodrigoamora.dto.PagamentoDto;
import br.com.rodrigoamora.http.PedidoClient;
import br.com.rodrigoamora.model.Pagamento;
import br.com.rodrigoamora.model.Status;
import br.com.rodrigoamora.repository.PagamentoRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentoService {
	
	@Autowired
    private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired(required = false)
	private PedidoClient pedidoClient;
	
	
	private Counter pagamentoFeito, pagamentoConfirmado;
	
	@Autowired
	public PagamentoService(MeterRegistry registry) {
		this.pagamentoFeito = Counter.builder("pagamento_feito")
				  					 .description("Pagamentos feitos")
				  					 .register(registry);

		this.pagamentoConfirmado = Counter.builder("pagamento_confirmado")
					   					  .description("Pagamentos confirmados")
					   					  .register(registry);
	}
	
	public Page<PagamentoDto> obterTodos(Pageable paginacao) {
		return this.pagamentoRepository.findAll(paginacao)
                					   .map(p -> modelMapper.map(p, PagamentoDto.class));
    }
	 
	 public PagamentoDto obterPorId(Long id) {
		 Pagamento pagamento = pagamentoRepository.findById(id)
				 								  .orElseThrow(() -> new EntityNotFoundException());

		 return modelMapper.map(pagamento, PagamentoDto.class);
    }

	 public PagamentoDto criarPagamento(PagamentoDto dto) {
		 Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
		 pagamento.setStatus(Status.CRIADO);
		 
		 this.pagamentoRepository.save(pagamento);
		 this.pagamentoFeito.increment();
		 
		 return modelMapper.map(pagamento, PagamentoDto.class);
	 }
	 
	 public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
		 Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
		 pagamento.setId(id);
		 pagamento = this.pagamentoRepository.save(pagamento);
		 return modelMapper.map(pagamento, PagamentoDto.class);
	 }
	 
	 public void excluirPagamento(Long id) {
		 this.pagamentoRepository.deleteById(id);
	 }
	 
	 public void confirmarPagamento(Long id) {
		 Optional<Pagamento> pagamento = this.pagamentoRepository.findById(id);
		 if (!pagamento.isPresent()) {
			 throw new EntityNotFoundException();
	     }
		 pagamento.get().setStatus(Status.CONFIRMADO);
		 
		 this.pagamentoRepository.save(pagamento.get());
		 this.pagamentoConfirmado.increment();
		 
		 Long pedidoId = pagamento.get().getPedidoId();
		 this.pedidoClient.atualizaPagamento(pedidoId);
	 }
	 
	 public void alteraStatus(Long id) {
		 Optional<Pagamento> pagamento = this.pagamentoRepository.findById(id);
		 if (!pagamento.isPresent()) {
			 throw new EntityNotFoundException();
   		 }
		 pagamento.get().setStatus(Status.CONFIRMADO_SEM_INTEGRACAO);
		 
		 this.pagamentoRepository.save(pagamento.get());
	 }
	 
}

package br.com.rodrigoamora.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.rodrigoamora.dto.PagamentoDto;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class AvaliacaoListener {
	
	private Counter pedidoAvaliado;
	
	@Autowired
	public AvaliacaoListener(MeterRegistry registry) {
		this.pedidoAvaliado = Counter.builder("pedido_avaliado")
				  					 .description("Pedidos avaliados")
				  					 .register(registry);
	}
	
    @RabbitListener(queues = "pagamentos.detalhes-avaliacao")
    public void recebeMensagem(@Payload PagamentoDto pagamento) {
    	System.out.println(pagamento.getId());
        System.out.println(pagamento.getNumero());

        if (pagamento.getNumero().equals("0000")) {
            throw new RuntimeException("não consegui processar");
        }

        String mensagem = """
                Necessário criar registro de avaliação para o pedido: %s 
                Id do pagamento: %s
                Nome do cliente: %s
                Valor R$: %s
                Status: %s 
                """.formatted(pagamento.getPedidoId(),
                pagamento.getId(),
                pagamento.getNome(),
                pagamento.getValor(),
                pagamento.getStatus());

        this.pedidoAvaliado.increment();
        
        System.out.println(mensagem);
    }
    
}

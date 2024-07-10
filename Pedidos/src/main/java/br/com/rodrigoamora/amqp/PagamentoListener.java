package br.com.rodrigoamora.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.rodrigoamora.dto.PagamentoDto;

@Component
public class PagamentoListener {

	@RabbitListener(queues = "pagamento.concluido")
	public void recebeMensagem(PagamentoDto pagamento) {
		String mensagem = """
				Dados do pagamento: %s
				Numero pedido: %s
				Valor R$: %s
				Status: $s
				""".formatted(pagamento.getId(),
							  pagamento.getNumero(),
							  pagamento.getValor(),
							  pagamento.getStatus());
		
		System.out.println("Recebi a mensagem " + mensagem);
    }
	
}

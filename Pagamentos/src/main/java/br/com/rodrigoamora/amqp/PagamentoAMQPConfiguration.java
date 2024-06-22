package br.com.rodrigoamora.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

@Configuration
public class PagamentoAMQPConfiguration {

	@Bean
	Queue criaFila() {
		//return new Queue ("pagamento.concluido", false);
		return QueueBuilder.nonDurable("pagamento.concluido").build();
	}
	
	@Bean
    RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
		return new RabbitAdmin(conn);
	}
	
}

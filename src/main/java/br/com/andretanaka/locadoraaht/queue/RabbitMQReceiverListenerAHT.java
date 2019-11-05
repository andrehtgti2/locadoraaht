package br.com.andretanaka.locadoraaht.queue;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.andretanaka.locadoraaht.config.ConfigLocadoraAHT;
import br.com.andretanaka.locadoraaht.logger.SLF4JAHT;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

@Component
public class RabbitMQReceiverListenerAHT {

	private static final Logger logger = SLF4JAHT.getLogger(RabbitMQReceiverListenerAHT.class);
	
	
	
	/*
	 *  DESCOMENTAR O BLOCO ABAIXO PARA ATIVAR O CONSUMER DA FILA LocacoesDiasRestantes do RabbitMQ 
	 */
	
	
	
	
	/*
	@RabbitListener(queues = {ConfigLocadoraAHT.QUEUE_NAME})
    public void receive(@Payload String fileBody) {
    	logger.info("RabbitMQReceiverListener: Lendo da Queue " + ConfigLocadoraAHT.QUEUE_NAME + " o conteudo: " + fileBody);
    }
    */
	
	
	
	
	
	
	 
}

/*

application.properties:

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:mysql://localhost:3306/locadoraaht?useSSL=false&useTimezone=true&serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password = admin

spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

*/


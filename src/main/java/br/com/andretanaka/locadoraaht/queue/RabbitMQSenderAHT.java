package br.com.andretanaka.locadoraaht.queue;

import org.slf4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RabbitMQSenderAHT {
	
	private static final Logger logger = SLF4JAHT.getLogger(RabbitMQSenderAHT.class);

	
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
    public void send(String s) {
    	Queue queue = new Queue(ConfigLocadoraAHT.QUEUE_NAME, true);
    	logger.info("RabbitMQSender: Enviando para fila " + ConfigLocadoraAHT.QUEUE_NAME + " o conteudo:" + s);
        rabbitTemplate.convertAndSend(queue.getName(), s);
    }

   
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


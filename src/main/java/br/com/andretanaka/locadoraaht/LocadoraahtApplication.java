package br.com.andretanaka.locadoraaht;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

@SpringBootApplication
@EnableRabbit
public class LocadoraahtApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraahtApplication.class, args);
	}

}

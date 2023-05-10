package com.guc.merch;

import com.guc.merch.MQ.Sender;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MerchApplication {



	public static void main(String[] args) {

		SpringApplication.run(MerchApplication.class, args);
		//Code be get executed hena 3ady (For Testing purposes only)

//		CachingConnectionFactory conn = new CachingConnectionFactory("localhost");
//		conn.setUsername("guest");
//		conn.setPassword("guest");
//
//		Sender send = new Sender(new RabbitTemplate(conn));
//		send.sendMessage("hello");


	}





}

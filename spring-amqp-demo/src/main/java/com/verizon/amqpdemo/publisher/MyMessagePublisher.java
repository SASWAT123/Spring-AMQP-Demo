package com.verizon.amqpdemo.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMessagePublisher {
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		
		AmqpTemplate template = ctx.getBean(RabbitTemplate.class);
		
		for(int i = 1; i <= 5; i++) {
			String message = "Hello Everybody! msh#"+i;
			System.out.println("Sending Message#"+i+"...");
			template.convertAndSend(message);
			System.out.println("sent!");
			try {
				Thread.sleep(1500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

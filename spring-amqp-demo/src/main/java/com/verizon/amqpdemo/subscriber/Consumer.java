package com.verizon.amqpdemo.subscriber;

public class Consumer {
	
	public void listen(String message) {
		System.out.println("Received: "+ message);
	}

}

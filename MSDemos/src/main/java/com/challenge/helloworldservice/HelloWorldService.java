package com.challenge.helloworldservice;

import org.springframework.context.annotation.Bean;

public class HelloWorldService {
	
	private String messageString;

	@Bean(name = "helloWorldService")
	public String getMessageString() {
		return "Hello " +  messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	

}

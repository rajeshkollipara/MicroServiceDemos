package com.challenge.helloworldservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name="helloWorldService")
	public HelloWorldService helloWorldService() {
	
		return new HelloWorldService();
	}
	
}

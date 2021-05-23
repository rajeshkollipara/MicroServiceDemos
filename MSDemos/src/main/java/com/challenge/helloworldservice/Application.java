package com.challenge.helloworldservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext context = 
		         new AnnotationConfigApplicationContext(AppConfig.class);
		 HelloWorldService service = context.getBean("helloWorldService", HelloWorldService.class);
		 service.setMessageString("Visible");
		 System.out.println(service.getMessageString());
	}

}

package com.example.employeedemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class EmployeeDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeeDemoApplication.class);
	public static void main(String[] args) {
		System.out.println("HELLO SPRING BOOT");
		SpringApplication.run(EmployeeDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			System.out.println("COMMAND LINE");

			repository.save(new Employee("Kollipara", "Rajesh"));
			repository.save(new Employee("Steevert", "Binny"));
			repository.save(new Employee("Koneru", "Mahesh"));
			repository.save(new Employee("Steeve", "Balmer"));
			repository.save(new Employee("Donald", "Trump"));

			// fetch all employees
			log.info("-------------------------------");
			log.info("FETCHING ALL EMPLOYEES");

			for (Employee employee : repository.findAll()) {
				log.info(employee.toString());
			}
			log.info("-------------------------------");

			// fetch an individual employee by First Name
			List<Employee> employee = repository.findByFirstName("Kollipara");
			log.info("--------------------------------");
			log.info("FETCHING EMPLOYEES by FIRST NAME");
			log.info(employee.toString());
			log.info("--------------------------------");

		};
	}

}

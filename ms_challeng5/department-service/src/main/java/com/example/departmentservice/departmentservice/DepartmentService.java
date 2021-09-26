package com.example.departmentservice.departmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;


@RestController
@EnableEurekaClient
@RequestMapping("/department")
public class DepartmentService {
	

	@Autowired
    private EurekaClient eurekaClient;
	
	@Value("${spring.application.name}")
    private String appName;
	
	
	@Autowired
	private EmployeeConsumer consumer;
	
	
//	@RequestMapping(value="/hello/{department}", method= RequestMethod.GET)
//	public String fetchEmployee(@PathVariable("department") String department) {
//		
//		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
//		
//	}
	
	
    @GetMapping("/getOneEmployee/{id}")
    public String getOneBookForStd(@PathVariable Integer id) {
       return "Accessing from DEPARTMENT-SERVICE ==> " + consumer.getEmployee(id); 
    }

    @GetMapping("/getGreeting/{greeting}")
    public String getMessage(@PathVariable String greeting) {
       return "Accessing from DEPARTMENT-SERVICE ==> " + consumer.getMessage(greeting); 
    }

	
	@GetMapping("/")
	public String welcomeMessage() {
		
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
		
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable Integer id) {
		
		return new Department(id, "ECE", "Hyd");
		
	}
}
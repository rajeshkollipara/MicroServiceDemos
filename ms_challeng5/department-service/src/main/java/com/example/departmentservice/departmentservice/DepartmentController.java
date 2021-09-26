package com.example.departmentservice.departmentservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;



@RestController
@EnableEurekaClient
@RequestMapping("/department")
public class DepartmentController {
	

	@Autowired
    private EurekaClient eurekaClient;
	
	@Value("${spring.application.name}")
    private String appName;
	
	
	@Autowired
	private EmployeeConsumer consumer;
	
	
	
    @GetMapping("/getEmployees/{id}")
    public String getOneBookForStd(@PathVariable Integer id) {
       return "Accessing from DEPARTMENT-SERVICE ==> " + consumer.getEmployees(id); 
    }

//    @GetMapping("/getGreeting/{greeting}")
//    public String getMessage(@PathVariable String greeting) {
//       return "Accessing from DEPARTMENT-SERVICE ==> " + consumer.getMessage(greeting); 
//    }

	
	@GetMapping("/")
	public String welcomeMessage() {
		
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
		
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable Integer id) {
		
		List<Department> originalList = getAllDepartments();	    
	    List<Department> filteredList = originalList.stream()
	    	    .filter(p -> p.getDepId().equals(id)).collect(Collectors.toList());
		return filteredList.stream().findFirst().orElse(null);
				
	}
	
	
	public ArrayList<Department> getAllDepartments() {
		
		
		Department department1 = new Department(111, "VCG", "Hyderabad");
		Department department2 = new Department(222, "VBG", "Chennai");
		Department department3 = new Department(333, "VPG", "Bangalore");

	
		ArrayList<Department> departmentList = new ArrayList<Department>();
		departmentList.add(department1);
		departmentList.add(department2);
		departmentList.add(department3);

		return departmentList;
		
	}
	
}
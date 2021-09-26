package com.example.departmentservice.departmentservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("employee-service")
public interface EmployeeConsumer {
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Integer id);
	
	@GetMapping("/employee/greeting/{greeting}")
	public String getMessage(@PathVariable String greeting);
}

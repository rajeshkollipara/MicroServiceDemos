package Employee.Service;

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
@RequestMapping("/employee")
public class EmployeeService {
	
	@Autowired
    Environment environment;


	@Autowired
    private EurekaClient eurekaClient;
//	
	@Value("${spring.application.name}")
    private String appName;
	
//	@GetMapping("/{employee}")
//	public String fetchEmployee(@PathVariable String employee) {
//		
//		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
//
//	}
	
	@GetMapping("/greeting/{greeting}")
	public String welcomeMessage(@PathVariable String greeting) {
		
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName()) + "\n" + "Running on port: "
	               + environment.getProperty("local.server.port") + " " + greeting;
		
	}

	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		
		return new Employee(1, "Rajesh", "K", "SSE", "rajesh@gmail.com", id);
		
	}
}
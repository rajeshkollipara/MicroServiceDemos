package Employee.Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import com.netflix.discovery.EurekaClient;

import Employee.Service.Model.Employee;

@RestController
@EnableEurekaClient
@RequestMapping("/employee")
public class EmployeesController {
	
	@Autowired
    Environment environment;
	@Autowired
    private EurekaClient eurekaClient;	
	@Value("${spring.application.name}")
    private String appName;
	
	
	@GetMapping("/greeting/{greeting}")
	public String welcomeMessage(@PathVariable String greeting) {
		
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName()) + "\n" + "Running on port: "
	               + environment.getProperty("local.server.port") + " " + greeting;
		
	}

	
	@GetMapping("/{id}")
	public String getEmployee(@PathVariable Integer id) {
		
		List<Employee> originalList = getAllEmployees();
	    List<Employee> filteredList = originalList.stream()
	    	    .filter(p -> p.getDepartmentId().equals(id)).collect(Collectors.toList());
	    System.out.println("*******************************");
	    System.out.println(filteredList.toString());
	    System.out.println("*******************************");
		return  "\n" + "Running on port: "
	               + environment.getProperty("local.server.port") + "\n" + filteredList.toString()  ;
		
	}
	
	
	public ArrayList<Employee> getAllEmployees() {
		
		
		Employee employee1 =  new Employee(1, "Rajesh", "K", "MTS IV", "rajesh@gmail.com", 111);
		Employee employee2 =  new Employee(2, "Mahesh", "M", "Eng II", "mahesh@gmail.com", 111);
		Employee employee3 =  new Employee(3, "Suresh", "R", "Eng III", "suresh@gmail.com", 222);
		Employee employee4 =  new Employee(4, "AnilRaju", "S", "Eng I", "anil@gmail.com", 222);
		Employee employee5 =  new Employee(5, "Soma", "R", "Eng II", "suresh@gmail.com", 333);
		Employee employee6 =  new Employee(5, "Binny", "R", "Eng I", "suresh@gmail.com", 333);
		Employee employee7 =  new Employee(5, "Gopi", "R", "Eng III", "suresh@gmail.com", 333);
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);
		employeeList.add(employee6);
		employeeList.add(employee7);

		return employeeList;
		
	}
	
	
	
	
	
}
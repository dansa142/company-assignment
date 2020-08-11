package com.dansa.JBTest.clr;

import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dansa.JBTest.beans.Employee;
import com.dansa.JBTest.beans.Job;

@Component
@Order(2)
public class WebTest implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate(); 
		
		System.out.println();
		System.out.println("---trying to post new employee using rest template");
		
		Employee e4 = new Employee(); 
		e4.setName("Kobi");
		e4.setSalary(15000.0);
		e4.setJobs(new ArrayList<Job>());
		
		restTemplate.postForObject("http://localhost:8080/company/add-employee", e4, String.class );
		
		System.out.println();
		System.out.println("---trying to get all employees using rest template");
		System.out.println(restTemplate.getForObject("http://localhost:8080/company/get-all-employees", String.class));
		System.out.println();
		System.out.println("--- trying to get employee (chen) using rest template");
		System.out.println(restTemplate.getForObject("http://localhost:8080/company/get-employees-by-name/chen", String.class));
		System.out.println();
		System.out.println("---trying to get one imployee by ID (3)");
		System.out.println(restTemplate.getForObject("http://localhost:8080/company/get-employee/3", String.class));
	}

}

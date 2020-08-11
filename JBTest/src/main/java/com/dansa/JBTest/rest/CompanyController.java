package com.dansa.JBTest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dansa.JBTest.beans.Employee;
import com.dansa.JBTest.service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService; 
	
	@PostMapping("add-employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		companyService.addEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.CREATED); 
		
	}
	
	@GetMapping("get-employee/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable long id){
		return new ResponseEntity<Employee>(companyService.getEmployee(id), HttpStatus.OK);
	}
	
	@GetMapping("get-all-employees")
	public ResponseEntity<?> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(companyService.getAllEmployees(), HttpStatus.OK); 
	}
	
	@GetMapping("get-employees-by-name/{name}")
	public ResponseEntity<?> getAllEmployeesByName(@PathVariable String name){
		return new ResponseEntity<List<Employee>>(companyService.getEmployeesByName(name), HttpStatus.OK);
	}
	

}

package com.dansa.JBTest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dansa.JBTest.beans.Employee;
import com.dansa.JBTest.beans.Job;
import com.dansa.JBTest.repo.EmployeeReposetory;
import com.dansa.JBTest.repo.JobRepository;

@Service
public class CompanyService {
	
	@Autowired
	private EmployeeReposetory employeeRepo; 
	@Autowired
	private JobRepository jobRepo;
	
	public void addEmployee(Employee employee) {
		employeeRepo.save(employee); 
		System.out.println("employee " + employee.getName() + " was added succefully");
	}
	
	public Employee getEmployee(long id) {
		return employeeRepo.getOne(id); 
	}
	
	public List<Employee> getEmployeesByName(String name){
		return employeeRepo.findByName(name); 
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll(); 
	}
	
	public List<Job> getJobByEndDate(Date date){
		return jobRepo.findByEndDateBefore(date);		
	}
	
	public List<Job> getJobsBetween(Date start, Date end){
		return jobRepo.findByEndDateIsBetween(start, end); 
	}
	
}

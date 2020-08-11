package com.dansa.JBTest.clr;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dansa.JBTest.beans.Employee;
import com.dansa.JBTest.beans.Job;
import com.dansa.JBTest.service.CompanyService;
import com.dansa.JBTest.util.Utilities;

@Component
@Order(1)
public class CompanyTest implements CommandLineRunner{

	@Autowired
	private CompanyService companyService;
	@Override
	public void run(String... args){
	
		Job j1 = new Job();
		j1.setDescription("first job");
		j1.setEndDate(Utilities.convertDateToSql(new java.util.Date(2025, 1, 1)));
		
		Job j2 = new Job();
		j2.setDescription("seconed job");
		j2.setEndDate(Utilities.convertDateToSql(new java.util.Date(2020, 4, 1)));
		
		Job j3 = new Job();
		j3.setDescription("third job");
		j3.setEndDate(Utilities.convertDateToSql(new Date(2020, 12, 15)));
		
		Job j4 = new Job();
		j4.setDescription("forth job");
		j4.setEndDate(Utilities.convertDateToSql(new Date(2030, 1, 1)));
		
		Job j5 = new Job();
		j5.setDescription("fifth job");
		j5.setEndDate(Utilities.convertDateToSql(new Date(2024, 1, 1)));
		
		Job j6 = new Job();
		j6.setDescription("sixth job");
		j6.setEndDate(Utilities.convertDateToSql(new Date(2025, 1, 1)));
		
		Employee e1 = new Employee(); 
		e1.setName("Dan");
		e1.setSalary(15000.0);
		e1.setJobs(new ArrayList<Job>());
		e1.getJobs().add(j1); 
		e1.getJobs().add(j2); 

		Employee e2 = new Employee();
		e2.setName("Chen");
		e2.setSalary(14999.9);
		e2.setJobs(new ArrayList<Job>());
		e2.getJobs().add(j3); 
		e2.getJobs().add(j4);
		
		Employee e3 = new Employee(); 
		e3.setName("Ron");
		e3.setSalary(10000.0);
		e3.setJobs(new ArrayList<Job>());
		e3.getJobs().add(j5);
		e3.getJobs().add(j6);
		
		System.out.println("****************** testing company service methodes ********************");
		System.out.println("---trying to add employee:");
		companyService.addEmployee(e1);
		companyService.addEmployee(e2);
		companyService.addEmployee(e3);
		System.out.println();
		
		System.out.println("---trying to get employee by ID:");
		System.out.println(companyService.getEmployee(2));
		System.out.println();
		System.out.println("--- trying to get employee by name (Dan):");
		System.out.println(companyService.getEmployeesByName("Dan"));
		System.out.println();
		System.out.println("---trying to get all emploees:");
		List<Employee> employees = companyService.getAllEmployees(); 
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println();
		System.out.println("---trying to get all jobs with end date before 2025:");
		List<Job> jobs = companyService.getJobByEndDate(Utilities.convertDateToSql(new java.util.Date(2025, 1, 1)));
		for (Job job : jobs) {
			System.out.println(job);
		}
		
		System.out.println();
		System.out.println("---trying to get all projects between 2020 & 2025");
		List<Job> jobs2 = companyService.getJobsBetween(Utilities.convertDateToSql
				(new java.util.Date(2020, 1, 1)), Utilities.convertDateToSql(new java.util.Date(2025, 12, 31)));
		for (Job job : jobs2) {
			System.out.println(job);
		}
	}

}

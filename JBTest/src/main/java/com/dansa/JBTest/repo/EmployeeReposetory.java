package com.dansa.JBTest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dansa.JBTest.beans.Employee;

@Repository
public interface EmployeeReposetory extends JpaRepository<Employee, Long>{
	
	List<Employee> findByName(String name);
}

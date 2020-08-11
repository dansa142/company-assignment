package com.dansa.JBTest.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dansa.JBTest.beans.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
	
	List<Job> findByEndDateBefore(Date endDate); 
	List<Job> findByEndDateIsBetween (Date startDate, Date endDate); 
}

package com.dansa.JBTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JbTestApplication {

	public static void main(String[] args) {
		System.out.println("START");
		SpringApplication.run(JbTestApplication.class, args);
		System.out.println("END");	
	}
	

}

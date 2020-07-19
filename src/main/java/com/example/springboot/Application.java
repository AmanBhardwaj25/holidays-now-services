package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
	//	ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		SpringApplication.run(Application.class, args);
		

		
	}
	
}

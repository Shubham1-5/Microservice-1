package com.shubham.Microservice1Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 1. I want to create a service - Expose REST EndPoints
 *
 * GET 127.0.0.1:7071/ms1/v1/messages
 *
 * 2. I want to auto register with Eureka Server
 * a. Add the dependency Eureka client in pom.xml
 * b. Add configurations in the application.properties file
 * c. Add the annotation in the main class
 *
 */

@SpringBootApplication
@RestController
@RequestMapping("/messages")
@EnableDiscoveryClient
public class Microservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}

	@GetMapping
	public ResponseEntity helloMessage(){
		return new ResponseEntity("Hello from the Microservice 1", HttpStatus.OK);
	}

}

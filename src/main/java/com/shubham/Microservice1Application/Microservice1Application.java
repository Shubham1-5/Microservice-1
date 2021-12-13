package com.shubham.Microservice1Application;

import org.apache.logging.log4j.message.DefaultFlowMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
@EnableFeignClients
public class Microservice1Application {

	@Autowired
	private Microservice2Client microservice2Client;

	@Autowired
	private ServerProperties serverProperties;

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}

	@GetMapping
	public ResponseEntity helloMessage(){
		/**
		 * I should call the Microservice2
		 * GET 127.0.0.1:7072/ms2/v1/messages
		 *
		 * Whatever be the result of the above get call, append to the response
		 *
		 * So, for now it should show :
		 *
		 * Hello from the Microservice 1 + " Response from MS2 " + Hello from the Microservice 2
		 */

		/**
		 * Some identifier for the running instance
		 *
		 * The running portNumber
		 */
		System.out.println("The port number hit is :" + serverProperties.getPort());

		String response = microservice2Client.getMessage();
		return new ResponseEntity("Hello from the Microservice 1 " + " Response from MS2 " + response, HttpStatus.OK);
	}

}

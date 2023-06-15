package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceEregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEregistryApplication.class, args);
	}

}

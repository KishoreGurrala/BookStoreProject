package com.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCartServiceApplication.class, args);
	}

}

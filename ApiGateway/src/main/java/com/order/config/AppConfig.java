package com.order.config;

import org.springframework.web.client.RestTemplate;

public class AppConfig {
	
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

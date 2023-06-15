package com.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "OrderMicroservice", url="http://localhost:8484")
public interface OrderClient {
	
	@GetMapping("/order/completeOrder")
	public String makeOrder(@RequestHeader("userEmail")  String email);
		
}

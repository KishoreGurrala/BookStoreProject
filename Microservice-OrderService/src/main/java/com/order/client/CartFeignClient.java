package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.order.dto.Cart;

@FeignClient(name = "CartMicroservice", url="http://localhost:8383")
public interface CartFeignClient {
	
	@GetMapping("/cart/removeCart")
	public String removeCart(@RequestHeader("userEmail")String email);
	
	@GetMapping("/cart/getCartItems")
	public Cart getCart(@RequestHeader("userEmail")String email);
}

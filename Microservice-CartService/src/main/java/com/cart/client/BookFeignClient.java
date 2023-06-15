package com.cart.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cart.dto.Book;

@FeignClient(name = "BookMicroservice" , url="http://localhost:8282")
public interface BookFeignClient {
	
	@GetMapping("/book/cart/{bookId}/{quantity}")
	public String cart(@PathVariable("bookId")String bookid,@PathVariable("quantity")int quantity);
	
	@GetMapping("/book/getBook/{bookId}")
	public Book getBook(@PathVariable("bookId")String bookid);
}

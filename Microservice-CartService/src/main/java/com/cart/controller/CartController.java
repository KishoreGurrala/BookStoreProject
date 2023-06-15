package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.client.BookFeignClient;
import com.cart.dto.Book;
import com.cart.entity.Cart;
import com.cart.service.CartItemsService;
import com.cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private BookFeignClient bookFeignClient;

	@Autowired
	private CartItemsService cartItemsService;

	// To get the cart Items of customer using customerId
	@GetMapping("/getCartItems")
	public Cart getCustomer(@RequestHeader("userEmail")  String email) {

		Cart cart = cartService.getCart(email);
		return cart;
	}

	// To add the books into the cart
	@PostMapping("/addCart/{bookId}/{quantity}")
	public ResponseEntity<?> addToCart(@PathVariable("bookId")String bookId,@PathVariable("quantity")int quantity,@RequestHeader("userEmail")  String email) {
		
		String msg = bookFeignClient.cart(bookId, quantity);

		if (msg.equalsIgnoreCase("Done")) {
			cartService.addToCart1(email,bookId, quantity);
			return new ResponseEntity<>("Cart Items added successfully.", HttpStatus.CREATED);
		} 
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		
	}

	// To delete book in cart using customer and book Id
	@GetMapping("/deleteBook/{bookId}")
	public String deleteCartItem(@PathVariable("bookId") int bookId,@RequestHeader("userEmail")  String email) {

		cartService.deleteBook(email,bookId);

		return "cart item deleted";
	}

	// To remove the cart after placing the cart (or) customer removing cart using
	// customerId
	@GetMapping("removeCart")
	public String removeCart(@RequestHeader("userEmail")  String email) {

		cartService.removeCart(email);

		return "Cart Deleted Successfully";
	}

}

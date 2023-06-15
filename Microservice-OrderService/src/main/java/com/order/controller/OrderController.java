package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.client.BookFeignClient;
import com.order.client.CartFeignClient;
import com.order.dto.Cart;
import com.order.dto.CartItems;
import com.order.entity.Orders;
import com.order.service.OrderItemsService;
import com.order.service.OrdersService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartFeignClient cartFeignClient;

	@Autowired
	private BookFeignClient bookFeignClient;

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrderItemsService orderItemsService;

	@GetMapping("/getOrders")
	public List<Orders> getData() {
		List<Orders> list = ordersService.getOrders();

		return list;
	}

	@GetMapping("/getOrder")
	public List<Orders> getOrder(@RequestHeader("userEmail")  String email) {
		List<Orders> list = ordersService.getOrder(email);
		return list;
	}

	@GetMapping("/completeOrder")
	public String makeOrder(@RequestHeader("userEmail")  String email) {

		Cart cart = cartFeignClient.getCart(email);

		//System.out.println(cart);

		List<CartItems> items = cart.getItems();
		for (CartItems item : items) {
			bookFeignClient.quantityManager(item.getBookId() + "", item.getQuantity());
		}
		ordersService.addOrder(email, cart.getPrice());
		orderItemsService.addOrderItems(email, cart.getItems());

		cartFeignClient.removeCart(email);
		return "Order placed Successfully";
	}

}

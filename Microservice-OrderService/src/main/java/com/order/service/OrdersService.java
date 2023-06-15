package com.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dao.OrderRepository;
import com.order.entity.Orders;

@Service
public class OrdersService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Orders> getOrders() {
		List<Orders> list = orderRepository.findAll();
		return list;

	}

	public void addOrder(String email, float price) {

		Orders o = new Orders();

		o.setEmail(email);
		o.setTotalPrice(price);
		o.setOrderDate(new Date());

		orderRepository.save(o);

	}
	
	public List<Orders> getOrder(String email) {
		List<Orders> list = orderRepository.findAllWithCondition(email);
		return list;

	}
}

package com.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.dao.CartRepository;

@Service
public class CartItemsService {
	
	@Autowired
	private CartRepository cartRepository;
	
	

}

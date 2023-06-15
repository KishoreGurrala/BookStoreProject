package com.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,String>  {
	
}

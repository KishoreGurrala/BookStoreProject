package com.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cart.entity.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems,Integer>{
	
	@Modifying
    @Query(value = "DELETE FROM CartItems WHERE  CUSTOMER_ID = :customerId", nativeQuery = true)
    void deleteByProperty(int customerId);

}

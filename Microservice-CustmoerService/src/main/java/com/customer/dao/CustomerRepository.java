package com.customer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	 @Query(value = "SELECT * FROM CUSTOMERS WHERE EMAIL = :yourProperty", nativeQuery = true)
	 Optional<Customer> findByEmail(String yourProperty);	
}

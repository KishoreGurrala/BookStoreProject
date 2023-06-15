package com.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>{

}

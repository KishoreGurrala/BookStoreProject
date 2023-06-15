package com.order.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart  {
	
	private String email;
	
	private float price;
	
	
	private List<CartItems> items = new ArrayList<CartItems>();

}

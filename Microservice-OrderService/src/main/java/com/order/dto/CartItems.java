package com.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItems {
	private int itemId;
	private String bookTitle;
	private String bookAuthor;
	private float bookPrice;
	private Integer quantity;
	private int bookId;
}

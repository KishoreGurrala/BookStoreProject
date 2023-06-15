package com.cart.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CartItems")
@AllArgsConstructor
@NoArgsConstructor
public class CartItems implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private String bookTitle;
	private String bookAuthor;
	private float bookPrice;
	private Integer quantity;
	private int bookId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private Cart cart;
}

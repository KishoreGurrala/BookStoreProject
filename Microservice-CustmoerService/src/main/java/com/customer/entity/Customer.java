package com.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	

	private String name;

	private String password;

	@Id
	private String email;

	private String contactNumber;

	private String address;
}

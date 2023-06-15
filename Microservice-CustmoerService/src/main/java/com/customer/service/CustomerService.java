package com.customer.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.customer.dao.CustomerRepository;
import com.customer.entity.Customer;
import com.customer.exception.CustomerNotFoundException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	// Registering customer
	public String addCustomer(Customer customer) {
		Customer customer2;
		try {
			 customer2 = customerRepository.findById(customer.getEmail()).get();
		}
		catch(NoSuchElementException e) {
			customer2 = null;
		}
		System.out.println(customer2);
		if (customer2 != null) {
			throw new CustomerNotFoundException("The Customer Aleady Exists with this email : " + customer.getEmail());
		}
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerRepository.save(customer);
		return "You are registered successfully.";
	}

	// for generating token
	public String generateToken(String gmail) {
		return jwtService.generateToken(gmail);
	}

	// Validating token
	public void validatetoken(String token) {
		jwtService.validateToken(token);
	}

	// To get all customers
	public List<Customer> getCustomers() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	// To get customer data with customerID.
	public Customer getCustomer(String email) {
		Customer customer;

		customer = customerRepository.findById(email)
				.orElseThrow(() -> new CustomerNotFoundException("No customer found with the Id: " + email));
		return customer;
	}

}

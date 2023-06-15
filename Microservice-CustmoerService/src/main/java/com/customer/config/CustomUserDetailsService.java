package com.customer.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.customer.dao.CustomerRepository;
import com.customer.entity.Customer;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepository.findByEmail(username);
		return customer.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + username));
	}

}
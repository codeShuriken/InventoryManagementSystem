package com.inventory.postgre.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inventory.postgre.entity.Customer;

public interface CustomersDao {
	
	List<Customer> findAll();
	
	ResponseEntity<Customer> insertCustomer(Customer cust);
	
	//boolean checkCustomer(String CustomerName);

}


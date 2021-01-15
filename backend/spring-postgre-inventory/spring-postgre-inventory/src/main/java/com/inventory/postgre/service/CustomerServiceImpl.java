package com.inventory.postgre.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.postgre.dao.CustomersDao;
import com.inventory.postgre.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	CustomersDao customersDao;
	
	@Override
	public List<Customer> findAll() {
		return customersDao.findAll();
	}
	
	public ResponseEntity<Customer> insertCustomer(Customer cust) {
		return customersDao.insertCustomer(cust);
		
	}

	//@Override
	//public boolean checkCustomer(String CustomerName) {
	//	return customersDao.checkCustomer(CustomerName);
	//}

}



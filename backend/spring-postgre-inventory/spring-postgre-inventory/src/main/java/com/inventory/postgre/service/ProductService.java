package com.inventory.postgre.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inventory.postgre.entity.Product;

public interface ProductService {

	List<Product> findAll();
	
	ResponseEntity<Product> insertOrder(Product prod);

	void updateOrder(Product prod);
	
	void updateInventory(Integer inventory, Integer ProductId);
	
	void updateAfterArrived(Integer ProductId);
	
}



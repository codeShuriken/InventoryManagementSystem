package com.inventory.postgre.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inventory.postgre.entity.Product;

public interface ProductsDao {
	
	List<Product> findAll();

	ResponseEntity<Product> insertOrder(Product prod);

	void updateOrder(Product prod);
	
	Product updateInventory(Integer inventory, Integer ProductId);
	
	Product updateAfterArrived(Integer ProductId);

}


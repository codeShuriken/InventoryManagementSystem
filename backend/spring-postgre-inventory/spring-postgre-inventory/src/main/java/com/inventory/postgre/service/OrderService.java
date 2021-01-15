package com.inventory.postgre.service;


import java.util.List;

import com.inventory.postgre.entity.Order;

public interface OrderService {
	
	List<Order> findAll();
	
	void insertOrder(Order ord);
	
	Integer getOrderID(Integer CustomerId);

}


package com.inventory.postgre.dao;



import java.util.Collection;

import com.inventory.postgre.entity.OrderItem;

public interface OrderItemDao {
	
	Collection<OrderItem> findAll();
	
	void insertItems(OrderItem ordIt);
	
	

}


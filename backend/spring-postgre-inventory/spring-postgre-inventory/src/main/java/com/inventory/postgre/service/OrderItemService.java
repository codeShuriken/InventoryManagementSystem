package com.inventory.postgre.service;





import java.util.Collection;

import com.inventory.postgre.entity.OrderItem;

public interface OrderItemService {
	
	Collection<OrderItem> findAll();
	
	void insertItems(OrderItem ordIt);
	

}


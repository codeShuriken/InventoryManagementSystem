package com.inventory.postgre.dao;


import java.util.List;

import com.inventory.postgre.entity.Order;

public interface OrdersDao {
	
	List<Order> findAll();
	
	void insertOrder(Order ord);
	
	Integer getOrderID(Integer CustomerId);

}

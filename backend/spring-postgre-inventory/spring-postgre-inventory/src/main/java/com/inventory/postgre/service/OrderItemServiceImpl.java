package com.inventory.postgre.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.postgre.dao.OrderItemDao;
import com.inventory.postgre.entity.OrderItem;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired 
	OrderItemDao orderItemDao;
	
	@Override
	public Collection<OrderItem> findAll() {
		return orderItemDao.findAll();
	}
	@Override
	public void insertItems(OrderItem ord) {
		orderItemDao.insertItems(ord);
		
	}
	

}



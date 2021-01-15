package com.inventory.postgre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.postgre.dao.OrdersDao;
import com.inventory.postgre.entity.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired 
	OrdersDao ordersDao;
	
	@Override
	public List<Order> findAll() {
		return ordersDao.findAll();
	}
	@Override
	public void insertOrder(Order ord) {
		ordersDao.insertOrder(ord);
		
	}
	@Override
	public Integer getOrderID(Integer CustomerID) {
		return ordersDao.getOrderID(CustomerID);
	}

}


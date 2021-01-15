package com.inventory.postgre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.postgre.dao.ProductsDao;
import com.inventory.postgre.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductsDao productsDao;
	
	@Override
	public List<Product> findAll() {
		return productsDao.findAll();
	}

	@Override
	public ResponseEntity<Product> insertOrder(Product prod) {
		return productsDao.insertOrder(prod);
		
	}
	@Override
	public void updateOrder(Product prod) {
		productsDao.updateOrder(prod);
		
	}
	@Override
	public void updateInventory(Integer inventory, Integer ProductId) {
		
		Product prod = new Product();
		prod = productsDao.updateInventory(inventory, ProductId);
		productsDao.updateOrder(prod);
	}
	
	public void updateAfterArrived(Integer ProductId) {
		Product prod = new Product();
		prod = productsDao.updateAfterArrived(ProductId);
		productsDao.updateOrder(prod);
	}


}



package com.inventory.postgre.controller;

import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.postgre.entity.Product;
import com.inventory.postgre.entity.Supplier;
import com.inventory.postgre.entity.Supplying;
import com.inventory.postgre.entity.Customer;
import com.inventory.postgre.entity.OrderItem;
import com.inventory.postgre.service.ProductService;
import com.inventory.postgre.service.SupplierService;
import com.inventory.postgre.service.SupplyingService;
import com.inventory.postgre.service.CustomerService;
import com.inventory.postgre.service.OrderItemService;
import com.inventory.postgre.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/postgressApp")
public class ApplicationController {

	@Autowired 
	ProductService productservice;
	@Autowired 
	SupplierService supplierservice;
	@Autowired 
	CustomerService customerservice;
	@Autowired
	OrderService orderservice;
	@Autowired
	OrderItemService orderitemservice;
	@Autowired
	SupplyingService supplyingservice;
	
	@GetMapping(value = "/OrderList")
	public List<Product> getOrders() {
		return productservice.findAll();
	
	}
	
	@PostMapping(value = "/createProd")
	public ResponseEntity<Product> insertOrder(@RequestBody Product prod) {
		return productservice.insertOrder(prod);
	
	}
	@PutMapping(value = "/updateProd")
	public void updateOrder(@RequestBody Product prod) {
		productservice.updateOrder(prod);
	
	}
	
	@GetMapping(value = "/SupplierList")
	public List<Supplier> getSuppliers() {
		return supplierservice.findAll();
	
	}
	
	@PostMapping(value = "/createSupplier")
	public ResponseEntity<Supplier> insertSupplier(@RequestBody Supplier supp) {
		return supplierservice.insertSupplier(supp);
	
	}
	
	@GetMapping(value = "/CustomerList")
	public List<Customer> getCustomers() {
		return customerservice.findAll();
	
	}
	
	@PostMapping(value = "/createCustomer")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer cust) {
		return customerservice.insertCustomer(cust);
	
	}
	
	@PostMapping(value = "/createOrders")
	public void insertItems(@RequestBody OrderItem ordit) {
		orderitemservice.insertItems(ordit);
	
	}
	
	@GetMapping(value = "/getOrders")
	public Collection<OrderItem> getOrderList() {
		return orderitemservice.findAll();
	
	}
	
	@PutMapping(value = "/updateSupplying")
	public void updateSupplying(@RequestBody Supplying supp) {
		supplyingservice.updateSupplying(supp);
	
	}
	
	@GetMapping(value = "/SupplyingLogs")
	public List<Supplying> findSupplierLogs() {
		return supplyingservice.findSupplierLogs();
	
	}	
	
}

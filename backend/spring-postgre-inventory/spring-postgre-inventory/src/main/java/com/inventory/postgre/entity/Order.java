package com.inventory.postgre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	Integer OrderId;
	Integer CustomerId;
	
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public Integer getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Integer customerID) {
		CustomerId = customerID;
	}	
}


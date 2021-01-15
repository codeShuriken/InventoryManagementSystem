package com.inventory.postgre.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

public class Supplying {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	Integer SupplyingId;
	Integer SupplierId;
	Integer ProductId;
	Integer Quantity;
	LocalDate OrderedAt;
	LocalDate ArrivesAt;
	LocalDate ArrivedAt;
	String ProductName;
	String SupplierName;
	
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public Integer getSupplyingId() {
		return SupplyingId;
	}
	public void setSupplyingId(Integer supplyingId) {
		SupplyingId = supplyingId;
	}
	public Integer getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(Integer supplierId) {
		SupplierId = supplierId;
	}
	public Integer getProductId() {
		return ProductId;
	}
	public void setProductId(Integer productId) {
		ProductId = productId;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public LocalDate getOrderedAt() {
		return OrderedAt;
	}
	public void setOrderedAt(LocalDate orderedAt) {
		OrderedAt = orderedAt;
	}
	public LocalDate getArrivesAt() {
		return ArrivesAt;
	}
	public void setArrivesAt(LocalDate arrivesAt) {
		ArrivesAt = arrivesAt;
	}
	public LocalDate getArrivedAt() {
		return ArrivedAt;
	}
	public void setArrivedAt(LocalDate arrivedAt) {
		ArrivedAt = arrivedAt;
	}
	
	
}


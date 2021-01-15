package com.inventory.postgre.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	Integer SupplierId;
	String SupplierName;
	String SupplierAddress;
	
	
	public Integer getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(Integer supplierId) {
		SupplierId = supplierId;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getSupplierAddress() {
		return SupplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		SupplierAddress = supplierAddress;
	}
}


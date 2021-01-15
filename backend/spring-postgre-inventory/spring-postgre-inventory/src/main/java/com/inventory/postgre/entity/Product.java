package com.inventory.postgre.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	Integer productId;
	String productName;
	Integer inventoryReceived;
	Integer inventoryShipped;
	Integer inventoryOnHand;
	Integer minInventoryReq;
	String productDesc;
	Integer supplierID;
	String SupplierName;
	Integer Quantity;
	

	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getInventoryReceived() {
		return inventoryReceived;
	}
	public void setInventoryReceived(Integer inventoryReceived) {
		this.inventoryReceived = inventoryReceived;
	}
	public Integer getInventoryShipped() {
		return inventoryShipped;
	}
	public void setInventoryShipped(Integer inventoryShipped) {
		this.inventoryShipped = inventoryShipped;
	}
	public Integer getInventoryOnHand() {
		return inventoryOnHand;
	}
	public void setInventoryOnHand(Integer inventoryOnHand) {
		this.inventoryOnHand = inventoryOnHand;
	}
	public Integer getMinInventoryReq() {
		return minInventoryReq;
	}
	public void setMinInventoryReq(Integer minInventoryReq) {
		this.minInventoryReq = minInventoryReq;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}
	
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
		
}


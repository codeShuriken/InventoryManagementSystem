package com.inventory.postgre.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inventory.postgre.entity.Supplier;

public interface SuppliersDao {
	
	List<Supplier> findAll();
	
	ResponseEntity<Supplier> insertSupplier(Supplier supp);
	
//	boolean checkSupplier(String SupplierName);

}

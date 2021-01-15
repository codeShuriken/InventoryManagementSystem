package com.inventory.postgre.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inventory.postgre.entity.Supplier;

public interface SupplierService {
	
	List<Supplier> findAll();
	
	ResponseEntity<Supplier> insertSupplier(Supplier supp);
	
//	boolean checkSupplier(String SupplierName);

}

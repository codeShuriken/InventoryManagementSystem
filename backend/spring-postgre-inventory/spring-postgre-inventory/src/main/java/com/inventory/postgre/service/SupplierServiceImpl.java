package com.inventory.postgre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.postgre.dao.SuppliersDao;
import com.inventory.postgre.entity.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired 
	SuppliersDao suppliersDao;
	
	@Override
	public List<Supplier> findAll() {
		return suppliersDao.findAll();
	}
	
	public ResponseEntity<Supplier> insertSupplier(Supplier supp) {
		return suppliersDao.insertSupplier(supp);
		
	}

	/*@Override
	public boolean checkSupplier(String SupplierName) {
		return suppliersDao.checkSupplier(SupplierName);
	}*/

}

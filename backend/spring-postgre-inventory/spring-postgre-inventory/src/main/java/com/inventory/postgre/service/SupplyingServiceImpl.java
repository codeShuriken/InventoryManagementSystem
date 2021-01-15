package com.inventory.postgre.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.inventory.postgre.dao.SupplyingDao;
import com.inventory.postgre.entity.Supplying;

@Service
public class SupplyingServiceImpl implements SupplyingService{

	@Autowired 
	@Lazy
	SupplyingDao supplyingDao;
	

	public void insertSupplier(Integer SupplierId, Integer ProductId, Integer Quantity, LocalDate OrderedAt,  LocalDate ArrivesAt){
		Supplying supp = new Supplying();
		supp.setArrivesAt(ArrivesAt);
		supp.setOrderedAt(OrderedAt);
		supp.setProductId(ProductId);
		supp.setQuantity(Quantity);
		supp.setSupplierId(SupplierId);
		supplyingDao.insertSupplying(supp);
		
	}
	
	public void updateSupplying(Supplying supp) {
		supplyingDao.updateSupplying(supp);
	}
	
	public List<Supplying> findSupplierLogs(){
		return supplyingDao.findSupplierLogs();
	}

}



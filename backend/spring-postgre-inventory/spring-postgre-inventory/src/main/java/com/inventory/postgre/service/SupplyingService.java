package com.inventory.postgre.service;


import java.time.LocalDate;
import java.util.List;

import com.inventory.postgre.entity.Supplying;

public interface SupplyingService {
	

	
	void insertSupplier(Integer SupplierId, Integer ProductId, Integer Quantity, LocalDate OrderedAt,  LocalDate ArrivesAt);
	void updateSupplying(Supplying supp);
	List<Supplying> findSupplierLogs();

}


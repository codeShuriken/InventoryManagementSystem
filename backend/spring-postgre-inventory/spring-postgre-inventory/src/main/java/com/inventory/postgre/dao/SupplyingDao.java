package com.inventory.postgre.dao;


import java.util.List;

import com.inventory.postgre.entity.Supplying;

public interface SupplyingDao {
	
	
	void insertSupplying(Supplying supp);
	
	void updateSupplying(Supplying supp);
	
	List<Supplying> findSupplierLogs();

}


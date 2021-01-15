package com.inventory.postgre.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.inventory.postgre.entity.Supplier;

public class SupplierRowMapper implements RowMapper<Supplier> {

	public Supplier mapRow(ResultSet rs, int arg1) throws SQLException {
		Supplier supp = new Supplier();
		supp.setSupplierId(rs.getInt("supplierId"));
		supp.setSupplierAddress(rs.getString("supplierAddress"));
		supp.setSupplierName(rs.getString("supplierName"));
        return supp;
	}
}

package com.inventory.postgre.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;
import com.inventory.postgre.entity.Product;
import com.inventory.postgre.entity.Supplier;
import com.inventory.postgre.entity.Supplying;

public class SupplyingRowMapper implements RowMapper<Supplying> {

	public Supplying mapRow(ResultSet rs, int arg1) throws SQLException {
		Product prod = new Product();
		Supplier supp = new Supplier();
		Supplying supplying = new Supplying();
		LocalDate arrivedat = rs.getDate("arrivedat") == null ? null : rs.getDate("arrivedat").toLocalDate();
		LocalDate arrivesat = rs.getDate("arrivesat") == null ? null : rs.getDate("arrivesat").toLocalDate();
		LocalDate orderedat = rs.getDate("orderedat") == null ? null : rs.getDate("orderedat").toLocalDate();

		supplying.setArrivesAt(arrivesat);
		supplying.setArrivedAt(arrivedat);
		supplying.setOrderedAt(orderedat);
		supplying.setQuantity(rs.getInt("Quantity"));
		supplying.setSupplyingId(rs.getInt("SupplyingId"));
		supp.setSupplierName(rs.getString("supplierName"));
		supplying.setSupplierName(supp.getSupplierName());
		supplying.setSupplierId(rs.getInt("SupplierId"));
		supplying.setProductId(rs.getInt("ProductId"));
		prod.setProductName(rs.getString("productName"));
		supplying.setProductName(prod.getProductName());
		
        return supplying;
	}
}


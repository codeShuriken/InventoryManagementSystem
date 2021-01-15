package com.inventory.postgre.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.inventory.postgre.entity.Product;
import com.inventory.postgre.entity.Supplier;

public class ProductRowMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int arg1) throws SQLException {
		Product prod = new Product();
		Supplier supp = new Supplier();
		prod.setProductId(rs.getInt("productId"));
		prod.setProductName(rs.getString("productName"));
		prod.setInventoryReceived(rs.getInt("inventoryReceived"));
		prod.setInventoryShipped(rs.getInt("inventoryShipped"));
		prod.setInventoryOnHand(rs.getInt("inventoryOnHand"));
		prod.setMinInventoryReq(rs.getInt("minInventoryReq"));
		prod.setProductDesc(rs.getString("productDesc"));
		prod.setSupplierID(rs.getInt("supplierID"));
		supp.setSupplierName(rs.getString("supplierName"));
		prod.setSupplierName(supp.getSupplierName());
        return prod;
	}
}



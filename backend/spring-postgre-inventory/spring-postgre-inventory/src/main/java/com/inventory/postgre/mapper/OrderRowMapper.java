package com.inventory.postgre.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.inventory.postgre.entity.Order;

public class OrderRowMapper implements RowMapper<Order> {

	public Order mapRow(ResultSet rs, int arg1) throws SQLException {
		Order ord = new Order();
		ord.setOrderId(rs.getInt("orderId"));
		ord.setCustomerId(rs.getInt("customerId"));
        return ord;
	}
}



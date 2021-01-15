package com.inventory.postgre.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.inventory.postgre.entity.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
		Customer cust = new Customer();
		cust.setCustomerId(rs.getInt("customerId"));
		cust.setCustomerAddress(rs.getString("customerAddress"));
		cust.setCustomerName(rs.getString("customerName"));
        return cust;
	}
}


package com.inventory.postgre.dao;

import java.util.Collections;
import java.util.List;


import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.inventory.postgre.entity.Order;
import com.inventory.postgre.mapper.OrderRowMapper;
@Repository
public class OrdersDaoImpl implements OrdersDao{

	public OrdersDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Order> findAll() {
		return template.query("select * from orders", new OrderRowMapper());
	}
	
	@Override
	public void insertOrder(Order ord) {
		 final String sql = "insert into orders(CustomerID) values(:CustomerID)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("CustomerID", ord.getCustomerId());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public Integer getOrderID(Integer CustomerId) {
		String query = "select orderid from orders where customerid = :customerid"; 
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("customerid", CustomerId);
		List<Integer> orderId = template.queryForList(query, param, Integer.class);
		return Collections.max(orderId);
		
	}

	
}


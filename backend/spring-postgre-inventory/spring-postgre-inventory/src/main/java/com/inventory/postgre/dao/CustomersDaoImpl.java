package com.inventory.postgre.dao;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.inventory.postgre.entity.Customer;
import com.inventory.postgre.mapper.CustomerRowMapper;
@Repository
public class CustomersDaoImpl implements CustomersDao{

	public CustomersDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Customer> findAll() {
		return template.query("select * from customer", new CustomerRowMapper());
	}
	
	@Override
	public ResponseEntity<Customer> insertCustomer(Customer cust) {
		
		String query = "select count(*) from customer where lower(customername) = lower(:CustomerName) and lower(customeraddress) = lower(:CustomerAddress)";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("CustomerName", cust.getCustomerName())
				.addValue("CustomerAddress", cust.getCustomerAddress());
		Integer cnt = template.queryForObject(
				query, param, Integer.class);
		System.out.println("Cuatomer Name is" + cust.getCustomerName());
		System.out.println("Cuatomer Name is" + cust.getCustomerAddress());
		System.out.println("Cuatomer Name is" + cnt);
	if(cnt == 0) {
		 final String sql = "insert into customer(CustomerName, CustomerAddress) values(:CustomerName, :CustomerAddress)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource parameter = new MapSqlParameterSource()
					.addValue("CustomerName", cust.getCustomerName())
					.addValue("CustomerAddress", cust.getCustomerAddress());
	        template.update(sql,parameter, holder);
	       
		 }
	else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	//@Override
	/*public boolean checkCustomer(String CustomerName) {
		String query = "select count(*) from customer where lower(customername) = lower(:CustomerName)";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("CustomerName", CustomerName);
		Integer cnt = template.queryForObject(
				query, param, Integer.class);
			return cnt == 0 ? true : false;
	}*/
	
}


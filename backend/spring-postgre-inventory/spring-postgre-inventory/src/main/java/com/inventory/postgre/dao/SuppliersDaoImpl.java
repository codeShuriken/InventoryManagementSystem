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

import com.inventory.postgre.entity.Supplier;
import com.inventory.postgre.mapper.SupplierRowMapper;
@Repository
public class SuppliersDaoImpl implements SuppliersDao{

	public SuppliersDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Supplier> findAll() {
		return template.query("select * from supplier", new SupplierRowMapper());
	}
	
	@Override
	public ResponseEntity<Supplier> insertSupplier(Supplier supp) {
		String query = "select count(*) from supplier where lower(suppliername) = lower(:SupplierName)";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("SupplierName", supp.getSupplierName());
//
		Integer cnt = template.queryForObject(
				query, param, Integer.class);
			
		if(cnt == 0) {
		 final String sql = "insert into supplier(SupplierName, SupplierAddress) values(:SupplierName,:SupplierAddress)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("SupplierName", supp.getSupplierName())
					.addValue("SupplierAddress", supp.getSupplierAddress());
	        template.update(sql,parameters, holder);
		}
		else 
			 return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Supplier>(HttpStatus.OK);
	 
	}
	
}

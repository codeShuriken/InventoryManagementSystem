package com.inventory.postgre.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.inventory.postgre.entity.Product;
import com.inventory.postgre.entity.Supplying;
import com.inventory.postgre.mapper.SupplyingRowMapper;
import com.inventory.postgre.service.ProductService;
@Repository
public class SupplyingDaoImpl implements SupplyingDao {
	@Autowired
	ProductService productservice;
	public SupplyingDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template; 
	
	@Override
	public void insertSupplying(Supplying supp) {
		 final String sql = "insert into supplying(SupplierId, ProductId, Quantity, OrderedAt, ArrivesAt) values(:SupplierId,:ProductId,:Quantity, :OrderedAt, :ArrivesAt)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("SupplierId", supp.getSupplierId())
					.addValue("ProductId", supp.getProductId())
					.addValue("Quantity", supp.getQuantity())
					.addValue("OrderedAt", supp.getOrderedAt())
					.addValue("ArrivesAt", supp.getArrivesAt());
	        template.update(sql,param, holder);
		
	}
	
	public void updateSupplying(Supplying supp) {
		final String sql = "update supplying set arrivedat=:arrivedat, arrivesat=:arrivesat where productId=:productId and arrivedat is null";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
        		.addValue("productId", supp.getProductId())
        		.addValue("arrivesat", LocalDate.now())
				.addValue("arrivedat", LocalDate.now());
        template.update(sql,param, holder);
        

        Integer ProductId = supp.getProductId();
        productservice.updateAfterArrived(ProductId);
        
	}
	
	public List<Supplying> findSupplierLogs(){
		return template.query("select * from supplying natural join product natural join supplier", new SupplyingRowMapper());
	}
	}


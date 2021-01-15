package com.inventory.postgre.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import com.inventory.postgre.entity.Product;
import com.inventory.postgre.mapper.ProductRowMapper;
import com.inventory.postgre.service.SupplyingService;
@Repository
public class ProductsDaoImpl implements ProductsDao{
	
	@Autowired
	SupplyingService supplyingservice;
	
	public ProductsDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Product> findAll() {
		return template.query("select * from product natural join supplier", new ProductRowMapper());
	}
	@Override
	public ResponseEntity<Product> insertOrder(Product prod) {
		
		String query = "select count(*) from product where lower(productname) = lower(:ProductName)";
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("ProductName", prod.getProductName());
		Integer cnt = template.queryForObject(
				query, parameters, Integer.class);
			
		if(cnt == 0) {
		 final String sql = "insert into product(productName, inventoryReceived, inventoryShipped, inventoryOnHand, minInventoryReq, productDesc, supplierID) values(:productName,:inventoryReceived,:inventoryShipped, :inventoryOnHand, :minInventoryReq, :productDesc, :supplierID)";
		 
		 	Integer InvReceived = prod.getInventoryOnHand();
		 	System.out.println("Inventory Received is" + InvReceived);
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("productName", prod.getProductName())
					.addValue("inventoryReceived", InvReceived)
					.addValue("inventoryShipped", prod.getInventoryShipped())
					.addValue("inventoryOnHand", prod.getInventoryOnHand())
					.addValue("minInventoryReq", prod.getMinInventoryReq())
					.addValue("productDesc", prod.getProductDesc())
					.addValue("supplierID", prod.getSupplierID());
	        template.update(sql,param, holder);
		}
		else
			 return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Product>(HttpStatus.OK);
	 
	}
	
	@Override
	public void updateOrder(Product prod) {
		 final String sql = "update product set productName=:productName, inventoryReceived=:inventoryReceived, inventoryShipped=:inventoryShipped, inventoryOnHand=:inventoryOnHand, minInventoryReq=:minInventoryReq, productDesc=:productDesc, supplierID=:supplierID where productId=:productId";
		 
		 System.out.println("Product Id during Updation is" + prod.getProductId());
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
	        		.addValue("productId", prod.getProductId())
					.addValue("productName", prod.getProductName())
					.addValue("inventoryReceived", prod.getInventoryReceived())
					.addValue("inventoryShipped", prod.getInventoryShipped())
					.addValue("inventoryOnHand", prod.getInventoryOnHand())
					.addValue("minInventoryReq", prod.getMinInventoryReq())
					.addValue("productDesc", prod.getProductDesc())
					.addValue("supplierID", prod.getSupplierID());
	        template.update(sql,param, holder);	 
	 
	}
	
	public Product updateInventory(Integer inventory, Integer ProductId) {
		
		String query = "select * from product where productId =" + ProductId;
		System.out.println("The Product Id that came here is" + ProductId);
		Product prod = new Product();
		prod = template.query(query, new ResultSetExtractor<Product>(){
			 @Override 
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException{
			            Product prod = new Product();
			            
			            if(rs.next()) {
			            prod.setProductId(rs.getInt("productId"));
			            System.out.println("xyz" + prod.getProductId());
			    		prod.setProductName(rs.getString("productName"));
			    		System.out.println("xyz" + prod.getProductName());
			    		prod.setInventoryReceived(rs.getInt("inventoryReceived"));
			    		System.out.println("xyz" + prod.getInventoryReceived());
			            prod.setInventoryOnHand(rs.getInt("inventoryOnHand"));
			            prod.setInventoryShipped(rs.getInt("inventoryShipped"));
			            prod.setMinInventoryReq(rs.getInt("minInventoryReq"));
			            prod.setProductDesc(rs.getString("productDesc"));
			            prod.setSupplierID(rs.getInt("supplierID"));
			            }
				 return prod;
			}
		});
		Integer InitialInvOnHand = prod.getInventoryOnHand();
		Integer InvOnHand = prod.getInventoryOnHand() - inventory ;
		Integer InvShipped = prod.getInventoryShipped() + inventory;
		
		if(InitialInvOnHand >= prod.getMinInventoryReq() && InvOnHand < prod.getMinInventoryReq()) {
			 Integer SupplierId = prod.getSupplierID();
			 Integer RequiredId = prod.getProductId();
			 System.out.println("Required" + prod.getProductId());
			 Integer Quantity = prod.getMinInventoryReq();
			 LocalDate OrderedAt =  LocalDate.now(); 
			 LocalDate ArrivesAt = LocalDate.now().plusDays(5);
			 
			supplyingservice.insertSupplier(SupplierId, RequiredId, Quantity, OrderedAt, ArrivesAt); 
			 
		}
		
		prod.setInventoryOnHand(InvOnHand);
		prod.setInventoryShipped(InvShipped);
		
		return prod;
		
	}
	
	
	public Product updateAfterArrived(Integer ProductId) {
		String query = "select * from product where productId =" + ProductId;
		System.out.println("The Product Id that came here is" + ProductId);
		Product prod = new Product();
		prod = template.query(query, new ResultSetExtractor<Product>(){
			 @Override 
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException{
			            Product prod = new Product();
			            
			            if(rs.next()) {
			            prod.setProductId(rs.getInt("productId"));
			            System.out.println("xyz" + prod.getProductId());
			    		prod.setProductName(rs.getString("productName"));
			    		System.out.println("xyz" + prod.getProductName());
			    		prod.setInventoryReceived(rs.getInt("inventoryReceived"));
			    		System.out.println("xyz" + prod.getInventoryReceived());
			            prod.setInventoryOnHand(rs.getInt("inventoryOnHand"));
			            prod.setInventoryShipped(rs.getInt("inventoryShipped"));
			            prod.setMinInventoryReq(rs.getInt("minInventoryReq"));
			            prod.setProductDesc(rs.getString("productDesc"));
			            prod.setSupplierID(rs.getInt("supplierID"));
			            }
				 return prod;
			}
		});
		
		Integer InvOnHand = prod.getInventoryOnHand() + prod.getMinInventoryReq() ;
		Integer InvReceived = prod.getInventoryReceived() + prod.getMinInventoryReq();
		
		prod.setInventoryOnHand(InvOnHand);
		prod.setInventoryReceived(InvReceived);
		
		return prod;
	}
		
	
}






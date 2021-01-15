package com.inventory.postgre.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.inventory.postgre.entity.OrderItem;
import com.inventory.postgre.entity.Product;
import com.inventory.postgre.entity.Customer;
import com.inventory.postgre.entity.Order;
import com.inventory.postgre.service.OrderService;
import com.inventory.postgre.service.ProductService;
@Repository
public class OrderItemDaoImpl implements OrderItemDao{

	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productservice;
	
	public OrderItemDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public Collection<OrderItem> findAll() {
		return template.query("select orderitem.quantity, product.productname, orderitem.orderid, customer.customername from orderitem,orders,customer,product where orderitem.orderid = orders.orderid and orderitem.productid = product.productid and orders.customerid = customer.customerid", new ResultSetExtractor<Collection<OrderItem>>() {
			 @Override 
			public Collection<OrderItem> extractData(ResultSet rs) throws SQLException, DataAccessException{

				Map<Integer, OrderItem> OrderItemMap = new HashMap<>();
				 while(rs.next()){
			            Order order = new Order();
			            Product prod = new Product();
			            Customer cust =  new Customer();
			            order.setOrderId(rs.getInt("orderid"));
			            prod.setQuantity(rs.getInt("quantity"));
			            prod.setProductName(rs.getString("productname"));
			            cust.setCustomerName(rs.getString("customername"));
			            
			            Integer OrderId = rs.getInt("orderid");
			           
			            OrderItem orditem = OrderItemMap.get(OrderId);

			            if (orditem == null) {
			            	OrderItem ordit = new OrderItem();
			            	List<Product>prodlist = new ArrayList<Product>();
			            	prodlist.add(prod);
			            	ordit.setOrder(order);
			            	ordit.setProduct(prodlist);
			            	ordit.setCustomer(cust);
			            	OrderItemMap.put(OrderId, ordit);
			            }else {
			            	List<Product>prodlist = orditem.getProduct();
			            	prodlist.add(prod);
			        }
			        
			    }
				 return OrderItemMap.values();
			}
		});
	}
	
	@Override
	public void insertItems(OrderItem ordIt) {

		
		Order order = new Order();
		
		Customer customer = new Customer();
		
		customer = ordIt.getCustomer();
		order.setCustomerId(customer.getCustomerId());
		orderService.insertOrder(order);
		
		 List<Product> product = new ArrayList<Product>();
		Integer CustomerId = customer.getCustomerId();
		Integer OrderId = orderService.getOrderID(CustomerId);
		
		product = ordIt.getProduct();
		
		for(int i = 0; i < product.size(); i++) {
			
			final String sql = "insert into orderitem(ProductId, quantity, OrderId) values(:ProductId, :quantity, :OrderId)";
			 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("ProductId", (product.get(i)).getProductId())
					.addValue("quantity", (product.get(i)).getQuantity())
					.addValue("OrderId", OrderId);
	        template.update(sql,param, holder);
	        
	        Integer inventory = (product.get(i)).getQuantity();
	        Integer ProductId = (product.get(i)).getProductId();
	        
	        System.out.println("ProductID is" + ProductId);
	        productservice.updateInventory(inventory, ProductId);
		}
	 
	}
	
}


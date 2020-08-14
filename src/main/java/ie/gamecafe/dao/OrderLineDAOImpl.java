package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Bill;
import ie.gamecafe.model.OrderLine;

public class OrderLineDAOImpl implements OrderLineDAO{

	private JdbcTemplate jdbcTemplate;
	
	public OrderLineDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(OrderLine orderLine) {
			
		OrderLine existOrder = new OrderLine();
		existOrder = get(orderLine.getOrderId(), orderLine.getItemId());
		
		if (!(existOrder == null)) {
		        // update
		        String sql = "UPDATE order_line SET  quantity=? WHERE order_id=? AND item_id=?";
		        jdbcTemplate.update(sql, orderLine.getQuantity(), orderLine.getOrderId(), orderLine.getItemId());
		        		        
		    } else {
		        // insert
		        String sql = "INSERT INTO order_line ( order_id, item_id, quantity)"
		                    + " VALUES (?, ?, ?)";
		        jdbcTemplate.update(sql, orderLine.getOrderId(), orderLine.getItemId(), orderLine.getQuantity());
		        
		    }
	}

	@Override
	public void delete(int orderId, int itemId) {
		
		String sql = "DELETE FROM order_line WHERE order_id=? AND item_id=?";
	    jdbcTemplate.update(sql, orderId, itemId);	
	}

	@Override
	public void deleteAll(int orderId) {
		
		String sql = "DELETE FROM order_line WHERE order_id=?";
	    jdbcTemplate.update(sql, orderId);	
	}
	
	@Override
	public OrderLine get(int orderId, int itemId) {
		
	String sql = "SELECT * FROM order_line WHERE order_id=" + orderId + " AND item_id=" + itemId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<OrderLine>() {
	 
	        @Override
	        public OrderLine extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                OrderLine orderLine = new OrderLine();
	                
	                orderLine.setOrderId(rs.getInt("order_id"));
		            orderLine.setItemId(rs.getInt("item_id"));
		            orderLine.setQuantity(rs.getInt("quantity"));
		         
		     
		            return orderLine;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<OrderLine> list() {
		
		String sql = "SELECT * FROM order_line";
	    List<OrderLine> listOrderLine = jdbcTemplate.query(sql, new RowMapper<OrderLine>() {
	 
	        @Override
	        public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	
	            OrderLine allOrderLine = new OrderLine();
	 
	            allOrderLine.setOrderId(rs.getInt("order_id"));
	            allOrderLine.setItemId(rs.getInt("item_id"));
	            allOrderLine.setQuantity(rs.getInt("quantity"));
	     
	            return allOrderLine;
	        }
	 
	    });
	 
	    return listOrderLine;
	}
	
	@Override
	public List<OrderLine> listById(int orderId) {
		
		String sql = "SELECT * FROM order_line  WHERE order_id=" + orderId;
	    List<OrderLine> listById = jdbcTemplate.query(sql, new RowMapper<OrderLine>() {
	 
	        @Override
	        public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	
	            OrderLine allOrderLine = new OrderLine();
	 
	            allOrderLine.setOrderId(rs.getInt("order_id"));
	            allOrderLine.setItemId(rs.getInt("item_id"));
	            allOrderLine.setQuantity(rs.getInt("quantity"));
	     
	            return allOrderLine;
	        }
	 
	    });
	 
	    return listById;
	}
	
	@Override
	public List<Bill> printBill(int orderId) {
					
			String sql = "SELECT order_line.item_id, order_line.quantity, item.name, item.price" +
			" FROM order_line INNER JOIN item ON order_line.item_id = item.item_id WHERE order_id =" + orderId ;
			
					
		    List<Bill> printBill = jdbcTemplate.query(sql, new RowMapper<Bill>() {
		 
		        @Override
		        public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Bill bill = new Bill();
		 
		            bill.setItemId(rs.getInt("item_id"));
		            bill.setQuantity(rs.getInt("quantity"));
		            bill.setName(rs.getString("name"));
		            bill.setPrice(rs.getDouble("price"));
		            bill.setOrderId(orderId);


		            return bill;
		        }
		 
		    });
		 
		    return printBill;
		}
}

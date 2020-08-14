package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.PlacedOrder;

public class PlacedOrderDAOImpl implements PlacedOrderDAO {

	private JdbcTemplate jdbcTemplate;
	
	public PlacedOrderDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(PlacedOrder placedOrder) {
		
		 if (placedOrder.getId() > 0) {
		        // update
		        String sql = "UPDATE placed_order SET  staff_id=?, booking_id=? WHERE order_id=?";
		        jdbcTemplate.update(sql, placedOrder.getStaffId(), placedOrder.getBookingId(), placedOrder.getId());
		    } else {
		        // insert
		        String sql = "INSERT INTO placed_order ( staff_id, booking_id)"
		                    + " VALUES (?, ?)";
		        jdbcTemplate.update(sql, placedOrder.getStaffId(), placedOrder.getBookingId());
		    }
		
	}

	@Override
	public void delete(int placedOrderId) {
		
		String sql = "DELETE FROM placed_order WHERE order_id=?";
	    jdbcTemplate.update(sql, placedOrderId);	
		
	}

	@Override
	public PlacedOrder get(int placedOrderId) {
		
		String sql = "SELECT * FROM placed_order WHERE order_id=" + placedOrderId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<PlacedOrder>() {
	 
	        @Override
	        public PlacedOrder extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                PlacedOrder placedOrder = new PlacedOrder();
	                
	                placedOrder.setId(rs.getInt("order_id"));
		            placedOrder.setStaffId(rs.getInt("staff_id"));
		            placedOrder.setBookingId(rs.getInt("booking_id"));
		         
		     
		            return placedOrder;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<PlacedOrder> list() {
		
		String sql = "SELECT * FROM placed_order";
	    List<PlacedOrder> listPlacedOrder = jdbcTemplate.query(sql, new RowMapper<PlacedOrder>() {
	 
	        @Override
	        public PlacedOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	
	            PlacedOrder allPlacedOrder = new PlacedOrder();
	 
	            allPlacedOrder.setId(rs.getInt("order_id"));
	            allPlacedOrder.setStaffId(rs.getInt("staff_id"));
	            allPlacedOrder.setBookingId(rs.getInt("booking_id"));
	     
	            return allPlacedOrder;
	        }
	 
	    });
	 
	    return listPlacedOrder;
	}
	
	@Override
	public int lastOrderId() {
		
		String sql = "SELECT MAX(order_id) FROM `placed_order`";
		
		@SuppressWarnings("deprecation")
		int lastOrderId =jdbcTemplate.queryForInt(sql);
		
		return lastOrderId;
		
	}
	
	@Override
	public int staffId(int orderId) {
		
		String sql = "SELECT staff_id FROM `placed_order` WHERE order_id=" + orderId;
		
		@SuppressWarnings("deprecation")
		int staffId =jdbcTemplate.queryForInt(sql);
		
		return staffId;
		
	}
	
	@Override
	public int noOrderCheck(int bookingId) {
		String sql = "SELECT COUNT(*) FROM placed_order WHERE booking_id=" + bookingId;

		@SuppressWarnings("deprecation")

		int count = jdbcTemplate.queryForInt(sql);

		return count;
	}
}

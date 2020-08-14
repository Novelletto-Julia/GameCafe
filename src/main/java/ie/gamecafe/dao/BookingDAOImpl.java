package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Booking;
import ie.gamecafe.model.BookingInformation;


public class BookingDAOImpl implements BookingDAO {

	private JdbcTemplate jdbcTemplate;
	
	public BookingDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Booking booking) {

		 if (booking.getId() > 0) {
		        // update
		        String sql = "UPDATE booking SET  booking_fee=?, food_service=?, customer_id=? WHERE booking_id=?";
		        jdbcTemplate.update(sql, booking.getBookingFee(), booking.getFoodService(), booking.getCustomerId(), booking.getId());
		    } else {
		        // insert
		        String sql = "INSERT INTO booking ( booking_fee, food_service, customer_id)"
		                    + " VALUES (?, ?, ?)";
		        jdbcTemplate.update(sql, booking.getBookingFee(), booking.getFoodService(), booking.getCustomerId());
		    }
	}

	@Override
	public void delete(int bookingId) {
		 String sql = "DELETE FROM booking WHERE booking_id=?";
		    jdbcTemplate.update(sql, bookingId);
	}

	@Override
	public Booking get(int bookingId) {
		
	String sql = "SELECT * FROM booking WHERE booking_id=" + bookingId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Booking>() {
	 
	        @Override
	        public Booking extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Booking booking = new Booking();
	                
	                booking.setId(rs.getInt("booking_id"));
		            booking.setBookingFee(rs.getDouble("booking_fee"));
		            booking.setFoodService(rs.getString("food_service"));
		            booking.setCustomerId(rs.getInt("customer_id"));
		     
		            return booking;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Booking> list() {
		
		String sql = "SELECT * FROM booking";
	    List<Booking> listBooking = jdbcTemplate.query(sql, new RowMapper<Booking>() {
	 
	        @Override
	        public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Booking allBooking = new Booking();
	 
	            allBooking.setId(rs.getInt("booking_id"));
	            allBooking.setBookingFee(rs.getDouble("booking_fee"));
	            allBooking.setFoodService(rs.getString("food_service"));
	            allBooking.setCustomerId(rs.getInt("customer_id"));
	     
	            return allBooking;
	        }
	 
	    });
	 
	    return listBooking;
	}
	
	@Override
	public int lastBookingId() {
		
		String sql = "SELECT MAX(booking_id) FROM `booking`";
		
		@SuppressWarnings("deprecation")
		int lastBookingId =jdbcTemplate.queryForInt(sql);
		
		return lastBookingId;
		
	}

	@Override
	public List<BookingInformation> viewAllBookings() {
					
			String sql = "SELECT booking.booking_id, slot.date, slot.day_period, booking.food_service, slot.table_id, booking.customer_id, booking.booking_fee" +
			" FROM booking INNER JOIN slot ON booking.booking_id = slot.booking_id" + " ORDER BY slot.date";
			
					
		    List<BookingInformation> listBooking = jdbcTemplate.query(sql, new RowMapper<BookingInformation>() {
		 
		        @Override
		        public BookingInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
		            BookingInformation booking = new BookingInformation();
		 
		            booking.setBookingId(rs.getInt("booking_id"));
		            booking.setBookingFee(rs.getDouble("booking_fee"));
		            booking.setFoodService(rs.getString("food_service"));
		            booking.setCustomerId(rs.getInt("customer_id"));
		            booking.setDate(rs.getString("date"));
		            booking.setPeriod(rs.getString("day_period"));
		            booking.setTableId(rs.getInt("table_id"));
		     
		            return booking;
		        }
		 
		    });
		 
		    return listBooking;
		}
	
	@Override
	public List<BookingInformation> customerAllBookings(int customerId) {
					
			String sql = "SELECT booking.booking_id, slot.date, slot.day_period, booking.food_service, booking.customer_id, booking.booking_fee" +
			" FROM booking INNER JOIN slot ON booking.booking_id = slot.booking_id WHERE customer_id =" + customerId 
					+ " ORDER BY slot.date";
			
					
		    List<BookingInformation> listBooking = jdbcTemplate.query(sql, new RowMapper<BookingInformation>() {
		 
		        @Override
		        public BookingInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
		            BookingInformation booking = new BookingInformation();
		 
		            booking.setBookingId(rs.getInt("booking_id"));
		            booking.setBookingFee(rs.getDouble("booking_fee"));
		            booking.setFoodService(rs.getString("food_service"));
		            booking.setCustomerId(rs.getInt("customer_id"));
		            booking.setDate(rs.getString("date"));
		            booking.setPeriod(rs.getString("day_period"));

		            return booking;
		        }
		 
		    });
		 
		    return listBooking;
		}
	}
	


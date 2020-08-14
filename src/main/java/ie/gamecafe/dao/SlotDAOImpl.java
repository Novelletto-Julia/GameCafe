package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Slot;

public class SlotDAOImpl implements SlotDAO{

private JdbcTemplate jdbcTemplate;
	
	public SlotDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Slot slot) {
					
		 	if (slot.getOldTableId() > 0) { 
				// UPDATE
				String sql = "UPDATE slot SET date =?, day_period =?, table_id =? "
						+ "WHERE date =? AND day_period =? AND table_id =?";
				jdbcTemplate.update(sql, slot.getDate(), slot.getDayPeriod(), slot.getTableId(), slot.getOldDate(),
						slot.getOldDayPeriod(), slot.getOldTableId());
			} else {
		        // insert
		        String sql = "INSERT INTO slot (date, day_period, table_id, booking_id)"
		                    + " VALUES (?, ?, ?, ?)";
		        jdbcTemplate.update(sql, slot.getDate(), slot.getDayPeriod(), slot.getTableId(), slot.getBookingId());
		        
		    }
	}

	@Override
	public void delete(String date, String dayPeriod, int tableId) {
		
		String sql = "DELETE FROM slot WHERE date=? AND day_period=? AND table_id=?";
	    jdbcTemplate.update(sql, date, dayPeriod, tableId);	
	}

	@Override
	public Slot get(String date, String dayPeriod, int tableId) {
		
		String sql = "SELECT * FROM `slot` WHERE date=" + date + " AND day_period='" + dayPeriod + "' AND table_id=" + tableId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Slot>() {
	 
	        @Override
	        public Slot extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Slot slot = new Slot();
	                
	                slot.setDate(rs.getString("date"));
	                slot.setDayPeriod(rs.getString("day_period"));
	                slot.setTableId(rs.getInt("table_id"));
	                slot.setBookingId(rs.getInt("booking_id"));
	               	         
		            return slot;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Slot> list() {
		
		String sql = "SELECT * FROM slot";
	    List<Slot> listSlot = jdbcTemplate.query(sql, new RowMapper<Slot>() {
	 
	        @Override
	        public Slot mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	
	            Slot allSlot = new Slot();
	 
	            allSlot.setDate(rs.getString("date"));
                allSlot.setDayPeriod(rs.getString("day_period"));
                allSlot.setTableId(rs.getInt("table_id"));
                allSlot.setBookingId(rs.getInt("booking_id"));
               	         
	     
	            return allSlot;
	        }
	 
	    });
	    	 
	    return listSlot;
	}

	  @Override public int althentication(String date, String dayPeriod, int tableId) {
		  
		  String sql = "SELECT COUNT(*) FROM `slot` WHERE date='" + date + "' AND day_period='" + dayPeriod + "' AND table_id=" + tableId;
		  
		  @SuppressWarnings("deprecation") 
		  int count = jdbcTemplate.queryForInt(sql);
		  
		  return count; 
		}
	  
	  @Override
		public void deleteAll(int bookingId) {
			
			String sql = "DELETE FROM slot WHERE booking_id=?";
		    jdbcTemplate.update(sql, bookingId);	
		}
}

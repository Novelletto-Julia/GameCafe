package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import ie.gamecafe.model.Staff;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class StaffDAOImpl implements StaffDAO{

	private JdbcTemplate jdbcTemplate;
	
	public StaffDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void saveOrUpdate(Staff staff) {
		
		 if (staff.getId() > 0) {
		        // update
		        String sql = "UPDATE staff SET first_name=?, surname=?, email=?, phone=?, address_id=?, "
		                    + "job_title=?, username=?, password=?, birth_date=?, hire_date=? WHERE staff_id=?";
		        jdbcTemplate.update(sql, staff.getFirstName(), staff.getSurname(), staff.getEmail(), staff.getPhone(),
		                staff.getAddressId(), staff.getJobTitle(), staff.getUsername(), staff.getPassword(), staff.getBirthDate(),staff.getHireDate(), staff.getId());
		    } else {
		        // insert
		        String sql = "INSERT INTO staff (first_name, surname, email, phone, job_title, username, password, birth_date, hire_date, address_id)"
		                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        jdbcTemplate.update(sql, staff.getFirstName(), staff.getSurname(), staff.getEmail(), staff.getPhone(),
		            staff.getJobTitle(), staff.getUsername(), staff.getPassword(), staff.getBirthDate(),staff.getHireDate(), staff.getAddressId());
		    }
	}

	@Override
	public void delete(int staffId) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM staff WHERE staff_id=?";
		    jdbcTemplate.update(sql, staffId);
	}

	@Override
	public Staff get(int staffId) {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM staff WHERE staff_id=" + staffId;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Staff>() {
		 
		        @Override
		        public Staff extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		                Staff staff = new Staff();
		                
		                staff.setId(rs.getInt("staff_id"));
			            staff.setFirstName(rs.getString("first_name"));
			            staff.setSurname(rs.getString("surname"));
			            staff.setEmail(rs.getString("email"));
			            staff.setPhone(rs.getInt("phone"));
			            staff.setJobTitle(rs.getString("job_title"));
			            staff.setUsername(rs.getString("username"));
			            staff.setPassword(rs.getString("password"));
			            staff.setBirthDate(rs.getDate("birth_date"));
			            staff.setHireDate(rs.getDate("hire_date"));
			            staff.setAddressId(rs.getInt("address_id"));
			           
			 
			            return staff;
		            }
		 
		            return null;
		        }
		 
		    });
	}

	@Override
	public List<Staff> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM staff";
	    List<Staff> listStaff = jdbcTemplate.query(sql, new RowMapper<Staff>() {
	 
	        @Override
	        public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Staff allStaff = new Staff();
	 
	            allStaff.setId(rs.getInt("staff_id"));
	            allStaff.setFirstName(rs.getString("first_name"));
	            allStaff.setSurname(rs.getString("surname"));
	            allStaff.setEmail(rs.getString("email"));
	            allStaff.setPhone(rs.getInt("phone"));
	            allStaff.setJobTitle(rs.getString("job_title"));
	            allStaff.setUsername(rs.getString("username"));
	            allStaff.setPassword(rs.getString("password"));
	            allStaff.setBirthDate(rs.getDate("birth_date"));
	            allStaff.setHireDate(rs.getDate("hire_date"));
	            allStaff.setAddressId(rs.getInt("address_id"));
	           
	 
	            return allStaff;
	        }
	 
	    });
	 
	    return listStaff;
	}
	
	public int althentication(String username, String password) {
		
		String sql = "SELECT COUNT(*) FROM staff WHERE username='" + username + "' AND password='" + password + "'";
		@SuppressWarnings("deprecation")
		int count = jdbcTemplate.queryForInt(sql);
				
		return count;
	}
	  @Override public int getStaffId(String username, String password) {
		  
		  String sql = "SELECT staff_id FROM staff WHERE username='" + username +
		  "' AND password='" + password + "'";
		  
		  @SuppressWarnings("deprecation") 
		  
		  int id = jdbcTemplate.queryForInt(sql);
		  
		  return id; 
		}
		
}
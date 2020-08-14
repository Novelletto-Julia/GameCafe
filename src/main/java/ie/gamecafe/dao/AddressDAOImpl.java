package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Address;


public class AddressDAOImpl implements AddressDAO{

private JdbcTemplate jdbcTemplate;
	
	public AddressDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Address address) {
		
		 if (address.getId() > 0) {
		        // update
		        String sql = "UPDATE address SET  address=?, eircode_id=? WHERE address_id=?";
		        jdbcTemplate.update(sql, address.getAddress(), address.getEircodeId(), address.getId());
		    } else {
		        // insert
		        String sql = "INSERT INTO address ( address, eircode_id)"
		                    + " VALUES (?, ?)";
		        jdbcTemplate.update(sql, address.getAddress(), address.getEircodeId());
		    }
		
	}

	@Override
	public void delete(int addressId) {
		
		 String sql = "DELETE FROM address WHERE address_id=?";
		    jdbcTemplate.update(sql, addressId);	
	}

	@Override
	public Address get(int addressId) {
		
		String sql = "SELECT * FROM address WHERE address_id=" + addressId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Address>() {
	 
	        @Override
	        public Address extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Address address = new Address();
	                
	                address.setId(rs.getInt("address_id"));
		            address.setAddress(rs.getString("address"));
		            address.setEircodeId(rs.getInt("eircode_id"));
		         
		     
		            return address;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Address> list() {
		
		String sql = "SELECT * FROM address";
	    List<Address> listAddress = jdbcTemplate.query(sql, new RowMapper<Address>() {
	 
	        @Override
	        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	
	            Address allAddress = new Address();
	 
	            allAddress.setId(rs.getInt("address_id"));
	            allAddress.setAddress(rs.getString("address"));
	            allAddress.setEircodeId(rs.getInt("eircode_id"));
	     
	            return allAddress;
	        }
	 
	    });
	 
	    return listAddress;
	}
	
	  @Override public int checkForExistentAddress(String address) {
		  
	  String sql = "SELECT COUNT(*) FROM address WHERE address='" + address +"'";
	  
	  @SuppressWarnings("deprecation") 
	  
	  int count = jdbcTemplate.queryForInt(sql);
	  
		return count;
	}

	@Override
	public int checkForAddressIdAndEircodeId(int addressId, int eircodeId) {

		String sql = "SELECT COUNT(*) FROM address WHERE address_id='" + addressId + "' AND eircode_id='" + eircodeId
				+ "'";

		@SuppressWarnings("deprecation")

		int count = jdbcTemplate.queryForInt(sql);

		return count;
	}

	@Override
	public int getAddressId(String address) {
		String sql = "SELECT address_id FROM address WHERE address='" + address + "'";

		@SuppressWarnings("deprecation")

		int addressId = jdbcTemplate.queryForInt(sql);

		return addressId;
	}

	@Override
	public int getNewAddressId(String address, int eircode) {
		String sql = "SELECT address_id FROM address WHERE address='" + address + "'" + " AND eircode_id=" + eircode;

		@SuppressWarnings("deprecation")

		int addressId = jdbcTemplate.queryForInt(sql);

		return addressId;	
		}


}

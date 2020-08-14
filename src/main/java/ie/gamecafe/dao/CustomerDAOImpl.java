
package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Customer;



public class CustomerDAOImpl implements CustomerDAO {

	private JdbcTemplate jdbcTemplate;
	
	public CustomerDAOImpl(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Customer customer) {
		
		 if (customer.getId() > 0) {
		        // update
		        String sql = "UPDATE customer SET first_name=?, surname=?, email=?, phone=?, address_id=?, "
		                    + "username=?, password=?, birth_date=? WHERE customer_id=?";
		        jdbcTemplate.update(sql, customer.getFirstName(), customer.getSurname(), customer.getEmail(), customer.getPhone(),
		                customer.getAddressId(), customer.getUsername(), customer.getPassword(), customer.getBirthDate(), customer.getId());
		    } else {
		        // insert
		        String sql = "INSERT INTO customer (first_name, surname, email, phone, username, password, birth_date, address_id)"
		                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		        jdbcTemplate.update(sql, customer.getFirstName(), customer.getSurname(), customer.getEmail(), customer.getPhone(),
		        		customer.getUsername(), customer.getPassword(), customer.getBirthDate(), customer.getAddressId());
		    }
	}

	@Override
	public void delete(int customerId) {
		
		 String sql = "DELETE FROM customer WHERE customer_id=?";
		    jdbcTemplate.update(sql, customerId);
		
	}

	@Override
	public Customer get(int customerId) {
		
		 String sql = "SELECT * FROM customer WHERE customer_id=" + customerId;
		 
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Customer>() {
		 
		        @Override
		        public Customer extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	
		                Customer customer = new Customer();
		                
		                customer.setId(rs.getInt("customer_id"));
			            customer.setFirstName(rs.getString("first_name"));
			            customer.setSurname(rs.getString("surname"));
			            customer.setEmail(rs.getString("email"));
			            customer.setPhone(rs.getInt("phone"));
			            customer.setUsername(rs.getString("username"));
			            customer.setPassword(rs.getString("password"));
			            customer.setBirthDate(rs.getDate("birth_date"));
			            customer.setAddressId(rs.getInt("address_id"));
			           
			 
			            return customer;
		            }
		 
		            return null;
		        }
		 
		    });
	}

	@Override
	public List<Customer> list() {
		
		String sql = "SELECT * FROM customer";
	    List<Customer> listCustomer = jdbcTemplate.query(sql, new RowMapper<Customer>() {
	 
	        @Override
	        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	
	            Customer allCustomer = new Customer();
	 
	            allCustomer.setId(rs.getInt("customer_id"));
	            allCustomer.setFirstName(rs.getString("first_name"));
	            allCustomer.setSurname(rs.getString("surname"));
	            allCustomer.setEmail(rs.getString("email"));
	            allCustomer.setPhone(rs.getInt("phone"));
	            allCustomer.setUsername(rs.getString("username"));
	            allCustomer.setPassword(rs.getString("password"));
	            allCustomer.setBirthDate(rs.getDate("birth_date"));
	            allCustomer.setAddressId(rs.getInt("address_id"));
	           
	 
	            return allCustomer;
	        }
	 
	    });
	 
	    return listCustomer;
	}
	
	  @Override public int althentication(String username, String password) {
	  
	  String sql = "SELECT COUNT(*) FROM customer WHERE username='" + username +
	  "' AND password='" + password + "'";
	  
	  @SuppressWarnings("deprecation") 
	  
	  int count = jdbcTemplate.queryForInt(sql);
	  
	  return count; 
	}
	 
	  @Override public int getCustomerId(String username, String password) {
		  
	  String sql = "SELECT customer_id FROM customer WHERE username='" + username +
	  "' AND password='" + password + "'";
	  
	  @SuppressWarnings("deprecation") 
	  
	  int id = jdbcTemplate.queryForInt(sql);
	  
	  return id; 
	}
	
	  @Override public String getCustomerName(int customerId) {
		  
	  //This method return the full name of the customer
	  //Reference: Laszlo Lugosi post at Stackoverflow (https://stackoverflow.com/questions/29286725/using-spring-jdbctemplate-to-extract-one-string)
		  
	  String sql1 = "SELECT first_name FROM customer WHERE customer_id =?";
	  String sql2 = "SELECT surname FROM customer WHERE customer_id =?";
	  
	  String name = (String) jdbcTemplate.queryForObject(
		        sql1, new Object[] { customerId }, String.class);
	  
	  String surname = (String) jdbcTemplate.queryForObject(
		        sql2, new Object[] { customerId }, String.class);
	  
	  String fullName = name + " " + surname;

		  return fullName;
	}

	@Override
	public int usernameCheck(String username) {

		String sql = "SELECT COUNT(*) FROM customer WHERE username='" + username + "'";

		@SuppressWarnings("deprecation")

		int count = jdbcTemplate.queryForInt(sql);

		return count;

	}
	
	@Override
	public int emailCheck(String email) {

		String sql = "SELECT COUNT(*) FROM customer WHERE email='" + email + "'";

		@SuppressWarnings("deprecation")

		int count = jdbcTemplate.queryForInt(sql);

		return count;

	}

	@Override
	public int phoneCheck(int phone) {
		String sql = "SELECT COUNT(*) FROM customer WHERE phone=" + phone;

		@SuppressWarnings("deprecation")

		int count = jdbcTemplate.queryForInt(sql);

		return count;
	}

}
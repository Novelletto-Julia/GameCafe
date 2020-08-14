package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Eircode;

public class EircodeDAOImpl implements EircodeDAO{

	private JdbcTemplate jdbcTemplate;
	
	public EircodeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Eircode eircode) {
		
		if (eircode.getId() > 0) {
	        // update
	        String sql = "UPDATE eircode SET  eircode=? WHERE eircode_id=?";
	        jdbcTemplate.update(sql, eircode.getEircode(), eircode.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO eircode (eircode)"
	                    + " VALUES (?)";
	        jdbcTemplate.update(sql, eircode.getEircode());
	    }
		
	}

	@Override
	public void delete(int eircodeId) {
		String sql = "DELETE FROM eircode WHERE eircode_id=?";
	    jdbcTemplate.update(sql, eircodeId);
	}

	@Override
	public Eircode get(int eircodeId) {
		
		String sql = "SELECT * FROM eircode WHERE eircode_id=" + eircodeId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Eircode>() {
	 
	        @Override
	        public Eircode extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Eircode eircode = new Eircode();
	                
	                eircode.setId(rs.getInt("eircode_id"));
		            eircode.setEircode(rs.getString("eircode"));
		     
		            return eircode;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Eircode> list() {
		
		String sql = "SELECT * FROM eircode";
	    List<Eircode> listEircode = jdbcTemplate.query(sql, new RowMapper<Eircode>() {
	 
	        @Override
	        public Eircode mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Eircode allEircode = new Eircode();
	 
	            allEircode.setId(rs.getInt("eircode_id"));
	            allEircode.setEircode(rs.getString("eircode"));
	     
	            return allEircode;
	        }
	 
	    });
	 
	    return listEircode;
	}
	
	  @Override public int checkForExistentEircode(String eircode) {
		  
	  String sql = "SELECT COUNT(*) FROM eircode WHERE eircode='" + eircode +"'";
	  
	  @SuppressWarnings("deprecation") 
	  
	  int count = jdbcTemplate.queryForInt(sql);
	  
	  return count; 
	}

	@Override
	public int getEircodeId(String eircode) {

			  String sql = "SELECT eircode_id FROM eircode WHERE eircode='" + eircode +"'";
			  
			  @SuppressWarnings("deprecation") 
			  
			  int eircodeId = jdbcTemplate.queryForInt(sql);
			  
			  return eircodeId; 
			}
	}


package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Table;

public class TableDAOImpl implements TableDAO{

	private JdbcTemplate jdbcTemplate;
	
	public TableDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Table table) {
		
		if (table.getId() > 0) {
	        // update
	        String sql = "UPDATE `table` SET  num_people=? WHERE table_id=?";
	        jdbcTemplate.update(sql, table.getNumPeople(), table.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO `table` (num_people)"
	                    + " VALUES (?)";
	        jdbcTemplate.update(sql, table.getNumPeople());
	    }
		
	}

	@Override
	public void delete(int tableId) {
		
		String sql = "DELETE FROM `table` WHERE table_id=?";
	    jdbcTemplate.update(sql, tableId);
		
	}

	@Override
	public Table get(int tableId) {
		
		String sql = "SELECT * FROM `table` WHERE table_id=" + tableId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Table>() {
	 
	        @Override
	        public Table extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Table table = new Table();
	                
	                table.setId(rs.getInt("table_id"));
		            table.setNumPeople(rs.getInt("num_people"));
		     
		            return table;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Table> list() {
		
		String sql = "SELECT * FROM `table`";
	    List<Table> listTable = jdbcTemplate.query(sql, new RowMapper<Table>() {
	 
	        @Override
	        public Table mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Table allTable = new Table();
	 
	            allTable.setId(rs.getInt("table_id"));
	            allTable.setNumPeople(rs.getInt("num_people"));
	     
	            return allTable;
	        }
	 
	    });
	 
	    return listTable;
	}

}

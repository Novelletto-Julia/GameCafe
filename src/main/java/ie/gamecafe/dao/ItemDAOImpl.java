package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Item;


public class ItemDAOImpl implements ItemDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ItemDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Item item) {
		
		 if (item.getId() > 0) {
		        // update
		        String sql = "UPDATE item SET name=?, price=?, avaliability=?, category_id=? WHERE item_id=?";
		        jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getAvaliability(), item.getCategoryId(), item.getId());
		    } else {
		        // insert
		        String sql = "INSERT INTO item (name, price, avaliability, category_id)"
		                    + " VALUES (?, ?, ?, ?)";
		        jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getAvaliability(), item.getCategoryId());
		    }
		
	}

	@Override
	public void delete(int itemId) {
		 String sql = "DELETE FROM item WHERE item_id=?";
		    jdbcTemplate.update(sql, itemId);
	}

	@Override
	public Item get(int itemId) {
		
		String sql = "SELECT * FROM item WHERE item_id=" + itemId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Item>() {
	 
	        @Override
	        public Item extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Item item = new Item();
	                
	                item.setId(rs.getInt("item_id"));
		            item.setName(rs.getString("name"));
		            item.setPrice(rs.getBigDecimal("price"));
		            item.setAvaliability(rs.getString("avaliability"));
		            item.setCategoryId(rs.getInt("category_id"));
		     
		            return item;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Item> list() {
		
		String sql = "SELECT * FROM item";
	    List<Item> listItem = jdbcTemplate.query(sql, new RowMapper<Item>() {
	 
	        @Override
	        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Item allItem = new Item();
	 
	            allItem.setId(rs.getInt("item_id"));
	            allItem.setName(rs.getString("name"));
	            allItem.setPrice(rs.getBigDecimal("price"));
	            allItem.setAvaliability(rs.getString("avaliability"));
	            allItem.setCategoryId(rs.getInt("category_id"));
	           
	 
	            return allItem;
	        }
	 
	    });
	 
	    return listItem;
	}

	@Override
	public String itemName(int itemId) {
		
			String sql = "Select name from item WHERE item_id =?";
			 
			String name = (String) jdbcTemplate.queryForObject(sql, new Object[] { itemId }, String.class);
			
			return name;
		}
	}
	


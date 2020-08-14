package ie.gamecafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ie.gamecafe.model.Category;

public class CategoryDAOImpl implements CategoryDAO{

private JdbcTemplate jdbcTemplate;
	
	public CategoryDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Category category) {
		
		if (category.getId() > 0) {
	        // update
	        String sql = "UPDATE category SET  category_name=? WHERE category_id=?";
	        jdbcTemplate.update(sql, category.getCategoryName(), category.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO category (category_name)"
	                    + " VALUES (?)";
	        jdbcTemplate.update(sql, category.getCategoryName());
	    }
		
	}

	@Override
	public void delete(int categoryId) {
		String sql = "DELETE FROM category WHERE category_id=?";
	    jdbcTemplate.update(sql, categoryId);
		
	}

	@Override
	public Category get(int categoryId) {
		
		String sql = "SELECT * FROM category WHERE category_id=" + categoryId;
		
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Category>() {
	 
	        @Override
	        public Category extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Category category = new Category();
	                
	                category.setId(rs.getInt("category_id"));
		            category.setCategoryName(rs.getString("category_name"));
		     
		            return category;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Category> list() {
		
		String sql = "SELECT * FROM category";
	    List<Category> listCategory = jdbcTemplate.query(sql, new RowMapper<Category>() {
	 
	        @Override
	        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Category allCategory = new Category();
	 
	            allCategory.setId(rs.getInt("category_id"));
	            allCategory.setCategoryName(rs.getString("category_name"));
	     
	            return allCategory;
	        }
	 
	    });
	 
	    return listCategory;
	}


}

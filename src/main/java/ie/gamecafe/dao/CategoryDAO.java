package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Category;



public interface CategoryDAO {

	public void saveOrUpdate(Category category);
	
	public void delete(int categoryId);

	public Category get(int categoryId);

	public List<Category> list();
}
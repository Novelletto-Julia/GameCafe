package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Table;

public interface TableDAO {

	public void saveOrUpdate(Table table);

	public void delete(int tableId);

	public Table get(int tableId);

	public List<Table> list();
}
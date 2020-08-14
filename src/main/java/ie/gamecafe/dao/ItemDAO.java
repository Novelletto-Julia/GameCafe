package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Item;


public interface ItemDAO {

	public void saveOrUpdate(Item item);

	public void delete(int itemId);

	public Item get(int itemId);

	public List<Item> list();

	String itemName(int itemId);
}
package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Bill;
import ie.gamecafe.model.OrderLine;

public interface OrderLineDAO {
	
	public void saveOrUpdate(OrderLine orderLine);

	public void delete(int orderId, int itemId);

	public OrderLine get(int orderId, int itemId);

	public List<OrderLine> list();

	void deleteAll(int orderId);

	List<OrderLine> listById(int orderId);

	List<Bill> printBill(int orderId);
}


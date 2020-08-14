package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.PlacedOrder;

public interface PlacedOrderDAO {

	public void saveOrUpdate(PlacedOrder placedOrder);

	public void delete(int placedOrderId);

	public PlacedOrder get(int placedOrderId);

	public List<PlacedOrder> list();
	
	public int lastOrderId();

	int staffId(int orderId);

	int noOrderCheck(int bookingId);
}



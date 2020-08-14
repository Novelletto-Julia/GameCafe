package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Slot;

public interface SlotDAO {
	
	public void saveOrUpdate(Slot slot);

	public void delete(String date, String dayPeriod, int tableId);

	public Slot get(String date, String dayPeriod, int tableId);

	public List<Slot> list();

	int althentication(String date, String dayPeriod, int tableId);

	void deleteAll(int bookingId);
}
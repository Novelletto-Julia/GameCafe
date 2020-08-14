package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Booking;
import ie.gamecafe.model.BookingInformation;


public interface BookingDAO {

	public void saveOrUpdate(Booking booking);

	public void delete(int bookingId);

	public Booking get(int bookingId);

	public List<Booking> list();
	
	public int lastBookingId();

	List<BookingInformation> viewAllBookings();

	List<BookingInformation> customerAllBookings(int customerId);
}

package ie.gamecafe.model;

public class PlacedOrder {

	private int id;
	private int staffId;
	private int bookingId;
	
	
	public PlacedOrder() {
		super();
	}

	public PlacedOrder(int id, int staffId, int bookingId) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.bookingId = bookingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

}

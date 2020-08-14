package ie.gamecafe.model;


public class Booking {

	private int id;
	private double bookingFee;
	private String foodService;
	private int customerId;
	
	
	public Booking() {
		super();
	}

	public Booking(int id, double bookingFee, String foodService, int customerId) {
		super();
		this.id = id;
		this.bookingFee = bookingFee;
		this.foodService = foodService;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBookingFee() {
		return bookingFee;
	}

	public void setBookingFee(double bookingFee) {
		this.bookingFee = bookingFee;
	}

	public String getFoodService() {
		return foodService;
	}

	public void setFoodService(String foodService) {
		this.foodService = foodService;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}

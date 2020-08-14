package ie.gamecafe.model;

public class BookingInformation {

	private int bookingId;
	private int customerId;
	private String customerName;
	private String date;
	private String period;
	private String foodService;
	private int tableId;
	private double bookingFee;
	
	
	
	public BookingInformation() {
		super();
	}



	public BookingInformation(int bookingId, String customerName, String date, String period, String foodService,
			int tableId, double bookingFee) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.date = date;
		this.period = period;
		this.foodService = foodService;
		this.tableId = tableId;
		this.bookingFee = bookingFee;
	}



	public BookingInformation(int bookingId, int customerId, String date, String period, String foodService,
			int tableId, double bookingFee) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.date = date;
		this.period = period;
		this.foodService = foodService;
		this.tableId = tableId;
		this.bookingFee = bookingFee;
	}



	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getPeriod() {
		return period;
	}



	public void setPeriod(String period) {
		this.period = period;
	}



	public String getFoodService() {
		return foodService;
	}



	public void setFoodService(String foodService) {
		this.foodService = foodService;
	}



	public int getTableId() {
		return tableId;
	}



	public void setTableId(int tableId) {
		this.tableId = tableId;
	}



	public double getBookingFee() {
		return bookingFee;
	}



	public void setBookingFee(double bookingFee) {
		this.bookingFee = bookingFee;
	}
	
	
	
	
}

package ie.gamecafe.model;

public class NewBooking {

	private int customerId;
	private String foodService;
	private String date;
	private String dayPeriod;
	private int numPeople;
	
	
	public NewBooking() {
		super();
	}


	public NewBooking(int customerId, String foodService, String date, String dayPeriod, int numPeople) {
		super();
		this.customerId = customerId;
		this.foodService = foodService;
		this.date = date;
		this.dayPeriod = dayPeriod;
		this.numPeople = numPeople;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getFoodService() {
		return foodService;
	}


	public void setFoodService(String foodService) {
		this.foodService = foodService;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDayPeriod() {
		return dayPeriod;
	}


	public void setDayPeriod(String dayPeriod) {
		this.dayPeriod = dayPeriod;
	}


	public int getNumPeople() {
		return numPeople;
	}


	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}
	
	
}

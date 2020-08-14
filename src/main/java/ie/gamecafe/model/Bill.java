package ie.gamecafe.model;

public class Bill {

	private int orderId;
	private int itemId;
	private int quantity;
	private String name;
	private double price;
	
	public Bill() {
		super();
	}

	public Bill(double price) {
		super();
		this.price = price;
	}

	public Bill(int orderId, int itemId, int quantity, String name, double price) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.name = name;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

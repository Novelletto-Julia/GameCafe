package ie.gamecafe.model;

public class OrderLine {

	private int orderId;
	private int itemId;
	private int quantity;
	//This attribute was create to solve a problem in passing a parameter in the url for a post method
	//This new attribute is the logged in staff's id an goes as a hidden parameter in the add new item form
	private int staffId;
	
	
	public OrderLine() {
		super();
	}

	public OrderLine(int orderId, int itemId, int quantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
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

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	
}

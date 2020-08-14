package ie.gamecafe.model;

import java.math.BigDecimal;

public class Item {

	private int id;
	private String name;
	private BigDecimal price;
	private String avaliability;
	private int categoryId;
	
	public Item() {
		super();
	}

	public Item(int id, String name, BigDecimal price, String avaliability, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.avaliability = avaliability;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getAvaliability() {
		return avaliability;
	}

	public void setAvaliability(String avaliability) {
		this.avaliability = avaliability;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}

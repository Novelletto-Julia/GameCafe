package ie.gamecafe.model;

public class Address {
	
	private int id;
	private String address;
	private int eircodeId;
	
	
	public Address() {
		super();
	}

	public Address(int id, String address, int eircodeId) {
		super();
		this.id = id;
		this.address = address;
		this.eircodeId = eircodeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEircodeId() {
		return eircodeId;
	}

	public void setEircodeId(int eircodeId) {
		this.eircodeId = eircodeId;
	}
	
}

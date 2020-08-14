package ie.gamecafe.model;

public class Eircode {

	private int id;
	private String eircode;
	
	public Eircode() {
		super();
	}

	public Eircode(int id, String eircode) {
		super();
		this.id = id;
		this.eircode = eircode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEircode() {
		return eircode;
	}

	public void setEircode(String eircode) {
		this.eircode = eircode;
	}
	
	
}

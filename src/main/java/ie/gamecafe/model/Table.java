package ie.gamecafe.model;

public class Table {

	private int id;
	private int numPeople;
	
	public Table() {
		super();
	}

	public Table(int id, int numPeople) {
		super();
		this.id = id;
		this.numPeople = numPeople;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPeople() {
		return numPeople;
	}

	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}
	
}

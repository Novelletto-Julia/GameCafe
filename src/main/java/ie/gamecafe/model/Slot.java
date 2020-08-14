package ie.gamecafe.model;

public class Slot {


	
	private String date;
	private String dayPeriod;
	private int tableId;
	private int bookingId;
	//old
	private String oldDate;
	private String oldDayPeriod;
	private int oldTableId;

	
	public Slot() {
		super();
	}
	public Slot(String date, String dayPeriod, int tableId, int bookingId) {
		super();
		this.date = date;
		this.dayPeriod = dayPeriod;
		this.tableId = tableId;
		this.bookingId = bookingId;
	}
	public Slot(String date, String dayPeriod, int tableId, int bookingId, String olddate, String olddayPeriod, int oldtableId) {
		super();
		this.date = date;
		this.dayPeriod = dayPeriod;
		this.tableId = tableId;
		this.bookingId = bookingId;
		this.oldDate = olddate;
		this.oldDayPeriod = olddayPeriod;
		this.oldTableId = oldtableId;
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
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	//Old attributes
	public String getOldDate() {
		return oldDate;
	}
	public void setOldDate(String oldDate) {
		this.oldDate = oldDate;
	}
	public String getOldDayPeriod() {
		return oldDayPeriod;
	}
	public void setOldDayPeriod(String oldDayPeriod) {
		this.oldDayPeriod = oldDayPeriod;
	}
	public int getOldTableId() {
		return oldTableId;
	}
	public void setOldTableId(int oldTableId) {
		this.oldTableId = oldTableId;
	}
	
}
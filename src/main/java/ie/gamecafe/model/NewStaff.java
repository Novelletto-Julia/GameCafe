package ie.gamecafe.model;

import java.sql.Date;

public class NewStaff {
	
	private int staffId;
	private String firstName;
	private String surname;
	private String email;
	private int phone;
	private String username;
	private String password;
	private String jobTitle;
	private Date birthDate;
	private Date hireDate;
	private String eircode;
	private String address;
	
	
	public NewStaff() {
		super();
	}


	public NewStaff(int staffId, String firstName, String surname, String email, int phone, String username,
			String password, String jobTitle, Date birthDate, Date hireDate, String eircode, String address) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.jobTitle = jobTitle;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.eircode = eircode;
		this.address = address;
	}


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public String getEircode() {
		return eircode;
	}


	public void setEircode(String eircode) {
		this.eircode = eircode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

package ie.gamecafe.model;

import java.sql.Date;

public class Register {

	private int customerId;
	private String firstName;
	private String surname;
	private String email;
	private int phone;
	private String username;
	private String password;
	private Date birthDate;
	private String eircode;
	private String address;
	
	public Register() {
		super();
	}

	public Register(int customerId, String firstName, String surname, String email, int phone, String username,
			String password, Date birthDate, String eircode, String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.birthDate = birthDate;
		this.eircode = eircode;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

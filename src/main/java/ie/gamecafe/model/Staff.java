package ie.gamecafe.model;

import java.sql.Date;

public class Staff {

	private int id;
	private String firstName;
	private String surname;
	private String email;
	private int phone;
	private String jobTitle;
	private String username;
	private String password;
	private Date birthDate;
	private Date hireDate;
	private int addressId;

	public Staff() {
		super();
	}

	public Staff(int id, String firstName, String surname, String email, int phone, String jobTitle, String username,
			String password, Date birthDate, Date hireDate, int addressId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.jobTitle = jobTitle;
		this.username = username;
		this.password = password;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.addressId = addressId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}

package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Customer;

public interface CustomerDAO {

	public void saveOrUpdate(Customer customer);

	public void delete(int customerId);

	public Customer get(int customerId);

	public List<Customer> list();
	
	public int althentication(String username, String password);

	int getCustomerId(String username, String password);

	String getCustomerName(int customerId);

	int usernameCheck(String username);
	
	int emailCheck(String email);
	
	int phoneCheck(int phone);
}
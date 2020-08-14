package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Staff;

public interface StaffDAO {

	public void saveOrUpdate(Staff staff);

	public void delete(int staffId);

	public Staff get(int staffId);

	public List<Staff> list();
	
	public int althentication(String username, String password);

	int getStaffId(String username, String password);
	}
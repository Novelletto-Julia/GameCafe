package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Address;


public interface AddressDAO {

	public void saveOrUpdate(Address address);

	public void delete(int addressId);

	public Address get(int addressId);

	public List<Address> list();

	int checkForExistentAddress(String address);

	int checkForAddressIdAndEircodeId(int addressId, int eircodeId);

	int getAddressId(String address);

	int getNewAddressId(String address, int eircode);
}

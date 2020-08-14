package ie.gamecafe.dao;

import java.util.List;

import ie.gamecafe.model.Eircode;


public interface EircodeDAO {

	public void saveOrUpdate(Eircode eircode);

	public void delete(int eircodeId);

	public Eircode get(int eircodeId);

	public List<Eircode> list();

	int checkForExistentEircode(String eircode);

	int getEircodeId(String eircode);
}


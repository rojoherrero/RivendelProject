package org.rojoherrero.rivendel.services;

import java.util.List;

import org.rojoherrero.rivendel.models.entities.House;
import org.rojoherrero.rivendel.models.forms.NewHouseForm;
import org.rojoherrero.rivendel.models.forms.UpdateHouseForm;

public interface HouseService {

	Long addHouse(NewHouseForm newHouseForm);

	void updateHouse(Long houseId, UpdateHouseForm updateHouseForm);

	void deleteHouse(Long houseId);

	List<House> retrieveAllHouses();
	
	House retrieveHouseById(Long houseId);
	
	List<House> retrieveHousesByTown(String town);
	
	List<String> retrieveTownNames();
}

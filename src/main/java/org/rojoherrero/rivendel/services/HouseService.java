package org.rojoherrero.rivendel.services;

import org.rojoherrero.rivendel.dto.HouseDTO;
import org.rojoherrero.rivendel.entities.House;

public interface HouseService {

	void saveHouse(HouseDTO houseDTO);

	Iterable<House> retrieveAllHouses();
	
	House retrieveHouseById(long houseId); 
	
	void deleteHouseById(long houseId);
	
	HouseDTO retrieveHouseToUpdate(long houseId);
	
	void updateHouse(long houseId, HouseDTO newHouseValues);
}

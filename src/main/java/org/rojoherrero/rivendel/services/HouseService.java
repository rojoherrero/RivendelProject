package org.rojoherrero.rivendel.services;

import java.util.List;

import org.rojoherrero.rivendel.models.DTO.NewHouseDTO;
import org.rojoherrero.rivendel.models.DTO.UpdateHouseDTO;
import org.rojoherrero.rivendel.models.entities.House;

public interface HouseService {

	Long addHouse(NewHouseDTO newHouseForm);

	void updateHouse(Long houseId, UpdateHouseDTO updateHouseForm);

	void deleteHouse(Long houseId);

	List<House> retrieveAllHouses();
	
	House retrieveHouseById(Long houseId);
	
	List<House> retrieveHousesByTown(String town);
	
	List<String> retrieveTownNames();
}

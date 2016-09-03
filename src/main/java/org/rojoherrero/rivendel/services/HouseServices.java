package org.rojoherrero.rivendel.services;

import org.rojoherrero.rivendel.dto.HouseDTO;
import org.rojoherrero.rivendel.entities.House;

public interface HouseServices {

	void registerNewHouse(HouseDTO houseDTO);

	Iterable<House> retrieveAllHouses();
}

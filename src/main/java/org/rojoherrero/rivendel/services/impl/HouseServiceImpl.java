package org.rojoherrero.rivendel.services.impl;

import org.rojoherrero.rivendel.dto.HouseDTO;
import org.rojoherrero.rivendel.entities.House;
import org.rojoherrero.rivendel.entities.HouseDetail;
import org.rojoherrero.rivendel.repositories.HouseRepository;
import org.rojoherrero.rivendel.services.HouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseServices {

	@Autowired
	private HouseRepository houseRepo;

	@Override
	public void registerNewHouse(HouseDTO houseDTO) {

		House house = new House();
		HouseDetail houseDetail = new HouseDetail();

		houseDetail.setBedRooms(houseDTO.getBedRooms());
		houseDetail.setRestRooms(houseDTO.getRestRooms());
		houseDetail.setRooms(houseDTO.getRooms());
		houseDetail.setSurfaceBuild(houseDTO.getSurfaceBuild());
		houseDetail.setSurfaceGarage(houseDTO.getSurfaceGarage());
		houseDetail.setSurfaceGarden(houseDTO.getSurfaceGarden());
		houseDetail.setSurfaceTotal(houseDTO.getSurfaceTotal());

		house.setStreetNumber(houseDTO.getStreetNumber());
		house.setStreetName(houseDTO.getStreetName());
		house.setTown(houseDTO.getTown());
		house.setCountry(houseDTO.getCountry());

		house.setHouseDetail(houseDetail);

		houseRepo.save(house);
	}

}

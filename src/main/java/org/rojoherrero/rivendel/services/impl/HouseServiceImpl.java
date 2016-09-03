package org.rojoherrero.rivendel.services.impl;

import org.rojoherrero.rivendel.dto.HouseDTO;
import org.rojoherrero.rivendel.entities.House;
import org.rojoherrero.rivendel.entities.HouseDetail;
import org.rojoherrero.rivendel.repositories.HouseRepository;
import org.rojoherrero.rivendel.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseRepository houseRepo;

	@Override
	public void saveHouse(HouseDTO houseDTO) {

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

	@Override
	public Iterable<House> retrieveAllHouses() {
		return houseRepo.findAll();
	}

	@Override
	public House retrieveHouseById(long houseId) {
		return houseRepo.findOne(houseId);
	}

	@Override
	public void deleteHouseById(long houseId) {
		houseRepo.delete(houseId);

	}

	@Override
	public HouseDTO retrieveHouseToUpdate(long houseId) {

		HouseDTO houseDTO = new HouseDTO();
		House house = houseRepo.findOne(houseId);

		houseDTO.setBedRooms(house.getHouseDetail().getRooms());
		houseDTO.setRestRooms(house.getHouseDetail().getRestRooms());
		houseDTO.setRooms(house.getHouseDetail().getRooms());
		houseDTO.setSurfaceBuild(house.getHouseDetail().getSurfaceBuild());
		houseDTO.setSurfaceGarage(house.getHouseDetail().getSurfaceGarage());
		houseDTO.setSurfaceGarden(house.getHouseDetail().getSurfaceGarden());
		houseDTO.setSurfaceTotal(house.getHouseDetail().getSurfaceTotal());
		houseDTO.setStreetName(house.getStreetName());
		houseDTO.setStreetNumber(house.getStreetNumber());
		houseDTO.setCountry(house.getCountry());
		houseDTO.setTown(house.getTown());

		return houseDTO;
	}

	@Override
	public void updateHouse(long houseId, HouseDTO newHouseValues) {

		House house = houseRepo.findOne(houseId);
		HouseDetail houseDetail = house.getHouseDetail();

		if (newHouseValues.getBedRooms() != null) {
			houseDetail.setBedRooms(newHouseValues.getBedRooms());
		}
		if (newHouseValues.getRestRooms() != null) {
			houseDetail.setRestRooms(newHouseValues.getRestRooms());
		}
		if (newHouseValues.getRooms() != null) {
			houseDetail.setRooms(newHouseValues.getRooms());
		}
		if (newHouseValues.getSurfaceBuild() != null) {
			houseDetail.setSurfaceBuild(newHouseValues.getSurfaceBuild());
		}
		if (newHouseValues.getSurfaceGarage() != null) {
			houseDetail.setSurfaceGarage(newHouseValues.getSurfaceGarage());
		}
		if (newHouseValues.getSurfaceGarden() != null) {
			houseDetail.setSurfaceGarden(newHouseValues.getSurfaceGarden());
		}
		if (newHouseValues.getSurfaceTotal() != null) {
			houseDetail.setSurfaceTotal(newHouseValues.getSurfaceTotal());
		}
		if (newHouseValues.getStreetNumber() != null) {
			house.setStreetNumber(newHouseValues.getStreetNumber());
		}
		if (!newHouseValues.getStreetName().isEmpty()) {
			house.setStreetName(newHouseValues.getStreetName());
		}
		if (!newHouseValues.getTown().isEmpty()) {
			house.setTown(newHouseValues.getTown());
		}
		if (!newHouseValues.getCountry().isEmpty()) {
			house.setCountry(newHouseValues.getCountry());
		}
		house.setHouseDetail(houseDetail);

		houseRepo.save(house);

	}

}

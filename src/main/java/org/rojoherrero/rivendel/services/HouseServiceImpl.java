package org.rojoherrero.rivendel.services;

import java.util.Calendar;
import java.util.List;

import org.rojoherrero.rivendel.models.entities.House;
import org.rojoherrero.rivendel.models.forms.NewHouseForm;
import org.rojoherrero.rivendel.models.forms.UpdateHouseForm;
import org.rojoherrero.rivendel.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {

	private final HouseRepository houseRepo;
	
	@Autowired
	public HouseServiceImpl(HouseRepository houseRepo) {
		this.houseRepo = houseRepo;
	}

	public Long addHouse(NewHouseForm newHouseForm) {

		House house = new House(newHouseForm.getQuarter(), newHouseForm.getStreetName(), newHouseForm.getStreetNumber(),
				newHouseForm.getZipCode(), newHouseForm.getTown(), newHouseForm.getCountry(),
				newHouseForm.getHouseSurface(), newHouseForm.getGardenSurface(),
				newHouseForm.getHouseSurface() + newHouseForm.getGardenSurface(), Calendar.getInstance(),
				Calendar.getInstance());

		houseRepo.save(house);

		return (house.getId());
	}

	public void updateHouse(Long houseId, UpdateHouseForm updateHouseForm) {

		House house = houseRepo.findOne(houseId);
		if (!updateHouseForm.getQuarter().isEmpty()) {
			house.setQuarter(updateHouseForm.getQuarter());
		}
		if (!updateHouseForm.getStreetName().isEmpty()) {
			house.setStreetName(updateHouseForm.getStreetName());
		}
		if (updateHouseForm.getStreetNumber() != null) {
			house.setStreetNumber(updateHouseForm.getStreetNumber());
		}
		if (updateHouseForm.getZipCode() != null) {
			house.setZipCode(updateHouseForm.getZipCode());
		}
		if (!updateHouseForm.getTown().isEmpty()) {
			house.setTown(updateHouseForm.getTown());
		}
		if (!updateHouseForm.getCountry().isEmpty()) {
			house.setCountry(updateHouseForm.getCountry());
		}
		if (updateHouseForm.getHouseSurface() != null) {
			house.setHouseSurface(updateHouseForm.getHouseSurface());
		}
		if (updateHouseForm.getGardenSurface() != null) {
			house.setGardenSurface(updateHouseForm.getGardenSurface());
		}
		if (updateHouseForm.getHouseSurface() != null && updateHouseForm.getGardenSurface() != null) {
			house.setTotalSurface(updateHouseForm.getHouseSurface() + updateHouseForm.getGardenSurface());
		}
		if (updateHouseForm.getHouseSurface() != null && updateHouseForm.getGardenSurface() == null) {
			house.setTotalSurface(updateHouseForm.getHouseSurface());
		}
		if (updateHouseForm.getHouseSurface() == null && updateHouseForm.getGardenSurface() != null) {
			house.setTotalSurface(updateHouseForm.getGardenSurface());
		}

		house.setModificationDate(Calendar.getInstance());

		houseRepo.save(house);
	}

	public void deleteHouse(Long houseId) {
		houseRepo.delete(houseId);
	}

	public List<House> retrieveAllHouses() {
		return (houseRepo.findAll());
	}

	public House retrieveHouseById(Long houseId) {
		return (houseRepo.findOne(houseId));
	}

	public List<House> retrieveHousesByTown(String town) {
		return (houseRepo.findHousesByTown(town));
	}

	public List<String> retrieveTownNames() {
		return(houseRepo.findTowns());
	}

}

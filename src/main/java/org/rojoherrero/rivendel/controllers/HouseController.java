package org.rojoherrero.rivendel.controllers;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.House;
import org.rojoherrero.rivendel.models.HouseSearchForm;
import org.rojoherrero.rivendel.models.UpdateHouseForm;
import org.rojoherrero.rivendel.models.NewHouseForm;
import org.rojoherrero.rivendel.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/house")
public class HouseController {

	@Autowired
	private HouseRepository houseRepo;

	/* Add a new House to the Data Base */

	@RequestMapping(value = "/newHouse/form", method = RequestMethod.GET)
	public String getNewHouse(NewHouseForm newHouseForm) {
		return ("house/new_house/newHouseForm");
	}

	@RequestMapping(value = "/newHouse/form", method = RequestMethod.POST)
	public String postNewHouse(@Valid NewHouseForm newHouseForm, BindingResult result) {

		if (result.hasErrors()) {
			return ("house/new_house/newHouseForm");
		}

		Calendar today = Calendar.getInstance();

		House house = new House(newHouseForm.getQuarter(), newHouseForm.getStreetName(), newHouseForm.getStreetNumber(),
				newHouseForm.getZipCode(), newHouseForm.getTown(), newHouseForm.getCountry(),
				newHouseForm.getHouseSurface(), newHouseForm.getGardenSurface(),
				newHouseForm.getHouseSurface() + newHouseForm.getGardenSurface(), today, today);

		houseRepo.save(house);

		return ("redirect:/house/newHouse/success/houseId/" + house.getId());
	}

	@RequestMapping(value = "/newHouse/success/houseId/{houseId}", method = RequestMethod.GET)
	public String successNewHouse(@PathVariable("houseId") Long houseId, Model model) {
		House house = houseRepo.findOne(houseId);
		model.addAttribute("newHouse", house);
		return ("house/new_house/registration_result");
	}

	/* Search houses */

	@RequestMapping(value = "/houseSearch/searchFrom", method = RequestMethod.GET)
	public String getHouseSearchForm(HouseSearchForm searchForm, Model model) {
		List<String> townsList = houseRepo.findTowns();
		model.addAttribute("towns", townsList);
		return ("house/search_house/house_search_form");
	}

	@RequestMapping(value = "/houseSearch/searchFrom", method = RequestMethod.POST)
	public String postHouseSearchForm(@Valid HouseSearchForm searchFrom, BindingResult result) {
		if (result.hasErrors()) {
			return ("house/search_house/house_search_form");
		}

		return ("redirect:/house/houseSearch/searchForm/result/town/" + searchFrom.getTown());
	}

	@RequestMapping(value = "/houseSearch/searchForm/result/town/{town}", method = RequestMethod.GET)
	public String searchResutl(@PathVariable("town") String town, Model model) {

		List<House> housesByTown = houseRepo.findHousesByTown(town);
		model.addAttribute("housesByTown", housesByTown);
		model.addAttribute("townName", town);
		return ("house/search_house/houses_list");
	}

	/* Modify or Remove a House */

	@RequestMapping(value = "/houseUpdateDelete", method = RequestMethod.GET)
	public String getHouseList(Model model) {
		List<House> allHouses = houseRepo.findAll();
		model.addAttribute("houses", allHouses);
		return ("house/update_delete_house/houses_list");
	}

	@RequestMapping(value = "/houseUpdateDelete/update/houseId/{houseId}", method = RequestMethod.GET)
	public String getUpdateForm(@PathVariable("houseId") Long houseId, UpdateHouseForm upDateForm, Model model) {
		House houseToUpdate = houseRepo.findOne(houseId);
		System.out.println(houseToUpdate.getId());
		model.addAttribute("houseToUpdate", houseToUpdate);
		return ("house/update_delete_house/update_form");
	}

	@RequestMapping(value = "/houseUpdateDelete/update/houseId/{houseId}", method = RequestMethod.POST)
	public String postUpdateForm(@PathVariable("houseId") Long houseId, @Valid UpdateHouseForm upDateForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return ("house/update_delete_house/update_form");
		}

		House houseBefore = houseRepo.findOne(houseId);

		houseRepo.upDateHouseData(upDateForm.getQuarter(), upDateForm.getStreetName(), upDateForm.getStreetNumber(),
				upDateForm.getZipCode(), upDateForm.getTown(), upDateForm.getCountry(), upDateForm.getHouseSurface(),
				upDateForm.getGardenSurface(), upDateForm.getHouseSurface() + upDateForm.getGardenSurface(),
				Calendar.getInstance(), houseId);

		House houseAfter = houseRepo.findOne(houseId);

		model.addAttribute("houseBefore", houseBefore);
		model.addAttribute("houseAfter", houseAfter);

		return ("house/update_delete_house/update_successful");
	}

	@RequestMapping(value = "/houseUpdateDelete/delete/houseId/{houseId}", method = RequestMethod.POST)
	public String deleteHouse(@PathVariable("houseId") Long houseId) {
		houseRepo.delete(houseId);
		return ("house/update_delete_house/delete_success");
	}

}

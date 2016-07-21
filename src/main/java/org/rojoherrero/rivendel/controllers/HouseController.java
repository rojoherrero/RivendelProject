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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/house")
public class HouseController {

	@Autowired
	private HouseRepository houseRepo;

	/* Add a new House to the Data Base */

	@RequestMapping(value = "/newHouse/form", method = RequestMethod.GET)
	public String getNewHouse(NewHouseForm form) {
		return ("house/new_house/newHouseForm");
	}

	@RequestMapping(value = "/newHouse/form", method = RequestMethod.POST)
	public String postNewHouse(@Valid NewHouseForm form, BindingResult result) {

		if (result.hasErrors()) {
			return ("house/new_house/newHouseForm");
		}

		House house = new House(form.getQuarter(), form.getStreetName(), form.getStreetNumber(), form.getZipCode(),
				form.getTown(), form.getCountry(), form.getHouseSurface(), form.getGardenSurface(),
				form.getHouseSurface() + form.getGardenSurface(), Calendar.getInstance(), Calendar.getInstance());

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
	public String getHouseSearchForm(HouseSearchForm form, Model model) {
		List<String> townsList = houseRepo.findTowns();
		model.addAttribute("towns", townsList);
		return ("house/search_house/house_search_form");
	}

	@RequestMapping(value = "/houseSearch/searchFrom", method = RequestMethod.POST)
	public String postHouseSearchForm(@Valid HouseSearchForm form, BindingResult result) {
		if (result.hasErrors()) {
			return ("house/search_house/house_search_form");
		}

		return ("redirect:/house/houseSearch/searchForm/result/town/" + form.getTown());
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

	@RequestMapping(value = "/houseUpdateDelete/update", method = RequestMethod.GET)
	public String getUpdateForm(@RequestParam("houseId") Long houseId, UpdateHouseForm form, Model model) {
		House houseToUpdate = houseRepo.findOne(houseId);
		model.addAttribute("houseToUpdate", houseToUpdate);
		return ("house/update_delete_house/update_form");
	}

	@RequestMapping(value = "/houseUpdateDelete/update", method = RequestMethod.POST)
	public String postUpdateForm(@RequestParam("houseId") Long houseId, @Valid UpdateHouseForm form,
			BindingResult result, Model model) {

		Long id = houseRepo.findOne(houseId).getId();
		model.addAttribute("houseId", id);

		System.out.println(form.getStreetName());
		System.out.println(houseId);

		if (result.hasErrors()) {
			return ("house/update_delete_house/update_form");
		}

		// House updatedHouse = new House();
		// updatedHouse.setQuarter(form.getQuarter());
		// updatedHouse.setStreetName(form.getStreetName());
		// updatedHouse.setStreetNumber(form.getStreetNumber());
		// updatedHouse.setZipCode(form.getZipCode());
		// updatedHouse.setTown(form.getTown());
		// updatedHouse.setCountry(form.getCountry());
		// updatedHouse.setHouseSurface(form.getHouseSurface());
		// updatedHouse.setGardenSurface(form.getGardenSurface());
		// updatedHouse.setTotalSurface(form.getHouseSurface() +
		// form.getGardenSurface());
		// updatedHouse.setModificationDate(Calendar.getInstance());
		// updatedHouse.setId(houseId);

		// System.out.println("ID from path variable: " + houseId);
		// System.out.println("Updated House ID: " + updatedHouse.getId());

		return ("house/update_delete_house/update_successful");
	}

	@RequestMapping(value = "/houseUpdateDelete/delete")
	public String deleteHouse(@RequestParam("houseId") Long houseId) {
		houseRepo.delete(houseId);
		return ("house/update_delete_house/delete_success");
	}

}

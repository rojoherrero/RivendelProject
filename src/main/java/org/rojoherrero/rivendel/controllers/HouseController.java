package org.rojoherrero.rivendel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.DTO.HouseSearchDTO;
import org.rojoherrero.rivendel.models.DTO.NewHouseDTO;
import org.rojoherrero.rivendel.models.DTO.UpdateHouseDTO;
import org.rojoherrero.rivendel.models.entities.House;
import org.rojoherrero.rivendel.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/house")
public class HouseController {

	private final HouseService houseService;

	@Autowired
	public HouseController(HouseService houseService) {
		this.houseService = houseService;
	}

	/* Add a new House to the Data Base */

	@RequestMapping(value = "/newHouse/form", method = RequestMethod.GET)
	public String getNewHouse(NewHouseDTO form) {
		return ("house/new_house/newHouseForm");
	}

	@RequestMapping(value = "/newHouse/form", method = RequestMethod.POST)
	public String postNewHouse(@Valid NewHouseDTO form, BindingResult result) {

		if (result.hasErrors()) {
			return ("house/new_house/newHouseForm");
		}

		Long houseId = houseService.addHouse(form);

		return ("redirect:/house/newHouse/success/houseId/" + houseId);
	}

	@RequestMapping(value = "/newHouse/success/houseId/{houseId}", method = RequestMethod.GET)
	public String successNewHouse(@PathVariable("houseId") Long houseId, Model model) {
		House house = houseService.retrieveHouseById(houseId);
		model.addAttribute("newHouse", house);
		return ("house/new_house/registration_result");
	}

	/* Search houses */

	@RequestMapping(value = "/houseSearch/searchFrom", method = RequestMethod.GET)
	public String getHouseSearchForm(HouseSearchDTO form, Model model) {
		List<String> townsList = houseService.retrieveTownNames();
		model.addAttribute("towns", townsList);
		return ("house/search_house/house_search_form");
	}

	@RequestMapping(value = "/houseSearch/searchFrom", method = RequestMethod.POST)
	public String postHouseSearchForm(@Valid HouseSearchDTO form, BindingResult result) {
		if (result.hasErrors()) {
			return ("house/search_house/house_search_form");
		}

		return ("redirect:/house/houseSearch/searchForm/result/town/" + form.getTown());
	}

	@RequestMapping(value = "/houseSearch/searchForm/result/town/{town}", method = RequestMethod.GET)
	public String searchResutl(@PathVariable("town") String town, Model model) {
		List<House> housesByTown = houseService.retrieveHousesByTown(town);
		model.addAttribute("housesByTown", housesByTown);
		model.addAttribute("townName", town);
		return ("house/search_house/houses_list");
	}

	/* Modify or Remove a House */
	@RequestMapping(value = "/houseUpdateDelete", method = RequestMethod.GET)
	public String getHouseList(Model model) {
		List<House> allHouses = houseService.retrieveAllHouses();
		model.addAttribute("houses", allHouses);
		return ("house/update_delete_house/houses_list");
	}

	@RequestMapping(value = "/houseUpdateDelete/updateform", method = RequestMethod.GET)
	public String getUpdateForm(@RequestParam("houseId") Long houseId, UpdateHouseDTO form, Model model) {
		model.addAttribute("houseId", houseId);
		return ("house/update_delete_house/update_form");
	}

	@RequestMapping(value = "/houseUpdateDelete/updateform/update", method = RequestMethod.POST)
	public String postUpdateForm(@RequestParam("houseId") Long houseId, @Valid UpdateHouseDTO form,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return ("house/update_delete_house/update_form");
		}

		houseService.updateHouse(houseId, form);

		model.addAttribute("houseId", houseId);

		return ("house/update_delete_house/update_successful");
	}

	@RequestMapping(value = "/houseUpdateDelete/delete", method = RequestMethod.GET)
	public String deleteHouse(@RequestParam("houseId") Long houseId) {
		houseService.deleteHouse(houseId);
		return ("house/update_delete_house/delete_success");
	}

}

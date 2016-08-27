package org.rojoherrero.rivendel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.entities.House;
import org.rojoherrero.rivendel.models.forms.HouseSearchForm;
import org.rojoherrero.rivendel.models.forms.NewHouseForm;
import org.rojoherrero.rivendel.models.forms.UpdateHouseForm;
import org.rojoherrero.rivendel.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/house")
public class HouseController {

	private final HouseService houseService;

	@Autowired
	public HouseController(HouseService houseService) {
		this.houseService = houseService;
	}

	/* Add a new House to the Data Base */

	@GetMapping(value = "/newHouse/form")
	public String getNewHouse(NewHouseForm form) {
		return ("house/new_house/newHouseForm");
	}

	@PostMapping(value = "/newHouse/form")
	public String postNewHouse(@Valid NewHouseForm form, BindingResult result) {

		if (result.hasErrors()) {
			return ("house/new_house/newHouseForm");
		}

		Long houseId = houseService.addHouse(form);

		return ("redirect:/house/newHouse/success/houseId/" + houseId);
	}

	@GetMapping(value = "/newHouse/success/houseId/{houseId}")
	public String successNewHouse(@PathVariable("houseId") Long houseId, Model model) {
		House house = houseService.retrieveHouseById(houseId);
		model.addAttribute("newHouse", house);
		return ("house/new_house/registration_result");
	}

	/* Search houses */

	@GetMapping(value = "/houseSearch/searchFrom")
	public String getHouseSearchForm(HouseSearchForm form, Model model) {
		List<String> townsList = houseService.retrieveTownNames();
		model.addAttribute("towns", townsList);
		return ("house/search_house/house_search_form");
	}

	@PostMapping(value = "/houseSearch/searchFrom")
	public String postHouseSearchForm(@Valid HouseSearchForm form, BindingResult result) {
		if (result.hasErrors()) {
			return ("house/search_house/house_search_form");
		}

		return ("redirect:/house/houseSearch/searchForm/result/town/" + form.getTown());
	}

	@GetMapping(value = "/houseSearch/searchForm/result/town/{town}")
	public String searchResutl(@PathVariable("town") String town, Model model) {
		List<House> housesByTown = houseService.retrieveHousesByTown(town);
		model.addAttribute("housesByTown", housesByTown);
		model.addAttribute("townName", town);
		return ("house/search_house/houses_list");
	}

	/* Modify or Remove a House */
	@GetMapping(value = "/houseUpdateDelete")
	public String getHouseList(Model model) {
		List<House> allHouses = houseService.retrieveAllHouses();
		model.addAttribute("houses", allHouses);
		return ("house/update_delete_house/houses_list");
	}

	@GetMapping(value = "/houseUpdateDelete/updateform")
	public String getUpdateForm(@RequestParam("houseId") Long houseId, UpdateHouseForm form, Model model) {
		model.addAttribute("houseId", houseId);
		return ("house/update_delete_house/update_form");
	}

	@PostMapping(value = "/houseUpdateDelete/updateform/update")
	public String postUpdateForm(@RequestParam("houseId") Long houseId, @Valid UpdateHouseForm form,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return ("house/update_delete_house/update_form");
		}

		houseService.updateHouse(houseId, form);

		model.addAttribute("houseId", houseId);

		return ("house/update_delete_house/update_successful");
	}

	@GetMapping(value = "/houseUpdateDelete/delete")
	public String deleteHouse(@RequestParam("houseId") Long houseId) {
		houseService.deleteHouse(houseId);
		return ("house/update_delete_house/delete_success");
	}

}

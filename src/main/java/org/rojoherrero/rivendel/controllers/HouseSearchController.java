package org.rojoherrero.rivendel.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.House;
import org.rojoherrero.rivendel.models.HouseSearchForm;
import org.rojoherrero.rivendel.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/house_search")
public class HouseSearchController {

	@Autowired
	private HouseRepository houseRepository;

	// Class attributes to make availables these objects on the redirects.
	private String errorTrace;
	private String town;
	private ArrayList<House> houses;

	@RequestMapping(value = "/search_form", method = RequestMethod.GET)
	public String houseSearch(HouseSearchForm searchForm, Model model) {

		List<String> towns = houseRepository.findTowns();

		model.addAttribute("towns", towns);

		return ("house_search_form");
	}

	@RequestMapping(value = "/send_search_form", method = RequestMethod.POST)
	public String houseSearchValidation(@Valid HouseSearchForm searchForm, BindingResult bindingResult, Model model) {

		// If the form has errors, return to the form
		if (bindingResult.hasErrors()) {
			return ("house_search_form");
		}

		try {
			// if everything is OK, retrieve data from the data base
			houses = houseRepository.findHousesByTown(searchForm.getTown());
			town = searchForm.getTown();
			// redirect to new URL
			return ("redirect:/house_search/search_result");

		} catch (Exception e) {

			// if something goes wrong
			e.printStackTrace();
			errorTrace = e.toString();
			// redirect to new URL
			return ("rdirect:/search_error");
		}
	}

	@RequestMapping(value = "/search_result", method = RequestMethod.GET)
	public String searchResutl(Model model) {

		model.addAttribute("town", town);
		model.addAttribute("houses", houses);

		return ("houses_list");
	}

	@RequestMapping(value = "/search_error", method = RequestMethod.GET)
	public String searchError(Model model) {

		model.addAttribute("errorTrace", errorTrace);

		return ("search_error");
	}

}

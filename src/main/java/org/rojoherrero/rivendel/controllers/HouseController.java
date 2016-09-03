package org.rojoherrero.rivendel.controllers;

import javax.validation.Valid;

import org.rojoherrero.rivendel.dto.HouseDTO;
import org.rojoherrero.rivendel.services.HouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HouseController {

	@Autowired
	private HouseServices houseServices;

	@RequestMapping(value = "/house/new_house", method = RequestMethod.GET)
	public ModelAndView getNewHouse() {
		return new ModelAndView("house/new_house", "houseDTO", new HouseDTO());
	}

	@RequestMapping(value = "/house/new_house", method = RequestMethod.POST)
	public String postNewHouse(@Valid @ModelAttribute("houseDTO") HouseDTO houseDTO, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "house/new_house";
		}

		try {
			houseServices.registerNewHouse(houseDTO);
		} catch (Exception e) {
			return "house/new_house";
		}

		return "index";
	}

	@RequestMapping(value = "/house/get_all_houses", method = RequestMethod.GET)
	public ModelAndView getAllHouses() {
		return new ModelAndView("house/all_houses", "allHouses", houseServices.retrieveAllHouses());
	}
}

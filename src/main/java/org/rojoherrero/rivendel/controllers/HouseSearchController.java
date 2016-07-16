package org.rojoherrero.rivendel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.House;
import org.rojoherrero.rivendel.models.HouseSearchForm;
import org.rojoherrero.rivendel.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class HouseSearchController extends WebMvcConfigurerAdapter {

	@Autowired
	private HouseRepository houseRepository;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/searchresult").setViewName("houseslist");
	}

	@RequestMapping(value = "/house_search", method = RequestMethod.GET)
	public String houseSearch(HouseSearchForm searchForm, Model model) {

		List<String> towns = houseRepository.findTowns();

		model.addAttribute("towns", towns);

		return ("house_search_form");
	}

	@RequestMapping(value = "/house_search", method = RequestMethod.POST)
	public String houseSearchValidation(@Valid HouseSearchForm searchForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return ("house_search_form");
		}

		try {

			List<House> housesList = houseRepository.findHousesByTown(searchForm.getTown());
			model.addAttribute("town", searchForm.getTown());
			model.addAttribute("houses", housesList);
			return ("/houses_list");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("message", "Somethig went wrong. Please, try again");
			return ("house_search_form");

		}
	}

}

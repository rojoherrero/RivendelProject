package org.rojoherrero.rivendel.controller;

import javax.validation.Valid;

import org.rojoherrero.rivendel.model.entities.HouseSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class HouseSearchController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/searchresult").setViewName("houseslist");
	}

	@RequestMapping(value = "/housesearch", method = RequestMethod.GET)
	public String housesForm(HouseSearchForm houseSearchForm) {
		return ("housesform");
	}

	@RequestMapping(value = "/housesearch", method = RequestMethod.POST)
	public String checkHousesForm(@Valid HouseSearchForm houseSearchForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ("housesform");
		}
		
		System.out.println(houseSearchForm.toString());
		System.out.println(bindingResult.toString());

		return ("redirect:/houseslist");
	}

}

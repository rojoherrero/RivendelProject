package org.rojoherrero.rivendel.controller;

import javax.validation.Valid;

import org.rojoherrero.rivendel.model.entities.HouseForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class AvailableHouseController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/houseslist").setViewName("houseslist");
	}

	@RequestMapping(value = "/housesquery", method = RequestMethod.GET)
	public String housesForm(HouseForm houseForm) {
		return ("housesform");
	}

	@RequestMapping(value = "/housesquery", method = RequestMethod.POST)
	public String checkHousesForm(@Valid HouseForm houseForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ("housesform");
		}
		
		System.out.println(houseForm.toString());

		return ("houseslist");
	}

}

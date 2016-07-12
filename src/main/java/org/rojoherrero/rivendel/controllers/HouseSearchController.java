package org.rojoherrero.rivendel.controllers;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.HouseRegistrationForm;
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
	public String housesForm() {
		return ("house_search_form");
	}

	

}

package org.rojoherrero.rivendel.controllers;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.House;
import org.rojoherrero.rivendel.models.HouseDao;
import org.rojoherrero.rivendel.models.HouseRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class HouseRegistryController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/house_registration_result").setViewName("house_registration_result");
	}

	@Autowired
	private HouseDao houseDao;

	@RequestMapping(value = "/house_registration", method = RequestMethod.GET)
	public String goToHouseRegistration(HouseRegistrationForm registrationForm) {
		return ("house_registration_form");
	}

	@RequestMapping(value = "/house_registration", method = RequestMethod.POST)
	public String validateRegistrationForm(@Valid HouseRegistrationForm registrationForm, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return ("house_registration_form");
		}

		House house = new House(registrationForm.getQuarter(), 
								registrationForm.getStreetName(),
								registrationForm.getStreetNumber(), 
								registrationForm.getZipCode(), 
								registrationForm.getTown(),
								registrationForm.getCountry(), 
								registrationForm.getHouseSurface(), 
								registrationForm.getGardenSurface(),
								registrationForm.getHouseSurface() + registrationForm.getGardenSurface());
		houseDao.save(house);

		return ("house_registration_result");
	}

}

package org.rojoherrero.rivendel.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.House;
import org.rojoherrero.rivendel.models.HouseRegistrationForm;
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
@RequestMapping("/house_registry")
public class HouseRegistryController extends WebMvcConfigurerAdapter {

	// Dependency injection of the house repo. I didn't invoke a new instance of
	// the HouseRepository, Spring do it for me
	@Autowired
	private HouseRepository houseRepository;

	/**
	 * new form for house searching
	 * 
	 * @param registrationForm
	 * @return the form view
	 */
	@RequestMapping(value = "/registration_from", method = RequestMethod.GET)
	public String goToHouseRegistration(HouseRegistrationForm registrationForm) {
		return ("registry/house_registration_form");
	}

	/**
	 * retrieve the form data from the view
	 * 
	 * @param registrationForm
	 * @param bindingResult
	 * @param model
	 * @return the form validation view
	 * @author rojoherrero
	 */
	@RequestMapping(value = "/send_house_registration", method = RequestMethod.POST)
	public String validateRegistrationForm(@Valid HouseRegistrationForm registrationForm, BindingResult bindingResult,
			Model model) {

		// if something is wrong, return to the form
		if (bindingResult.hasErrors()) {
			return ("registry/house_registration_form");
		}

		// if everything is ok, save the new house
		House house = new House(registrationForm.getQuarter(), registrationForm.getStreetName(),
				registrationForm.getStreetNumber(), registrationForm.getZipCode(), registrationForm.getTown(),
				registrationForm.getCountry(), registrationForm.getHouseSurface(), registrationForm.getGardenSurface(),
				registrationForm.getHouseSurface() + registrationForm.getGardenSurface(), Calendar.getInstance());
		houseRepository.save(house);

		return ("registry/registration_result");
	}

}

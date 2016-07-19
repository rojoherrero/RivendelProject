package org.rojoherrero.rivendel.controllers;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.rojoherrero.rivendel.models.House;
import org.rojoherrero.rivendel.models.HouseModifyForm;
import org.rojoherrero.rivendel.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/house_modify")
public class HouseModifyController {

	@Autowired
	private HouseRepository houseRepository;

	private String errorTrace;
	private House houseToModify;
	private Long houseId;

	/**
	 * 
	 * @return
	 * @author rojoherrero
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String housesList(Model model) {

		try {
			List<House> allHouses = houseRepository.findAll();
			model.addAttribute("allHouses", allHouses);
			return ("modify/houses_list");
		} catch (Exception e) {
			e.printStackTrace();
			errorTrace = e.toString();
			return ("redirect:/house_modify/error");
		}
	}

	@RequestMapping(value = "/house_to_modify/houseId/{houseId}", method = RequestMethod.GET)
	public String modifyHouse(@PathVariable("houseId") Long _houseId, HouseModifyForm modifyForm, Model model) {
		houseToModify = houseRepository.findOne(_houseId);
		model.addAttribute("house", houseToModify);
		return ("modify/modify_form");
	}

	@RequestMapping(value = "/house_to_delete/houseId/{houseId}")
	public String deleteHouse(@PathVariable("houseId") Long _houseId) {
		houseRepository.delete(_houseId);
		return ("modify/delete_success");
	}

	@RequestMapping(value = "/update_house", method = RequestMethod.POST)
	public String postModifyHouse(@Valid HouseModifyForm modifyForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return ("modify/modify_form");
		}

		try {
			houseRepository.upDateHouseData(modifyForm.getQuarter(), modifyForm.getStreetName(),
					modifyForm.getStreetNumber(), modifyForm.getZipCode(), modifyForm.getTown(),
					modifyForm.getCountry(), modifyForm.getHouseSurface(), modifyForm.getGardenSurface(),
					modifyForm.getHouseSurface() + modifyForm.getGardenSurface(), Calendar.getInstance(),
					houseToModify.getId());
			return ("redirect:/index");

		} catch (Exception e) {
			e.printStackTrace();
			errorTrace = e.toString();
			return ("house_modify/error");
		}

	}

	@RequestMapping(value = "/house_modify/error")
	public String errorPage(Model model) {
		model.addAttribute("error", errorTrace);
		return ("modify/error");
	}
}

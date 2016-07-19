package org.rojoherrero.rivendel.controllers;

import java.util.List;

import org.rojoherrero.rivendel.models.House;
import org.rojoherrero.rivendel.models.HouseModifyForm;
import org.rojoherrero.rivendel.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/house_modify")
public class HouseModifyController {

	@Autowired
	private HouseRepository houseRepository;

	private House houseToModify;

	/**
	 * 
	 * @return
	 * @author rojoherrero
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String housesList(Model model) {

		List<House> allHouses = houseRepository.findAll();
		model.addAttribute("allHouses", allHouses);

		return ("modify/houses_list");
	}

	@RequestMapping("/house_to_modify/houseId/{houseId}")
	public String modifyHouse(@PathVariable("houseId") Long houseId, HouseModifyForm modifyForm, Model model) {

		houseToModify = houseRepository.findOne(houseId);
		model.addAttribute("house", houseToModify);
		return ("modify/modify_form");
	}
}

package org.rojoherrero.rivendel.controllers.authenticated;

import java.util.HashMap;

import javax.validation.Valid;

import org.rojoherrero.rivendel.dto.HouseDTO;
import org.rojoherrero.rivendel.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HouseController {

	@Autowired
	private HouseService houseService;

	@RequestMapping(value = "/house/new_house", method = RequestMethod.GET)
	public ModelAndView getNewHouse() {
		return new ModelAndView("private_pages/house/new_house", "houseDTO", new HouseDTO());
	}

	@RequestMapping(value = "/house/new_house", method = RequestMethod.POST)
	public String postNewHouse(@Valid @ModelAttribute("houseDTO") HouseDTO houseDTO, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "private_pages/house/new_house";
		}

		try {
			houseService.saveHouse(houseDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return "private_pages/house/new_house";
		}

		return "private_pages/house/success";
	}

	@RequestMapping(value = "/house/get_all_houses", method = RequestMethod.GET)
	public ModelAndView getAllHouses() {
		return new ModelAndView("private_pages/house/all_houses", "allHouses", houseService.retrieveAllHouses());
	}

	@RequestMapping(value = "/house/update", method = RequestMethod.GET)
	public ModelAndView getModifyHouse(@RequestParam("house_id") long houseId) {
		HashMap<String, HouseDTO> objectsToView = new HashMap<String, HouseDTO>() {
			private static final long serialVersionUID = -8011457526055734430L;
			{
				put("newHouseValues", new HouseDTO());
				put("oldHouseValues", houseService.retrieveHouseToUpdate(houseId));
			}
		};
		return new ModelAndView("private_pages/house/house_update_form", objectsToView);
	}

	@RequestMapping(value = "/house/{house_id}/update", method = RequestMethod.POST)
	public String postModifyHouse(@ModelAttribute("newHouseValues") HouseDTO newHouseValues,
			@PathVariable("house_id") long houseId) {
		try {
			houseService.updateHouse(houseId, newHouseValues);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "private_pages/house/success";
	}

	@RequestMapping(value = "/house/delete", method = RequestMethod.GET)
	public String deleteHouse(@RequestParam("house_id") long houseId) {

		try {
			houseService.deleteHouseById(houseId);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/house/get_all_houses";
		}

		return "private_pages/house/success";
	}

}

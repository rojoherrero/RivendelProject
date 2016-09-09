package org.rojoherrero.rivendel.controllers.authenticated;

import java.util.Map;

import javax.validation.Valid;

import org.rojoherrero.rivendel.dto.HouseDTO;
import org.rojoherrero.rivendel.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ImmutableMap;

@Controller
public class HouseController {

	@Autowired
	private HouseService houseService;

	@GetMapping("/house/new_house")
	public ModelAndView getNewHouse() {
		return new ModelAndView("private_pages/house/new_house", "houseDTO", new HouseDTO());
	}

	@PostMapping(value = "/house/new_house")
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

	@GetMapping("/house/get_all_houses")
	public ModelAndView getAllHouses() {
		return new ModelAndView("private_pages/house/all_houses", "allHouses", houseService.retrieveAllHouses());
	}

	@GetMapping("/house/update")
	public ModelAndView getModifyHouse(@RequestParam("house_id") long houseId) {

		Map<String, HouseDTO> modelObjects = ImmutableMap.<String, HouseDTO>builder()
				.put("newHouseValues", new HouseDTO())
				.put("oldHouseValues", houseService.retrieveHouseToUpdate(houseId))
				.build();

		return new ModelAndView("private_pages/house/house_update_form", modelObjects);
	}

	@PostMapping("/house/{house_id}/update")
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

	@GetMapping("/house/delete")
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

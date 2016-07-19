package org.rojoherrero.rivendel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/house_modify")
public class HouseModifyController {

	/**
	 * 
	 * @return
	 * @author rojoherrero
	 */
	@RequestMapping(value = "/houses_to_modify", method = RequestMethod.GET)
	public String modifyForm() {
		return ("modify/house_modify_form");
	}
}

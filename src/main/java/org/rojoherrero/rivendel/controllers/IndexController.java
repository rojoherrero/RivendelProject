package org.rojoherrero.rivendel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * any request to "/" or "/index" are sent to index.html
	 * 
	 * @return
	 * @author rojoherrero
	 */
	@RequestMapping(value = { "/", "/index" })
	public String goToIndex() {
		return ("index");
	}

}

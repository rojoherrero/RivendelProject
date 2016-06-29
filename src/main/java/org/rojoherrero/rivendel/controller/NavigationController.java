package org.rojoherrero.rivendel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

	@RequestMapping(value = "/")
	public String index() {
		return ("index");
	}

	@RequestMapping(value = "/newcustomer")
	public String newCustomer() {
		return ("customerregistration");
	}
}

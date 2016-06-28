package org.rojoherrero.rivendel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class IndexController extends WebMvcConfigurerAdapter {

	@RequestMapping(value = "/")
	public String index() {
		return ("index");
	}

	@RequestMapping(value = "/newcustomer")
	public String newCustomer() {
		return ("customerregistration");
	}

	@RequestMapping(value = "/availablehouses")
	public String availableHouses() {
		return ("houses");
	}
}

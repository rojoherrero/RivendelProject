package org.rojoherrero.rivendel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class MvcConfigController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/info_and_contact/about_us").setViewName("infoAndContact/aboutus");
		registry.addViewController("/info_and_contact/contact_us").setViewName("infoAndContact/contactus");
	}

	
}

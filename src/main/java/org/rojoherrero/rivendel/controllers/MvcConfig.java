package org.rojoherrero.rivendel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("public_pages/public_home");
		registry.addViewController("/home").setViewName("public_pages/public_home");
		registry.addViewController("/login").setViewName("public_pages/login");
		registry.addViewController("/access").setViewName("private_pages/private_home");
		registry.addViewController("/private_home").setViewName("private_pages/private_home");
	}
}

package org.rojoherrero.rivendel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info_and_contact")
public class AgencyInfoController {

	@RequestMapping("/about_us")
	public String aboutUsInfo() {
		return ("infoAndContact/aboutus");
	}

	@RequestMapping("/contact_us")
	public String contactUs() {
		return ("infoAndContact/contactus");
	}

}

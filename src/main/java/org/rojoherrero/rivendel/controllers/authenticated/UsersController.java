package org.rojoherrero.rivendel.controllers.authenticated;

import org.rojoherrero.rivendel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ModelAndView getUserPage() {
		return new ModelAndView("users", "users", userService.getAllUsers());
	}
}

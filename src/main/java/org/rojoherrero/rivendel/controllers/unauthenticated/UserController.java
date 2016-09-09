package org.rojoherrero.rivendel.controllers.unauthenticated;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.rojoherrero.rivendel.dto.UserDTO;
import org.rojoherrero.rivendel.services.UserService;
import org.rojoherrero.rivendel.utils.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserCreateFormValidator userCreateFormValidator;

	@InitBinder("userDTO")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userCreateFormValidator);
	}

	@GetMapping("/user/create")
	public ModelAndView getNewUserForm() {
		return new ModelAndView("public_pages/new_user_form", "userDTO", new UserDTO());
	}

	@PostMapping("/user/create")
	public String postNewUserForm(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "public_pages/new_user_form";
		}
		try {
			userService.createNewUser(userDTO);
			//model.addAttribute("newUser", attributeValue)
			return "redirect:/home";
		} catch (Exception e) {
			result.reject("email.exists", "Email already exists");
			return "public_pages/new_user_form"; // new user form
		}
		
	}

	@GetMapping("/user/{id}")
	public ModelAndView getUserPage(@PathVariable("id") Long userId) {
		return new ModelAndView("user","user", userService.getUserById(userId)
				.orElseThrow(()-> new NoSuchElementException(String.format("User=%s not found", userId))));
	}
}

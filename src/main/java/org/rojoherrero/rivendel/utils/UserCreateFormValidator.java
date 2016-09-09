package org.rojoherrero.rivendel.utils;

import org.rojoherrero.rivendel.dto.UserDTO;
import org.rojoherrero.rivendel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserCreateFormValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;
		validatePasswords(errors, userDTO);
		validateEmail(errors, userDTO);

	}

	private void validateEmail(Errors errors, UserDTO userDTO) {
		if (!userDTO.getPassword().equals(userDTO.getPasswordRepeated())) {
			errors.reject("password.no_match", "Passwords do not match");
		}

	}

	private void validatePasswords(Errors errors, UserDTO userDTO) {
		if (userService.getUserByEmail(userDTO.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }

	}

}

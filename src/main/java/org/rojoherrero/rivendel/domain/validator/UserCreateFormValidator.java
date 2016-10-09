package org.rojoherrero.rivendel.domain.validator;

import org.rojoherrero.rivendel.domain.dto.CustomerDTO;
import org.rojoherrero.rivendel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserCreateFormValidator implements Validator {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateFormValidator.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(CustomerDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LOGGER.debug("Validating {}", target);
		CustomerDTO form = (CustomerDTO) target;
		validatePasswords(errors, form);
		validateEmail(errors, form);

	}
	
	private void validatePasswords(Errors errors, CustomerDTO customerDTO){
		if(customerDTO.getPassword().equals(customerDTO.getPasswordRepeated())){
			errors.reject("password.no_match", "Passwords do not match");
		}
	}
	
	private void validateEmail(Errors errors, CustomerDTO customerDTO){
		if(userService.getUserByEmail(customerDTO.getEmail()).isPresent()){
			errors.reject("email.exists", "User with this email already exists");
		}
	}

}

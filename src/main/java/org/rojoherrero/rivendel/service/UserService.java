package org.rojoherrero.rivendel.service;

import java.util.Optional;

import org.rojoherrero.rivendel.domain.customer.Customer;
import org.rojoherrero.rivendel.domain.customer.CustomerCreateForm;

public interface UserService {
	
	Optional<Customer> getUserById(long userId);
	
	Optional<Customer> getUserByEmail(String userEmail);
	
	Iterable<Customer> getAllUsers();
	
	Customer createNewUser(CustomerCreateForm userCreateForm);
}

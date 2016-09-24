package org.rojoherrero.rivendel.service.impl;

import java.util.Optional;

import org.rojoherrero.rivendel.domain.customer.Customer;
import org.rojoherrero.rivendel.domain.customer.CustomerCreateForm;
import org.rojoherrero.rivendel.repository.UserRepository;
import org.rojoherrero.rivendel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Optional<Customer> getUserById(long userId) {
		return Optional.ofNullable(userRepo.findOne(userId));
	}

	@Override
	public Optional<Customer> getUserByEmail(String userEmail) {
		return userRepo.findOneByEmail(userEmail);
	}

	@Override
	public Iterable<Customer> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Customer createNewUser(CustomerCreateForm userCreateForm) {
		Customer customer = new Customer();
		customer.setEmail(userCreateForm.getEmail());
		customer.setPasswordHash(new BCryptPasswordEncoder().encode(userCreateForm.getPassword()));
		customer.setRole(userCreateForm.getRole());
		return userRepo.save(customer);
	}

}

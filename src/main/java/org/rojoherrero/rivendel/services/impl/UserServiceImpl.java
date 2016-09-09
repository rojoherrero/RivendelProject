package org.rojoherrero.rivendel.services.impl;

import java.util.Optional;

import org.rojoherrero.rivendel.dto.UserDTO;
import org.rojoherrero.rivendel.entities.User;
import org.rojoherrero.rivendel.repositories.UserRepository;
import org.rojoherrero.rivendel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public Optional<User> getUserById(Long userId) {
		return Optional.ofNullable(userRepo.findOne(userId));
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepo.findOneByEmail(email);
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User createNewUser(UserDTO userDTO) {
		User user = new User();

		user.setEmail(userDTO.getEmail());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		user.setRole(userDTO.getRole());

		return userRepo.save(user);
	}

}

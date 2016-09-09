package org.rojoherrero.rivendel.services;

import java.util.Optional;

import org.rojoherrero.rivendel.dto.UserDTO;
import org.rojoherrero.rivendel.entities.User;

public interface UserService {

	Optional<User> getUserById(Long userId);

	Optional<User> getUserByEmail(String email);

	Iterable<User> getAllUsers();

	User createNewUser(UserDTO userDTO);
}

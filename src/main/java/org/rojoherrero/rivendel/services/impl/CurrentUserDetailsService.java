package org.rojoherrero.rivendel.services.impl;

import org.rojoherrero.rivendel.entities.User;
import org.rojoherrero.rivendel.services.UserService;
import org.rojoherrero.rivendel.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getUserByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User with emali=%s was not found", email)));
		return new CurrentUser(user);
	}

}

package org.rojoherrero.rivendel.services.impl;

import org.rojoherrero.rivendel.services.CurrentUserService;
import org.rojoherrero.rivendel.utils.CurrentUser;
import org.rojoherrero.rivendel.utils.Role;

public class CurrentUserServiceImpl implements CurrentUserService {

	@Override
	public boolean canAccessUser(CurrentUser currentUser, long userId) {
		return currentUser != null && (currentUser.getRole() == Role.USER || currentUser.getUserId().equals(userId));
	}

}

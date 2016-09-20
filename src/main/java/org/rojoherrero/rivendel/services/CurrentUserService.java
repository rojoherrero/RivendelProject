package org.rojoherrero.rivendel.services;

import org.rojoherrero.rivendel.utils.CurrentUser;

public interface CurrentUserService {
	boolean canAccessUser(CurrentUser currentUser, long userId);
}

package com.last.service;

import com.last.model.CurrentUser;

public interface CurrentUserService {

	boolean canAccessUser(CurrentUser currentUser, String username);
	
}

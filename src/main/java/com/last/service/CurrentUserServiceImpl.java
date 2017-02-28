package com.last.service;

import com.last.model.CurrentUser;

public class CurrentUserServiceImpl implements CurrentUserService {

	@Override
	public boolean canAccessUser(CurrentUser currentUser, String username) {
		return currentUser != null 
				&& (
						"ROLE_ADMIN".equals(currentUser.getRole().getRole()) 
						|| currentUser.getUsername().equals(username) 
					);
	}

}

package com.last.model;

import org.springframework.security.core.authority.AuthorityUtils;
import com.last.model.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public CurrentUser(User user){
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public UserRole getRole(){
		return user.getRole();
	}
}

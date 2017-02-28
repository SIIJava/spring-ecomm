package com.last.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.last.form.UserCreateForm;
import com.last.model.User;

@Service("userService")
@Configurable 
public interface UserService {

	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByUsernameAndPassword(String username, String password);
	
	public void saveUser(User user);
	
	public Collection<User> getAllUsers();
	
	User create(UserCreateForm form);

	
	
}

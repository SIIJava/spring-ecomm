package com.last.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.last.form.UserCreateForm;
import com.last.model.User;
import com.last.model.UserRepository;
import com.last.model.UserRole;
import com.last.model.UserRoleRepository;

@Service	
public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;
	private final UserRoleRepository userRoleRepository;
	
	@Autowired 
	public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository){
		this.userRepo = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	
	@Override
	public Optional<User> findByUsername(String username) {
		System.out.println("find by username "+username);
		System.out.println(userRepo==null);
		User user = userRepo.findByUsername(username) ;
		if (user != null){System.out.println(user.getPassword());}
		return Optional.ofNullable(userRepo.findByUsername(username));
	}

	@Override
	public Optional<User> findByUsernameAndPassword(String username, String password) {
		return Optional.ofNullable(userRepo.findByUsernameAndPassword(username, password));
	}

	@Override
	public void saveUser(User user) {
		userRepo.save(user);		
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepo.findAll();
		
	}

	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
		UserRole role = new UserRole();
		role.setRole(form.getRole());
		role.setUser(user);
		user.setRole(role);
		return  userRepo.save(user) ;
	}

}

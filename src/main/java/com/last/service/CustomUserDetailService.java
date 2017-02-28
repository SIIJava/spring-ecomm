package com.last.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.last.model.CurrentUser;
import com.last.model.User;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);
	
	private final UserService userService;
	
	@Autowired
	public CustomUserDetailService(UserService userService){
		this.userService = userService;
	}
	
	@Override
	public CurrentUser  loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username)
				.orElseThrow( () -> new UsernameNotFoundException(String.format("Pas d'utilisateur pour le nom %s", username)));
		return new CurrentUser(user);
	}
	
//	@Transactional(readOnly=true)
//	@Override
//	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//		System.out.println("loadByUserName");
//		com.last.model.User user = userService().findByUsername(username);
//		List<GrantedAuthority> authorities = buildUserAuthority(user);
//		return buildUserForAuthentication(user, authorities);
//	}
//
//	private User buildUserForAuthentication(com.last.model.User user, List<GrantedAuthority> authorities){
//		//User de org.springframework.security.core.userdetails.User
//		return new User(user.getUsername(), user.getPassword(),
//				true, true, true, true, authorities); 
//	}
//	
//	private List<GrantedAuthority> buildUserAuthority(com.last.model.User user){
//		 List<GrantedAuthority> list =  new ArrayList<GrantedAuthority>();
//		 list.add(new SimpleGrantedAuthority(user.getRole().getRole()));
//		 return list;
//	}
}

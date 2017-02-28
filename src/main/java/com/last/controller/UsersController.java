package com.last.controller;

import java.util.Collection;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.last.form.UserCreateForm;
import com.last.form.UserCreateFormValidator;
import com.last.model.User;
import com.last.service.UserService;

@Controller
public class UsersController {

	private final UserService userService;
	private final UserCreateFormValidator userCreateFormValidator;

	@Autowired
	public UsersController(UserService userService, UserCreateFormValidator userCreateFormValidator){
		this.userService = userService;
		this.userCreateFormValidator =userCreateFormValidator;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(userCreateFormValidator);
	}

	@PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
	@RequestMapping("/user/{username}")
	public ModelAndView getUserPage(@PathVariable String username){
		return new ModelAndView("user", "user", userService.findByUsername(username)
				.orElseThrow(() -> new NoSuchElementException(username+" inconnu")));
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage() {
		return new ModelAndView("user_create", "form", new UserCreateForm());
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "user/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form,
			BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "user_create";
		} 
		try {
			userService.create(form);
		} catch (DataIntegrityViolationException e){
			bindingResult.reject("email.exists", "Nom utilsateur déjà existant");
			return "user_create";
		}
		return "redirect:/users";
		
	}

	@RequestMapping("/users")
	public ModelAndView getUsersPage(){
		System.out.println("list users");
		Collection<User> users = userService.getAllUsers();
		return new ModelAndView("users", "users", users );
	}


}

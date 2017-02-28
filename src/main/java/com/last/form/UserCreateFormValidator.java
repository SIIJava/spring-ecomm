package com.last.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.last.service.UserService;

@Component
public class UserCreateFormValidator implements Validator {

	private final UserService userService;
	
	@Autowired
	public UserCreateFormValidator(UserService userService){
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserCreateForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCreateForm form = (UserCreateForm) target;
		validatePasswords(errors, form);
		validateUsername(errors, form);
	}

	private void validateUsername(Errors errors, UserCreateForm form) {
		if (!form.getPassword().equals(form.getPasswordRepeated())) {
			errors.reject("password.no_match", "Passwords non correspondant");
		}
	}

	private void validatePasswords(Errors errors, UserCreateForm form) {
		if (userService.findByUsername(form.getUsername()).isPresent()) {
			errors.reject("emai.exists", "Utilisateur avec ce nom déjà présent");
		}
	}
	

	
	
}

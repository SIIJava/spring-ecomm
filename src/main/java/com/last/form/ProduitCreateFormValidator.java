package com.last.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.last.service.ProduitService;

@Component
public class ProduitCreateFormValidator implements Validator {

	private final ProduitService produitService;
	
	@Autowired
	public ProduitCreateFormValidator(ProduitService produitService){
		this.produitService = produitService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProduitCreateForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProduitCreateForm form = (ProduitCreateForm) target;
		validateProduit(errors, form);
	}



	private void validateProduit(Errors errors, ProduitCreateForm form) {
		System.out.println("validate produit "+form.getVenteOuLocation());
		if (produitService.findByNomproduit(form.getNomproduit()).isPresent()) {
			errors.reject("emai.exists", "Utilisateur avec ce nom déjà présent");
		}
	}
	

	
	
}

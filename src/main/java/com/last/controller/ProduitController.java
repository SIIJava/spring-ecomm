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

import com.last.form.ProduitCreateForm;
import com.last.form.ProduitCreateFormValidator;
import com.last.model.Produit;
import com.last.service.ProduitService;

@Controller
public class ProduitController {

	private final ProduitService produitService;
	private final ProduitCreateFormValidator produitCreateFormValidator;

	@Autowired
	public ProduitController(ProduitService produitService, ProduitCreateFormValidator produitCreateFormValidator){
		this.produitService = produitService;
		this.produitCreateFormValidator =produitCreateFormValidator;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(produitCreateFormValidator);
	}

	@RequestMapping("/produit/{produit}")
	public ModelAndView getProduitPage(@PathVariable String nomproduit){
		return new ModelAndView("user", "user", produitService.findByNomproduit(nomproduit)
				.orElseThrow(() -> new NoSuchElementException(nomproduit+" inconnu")));
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "produit/create", method = RequestMethod.GET)
	public ModelAndView getProduitCreatePage() {
		return new ModelAndView("produit_create", "form", new ProduitCreateForm());
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "produit/create", method = RequestMethod.POST)
	public String handleProduitCreateForm(@Valid @ModelAttribute("form") ProduitCreateForm form,
			BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "produit_create";
		} 
		try {
			produitService.create(form);
		} catch (DataIntegrityViolationException e){
			bindingResult.reject("produit.exists", "Produit déjà existant");
			return "produit_create";
		}
		return "redirect:/produits";
		
	}

	@RequestMapping("/produits")
	public ModelAndView getUsersPage(){
		System.out.println("list produits");
		Collection<Produit> produits = produitService.findAll();
		return new ModelAndView("produits", "produits", produits );
	}


}

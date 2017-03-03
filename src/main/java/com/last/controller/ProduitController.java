package com.last.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//	@RequestMapping("/produits")
//	public ModelAndView getUsersPage(){
//		System.out.println("list produits");
//		Collection<Produit> produits = produitService.findAll();
//		return new ModelAndView("produits", "produits", produits );
//	}

	@RequestMapping("/produits")
	public ResponseEntity<List> getUsersPage(){
		System.out.println("list produits");
		List<Produit> produits = produitService.findAll();
		System.out.println(produits.get(0).getVenteOuLocation().getLibelle());
		if (produits.isEmpty()){
			return new ResponseEntity<List>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List>(produits, HttpStatus.OK);
	}
	
	@RequestMapping("/produits/min/{min}/max/{max}")
	public ResponseEntity<List> getProduitsBetweenTarif(@PathVariable String min, @PathVariable String max){
		System.out.println("tarif controller");
		BigDecimal mini = new BigDecimal(min);
		BigDecimal maxi = new BigDecimal(max);

		List<Produit> produits = produitService.findByTarifBetween(mini, maxi);
		if (produits.isEmpty()){
			return new ResponseEntity<List>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List>(produits, HttpStatus.OK);
	}


}

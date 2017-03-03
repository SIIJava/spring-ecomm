package com.last.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.last.form.ProduitCreateForm;
import com.last.model.Produit;

@Service
@Configurable 
public interface ProduitService {

	public List<Produit> findAll();
	public Optional<Produit> findByNomproduit(String nomProduit);
//	public void saveProduit(Produit produit);
	
	Produit create(ProduitCreateForm from);
}

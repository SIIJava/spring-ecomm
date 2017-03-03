package com.last.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last.form.ProduitCreateForm;
import com.last.model.Produit;
import com.last.model.ProduitRepository;
import com.last.model.VenteOuLocation;
import com.last.model.VenteOuLocationRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired 
	ProduitRepository produitRepo;
	
	@Autowired
	VenteOuLocationRepository vlRepo;
	
	@Override
	public List<Produit> findAll() {
		return produitRepo.findAll();
	}

	@Override
	public Optional<Produit> findByNomproduit(String nomProduit) {
		return Optional.ofNullable(produitRepo.findByNomproduit(nomProduit));
	}

//	@Override
//	public void saveProduit(Produit produit) {
//		 produitRepo.save(produit);
//	}

	@Override
	public Produit create(ProduitCreateForm form) {
		System.out.println("create");
		Produit produit = new Produit();
		produit.setDescription(form.getDescription());
		produit.setLibelle(form.getLibelle());
		produit.setTarif(form.getTarif());
		produit.setNomproduit(form.getNomproduit());
		VenteOuLocation vl = vlRepo.findOne(form.getVenteOuLocation());
		System.out.println("vl "+vl.getLibelle());
		produit.setVenteOuLocation(vl);
		return produitRepo.save(produit);
	}

}

package com.last.form;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

public class ProduitCreateForm {

	@NotEmpty
	private String description = "";
	@NotEmpty
	private String libelle = "";
	@NotEmpty
	private String nomproduit = "";

	private BigDecimal tarif = new BigDecimal(0);
	
	private Integer venteOuLocation = 0; 

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getNomproduit() {
		return nomproduit;
	}
	public void setNomproduit(String nomproduit) {
		this.nomproduit = nomproduit;
	}
	public BigDecimal getTarif() {
		return tarif;
	}
	public void setTarif(BigDecimal tarif) {
		this.tarif = tarif;
	}
	public Integer getVenteOuLocation() {
		return venteOuLocation;
	}
	public void setVenteOuLocation(Integer venteOuLocation) {
		this.venteOuLocation = venteOuLocation;
	}



}

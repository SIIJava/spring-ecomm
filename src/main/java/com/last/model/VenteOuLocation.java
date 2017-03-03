package com.last.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the vente_ou_location database table.
 * 
 */
@Entity
@Table(name="vente_ou_location")
@NamedQuery(name="VenteOuLocation.findAll", query="SELECT v FROM VenteOuLocation v")
public class VenteOuLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idvente_ou_loc")
	private int idventeOuLoc;

	private String libelle;

	//bi-directional many-to-one association to Produit
	@OneToMany(fetch=FetchType.LAZY, mappedBy="venteOuLocation" )
	@JsonIgnore
	private List<Produit> produits;

	public VenteOuLocation() {
	}

	public int getIdventeOuLoc() {
		return this.idventeOuLoc;
	}

	public void setIdventeOuLoc(int idventeOuLoc) {
		this.idventeOuLoc = idventeOuLoc;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setVenteOuLocation(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setVenteOuLocation(null);

		return produit;
	}

}
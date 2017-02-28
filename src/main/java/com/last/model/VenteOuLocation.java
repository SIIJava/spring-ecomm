package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@OneToMany(mappedBy="venteOuLocation")
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
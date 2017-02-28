package com.last.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produit_genres_ages database table.
 * 
 */
@Entity
@Table(name="produit_genres_ages")
@NamedQuery(name="ProduitGenresAge.findAll", query="SELECT p FROM ProduitGenresAge p")
public class ProduitGenresAge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpga;

	//bi-directional many-to-one association to CategorieAge
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idage")
	private CategorieAge categorieAge;

	//bi-directional many-to-one association to CategorieGenre
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idgenre")
	private CategorieGenre categorieGenre;

	//bi-directional many-to-one association to Produit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idproduit")
	private Produit produit;

	public ProduitGenresAge() {
	}

	public int getIdpga() {
		return this.idpga;
	}

	public void setIdpga(int idpga) {
		this.idpga = idpga;
	}

	public CategorieAge getCategorieAge() {
		return this.categorieAge;
	}

	public void setCategorieAge(CategorieAge categorieAge) {
		this.categorieAge = categorieAge;
	}

	public CategorieGenre getCategorieGenre() {
		return this.categorieGenre;
	}

	public void setCategorieGenre(CategorieGenre categorieGenre) {
		this.categorieGenre = categorieGenre;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
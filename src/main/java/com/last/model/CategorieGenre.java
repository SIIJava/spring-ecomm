package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie_genre database table.
 * 
 */
@Entity
@Table(name="categorie_genre")
@NamedQuery(name="CategorieGenre.findAll", query="SELECT c FROM CategorieGenre c")
public class CategorieGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idcategorie_genre")
	private int idcategorieGenre;

	private String genre;

	//bi-directional many-to-one association to Enfant
	@OneToMany(mappedBy="categorieGenre")
	private List<Enfant> enfants;

	//bi-directional many-to-one association to ProduitGenresAge
	@OneToMany(mappedBy="categorieGenre")
	private List<ProduitGenresAge> produitGenresAges;

	public CategorieGenre() {
	}

	public int getIdcategorieGenre() {
		return this.idcategorieGenre;
	}

	public void setIdcategorieGenre(int idcategorieGenre) {
		this.idcategorieGenre = idcategorieGenre;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Enfant> getEnfants() {
		return this.enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}

	public Enfant addEnfant(Enfant enfant) {
		getEnfants().add(enfant);
		enfant.setCategorieGenre(this);

		return enfant;
	}

	public Enfant removeEnfant(Enfant enfant) {
		getEnfants().remove(enfant);
		enfant.setCategorieGenre(null);

		return enfant;
	}

	public List<ProduitGenresAge> getProduitGenresAges() {
		return this.produitGenresAges;
	}

	public void setProduitGenresAges(List<ProduitGenresAge> produitGenresAges) {
		this.produitGenresAges = produitGenresAges;
	}

	public ProduitGenresAge addProduitGenresAge(ProduitGenresAge produitGenresAge) {
		getProduitGenresAges().add(produitGenresAge);
		produitGenresAge.setCategorieGenre(this);

		return produitGenresAge;
	}

	public ProduitGenresAge removeProduitGenresAge(ProduitGenresAge produitGenresAge) {
		getProduitGenresAges().remove(produitGenresAge);
		produitGenresAge.setCategorieGenre(null);

		return produitGenresAge;
	}

}
package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie_age database table.
 * 
 */
@Entity
@Table(name="categorie_age")
@NamedQuery(name="CategorieAge.findAll", query="SELECT c FROM CategorieAge c")
public class CategorieAge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idcategorie_age")
	private int idcategorieAge;

	private Integer ageMin;
	
	private Integer ageMax;

	//bi-directional many-to-one association to ProduitGenresAge
	@OneToMany(mappedBy="categorieAge")
	private List<ProduitGenresAge> produitGenresAges;

	public CategorieAge() {
	}

	public int getIdcategorieAge() {
		return this.idcategorieAge;
	}

	public void setIdcategorieAge(int idcategorieAge) {
		this.idcategorieAge = idcategorieAge;
	}

	public Integer getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(Integer ageMin) {
		this.ageMin = ageMin;
	}

	public Integer getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(Integer ageMax) {
		this.ageMax = ageMax;
	}

	public List<ProduitGenresAge> getProduitGenresAges() {
		return this.produitGenresAges;
	}

	public void setProduitGenresAges(List<ProduitGenresAge> produitGenresAges) {
		this.produitGenresAges = produitGenresAges;
	}

	public ProduitGenresAge addProduitGenresAge(ProduitGenresAge produitGenresAge) {
		getProduitGenresAges().add(produitGenresAge);
		produitGenresAge.setCategorieAge(this);

		return produitGenresAge;
	}

	public ProduitGenresAge removeProduitGenresAge(ProduitGenresAge produitGenresAge) {
		getProduitGenresAges().remove(produitGenresAge);
		produitGenresAge.setCategorieAge(null);

		return produitGenresAge;
	}

}
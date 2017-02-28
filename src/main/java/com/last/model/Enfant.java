package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the enfant database table.
 * 
 */
@Entity
@NamedQuery(name="Enfant.findAll", query="SELECT e FROM Enfant e")
public class Enfant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idenfant;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to CategorieGenre
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sexe")
	private CategorieGenre categorieGenre;

	//bi-directional many-to-one association to Famille
	@OneToMany(mappedBy="enfantBean")
	private List<Famille> familles;

	public Enfant() {
	}

	public int getIdenfant() {
		return this.idenfant;
	}

	public void setIdenfant(int idenfant) {
		this.idenfant = idenfant;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public CategorieGenre getCategorieGenre() {
		return this.categorieGenre;
	}

	public void setCategorieGenre(CategorieGenre categorieGenre) {
		this.categorieGenre = categorieGenre;
	}

	public List<Famille> getFamilles() {
		return this.familles;
	}

	public void setFamilles(List<Famille> familles) {
		this.familles = familles;
	}

	public Famille addFamille(Famille famille) {
		getFamilles().add(famille);
		famille.setEnfantBean(this);

		return famille;
	}

	public Famille removeFamille(Famille famille) {
		getFamilles().remove(famille);
		famille.setEnfantBean(null);

		return famille;
	}

}
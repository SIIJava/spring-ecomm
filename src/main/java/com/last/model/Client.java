package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idclient;

	@Temporal(TemporalType.TIMESTAMP)
	private Date naissance;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Adresse
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="adresse")
	private Adresse adresseBean;

	//bi-directional many-to-one association to Famille
	@OneToMany(mappedBy="client")
	private List<Famille> familles;

	public Client() {
	}

	public int getIdclient() {
		return this.idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public Date getNaissance() {
		return this.naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
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

	public Adresse getAdresseBean() {
		return this.adresseBean;
	}

	public void setAdresseBean(Adresse adresseBean) {
		this.adresseBean = adresseBean;
	}

	public List<Famille> getFamilles() {
		return this.familles;
	}

	public void setFamilles(List<Famille> familles) {
		this.familles = familles;
	}

	public Famille addFamille(Famille famille) {
		getFamilles().add(famille);
		famille.setClient(this);

		return famille;
	}

	public Famille removeFamille(Famille famille) {
		getFamilles().remove(famille);
		famille.setClient(null);

		return famille;
	}

}
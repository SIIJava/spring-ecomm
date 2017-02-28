package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcommande;

	private int client;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	//bi-directional many-to-one association to Adresse
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="adressefacturation")
	private Adresse adresse1;

	//bi-directional many-to-one association to Adresse
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="adresselivraison")
	private Adresse adresse2;

	//bi-directional many-to-one association to Detailcommande
	@OneToMany(mappedBy="commandeBean")
	private List<Detailcommande> detailcommandes;

	public Commande() {
	}

	public int getIdcommande() {
		return this.idcommande;
	}

	public void setIdcommande(int idcommande) {
		this.idcommande = idcommande;
	}

	public int getClient() {
		return this.client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Adresse getAdresse1() {
		return this.adresse1;
	}

	public void setAdresse1(Adresse adresse1) {
		this.adresse1 = adresse1;
	}

	public Adresse getAdresse2() {
		return this.adresse2;
	}

	public void setAdresse2(Adresse adresse2) {
		this.adresse2 = adresse2;
	}

	public List<Detailcommande> getDetailcommandes() {
		return this.detailcommandes;
	}

	public void setDetailcommandes(List<Detailcommande> detailcommandes) {
		this.detailcommandes = detailcommandes;
	}

	public Detailcommande addDetailcommande(Detailcommande detailcommande) {
		getDetailcommandes().add(detailcommande);
		detailcommande.setCommandeBean(this);

		return detailcommande;
	}

	public Detailcommande removeDetailcommande(Detailcommande detailcommande) {
		getDetailcommandes().remove(detailcommande);
		detailcommande.setCommandeBean(null);

		return detailcommande;
	}

}
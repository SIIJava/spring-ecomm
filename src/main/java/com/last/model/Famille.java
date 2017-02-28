package com.last.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the famille database table.
 * 
 */
@Entity
@NamedQuery(name="Famille.findAll", query="SELECT f FROM Famille f")
public class Famille implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idfamille;

	//bi-directional many-to-one association to Enfant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="enfant")
	private Enfant enfantBean;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent")
	private Client client;

	public Famille() {
	}

	public int getIdfamille() {
		return this.idfamille;
	}

	public void setIdfamille(int idfamille) {
		this.idfamille = idfamille;
	}

	public Enfant getEnfantBean() {
		return this.enfantBean;
	}

	public void setEnfantBean(Enfant enfantBean) {
		this.enfantBean = enfantBean;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
package com.last.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detailcommande database table.
 * 
 */
@Entity
@NamedQuery(name="Detailcommande.findAll", query="SELECT d FROM Detailcommande d")
public class Detailcommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iddetailcommande;

	//bi-directional many-to-one association to Commande
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="commande")
	private Commande commandeBean;

	//bi-directional many-to-one association to Produit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="produit")
	private Produit produitBean;

	public Detailcommande() {
	}

	public int getIddetailcommande() {
		return this.iddetailcommande;
	}

	public void setIddetailcommande(int iddetailcommande) {
		this.iddetailcommande = iddetailcommande;
	}

	public Commande getCommandeBean() {
		return this.commandeBean;
	}

	public void setCommandeBean(Commande commandeBean) {
		this.commandeBean = commandeBean;
	}

	public Produit getProduitBean() {
		return this.produitBean;
	}

	public void setProduitBean(Produit produitBean) {
		this.produitBean = produitBean;
	}

}
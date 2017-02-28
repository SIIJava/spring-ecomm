package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idreservation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datedebut;

	private int duree;

	//bi-directional many-to-one association to Produit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="produit")
	private Produit produitBean;

	public Reservation() {
	}

	public int getIdreservation() {
		return this.idreservation;
	}

	public void setIdreservation(int idreservation) {
		this.idreservation = idreservation;
	}

	public Date getDatedebut() {
		return this.datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Produit getProduitBean() {
		return this.produitBean;
	}

	public void setProduitBean(Produit produitBean) {
		this.produitBean = produitBean;
	}

}
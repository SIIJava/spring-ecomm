package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idproduit;

	@Lob
	private String description;

	private String libelle;

	private String nomproduit;

	private BigDecimal tarif;

	//bi-directional many-to-one association to Detailcommande
	@OneToMany(mappedBy="produitBean")
	private List<Detailcommande> detailcommandes;

	//bi-directional many-to-one association to VenteOuLocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vente_ou_loc")
	private VenteOuLocation venteOuLocation;

	//bi-directional many-to-one association to ProduitGenresAge
	@OneToMany(mappedBy="produit")
	private List<ProduitGenresAge> produitGenresAges;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="produitBean")
	private List<Reservation> reservations;

	public Produit() {
	}

	public int getIdproduit() {
		return this.idproduit;
	}

	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNomproduit() {
		return this.nomproduit;
	}

	public void setNomproduit(String nomproduit) {
		this.nomproduit = nomproduit;
	}

	public BigDecimal getTarif() {
		return this.tarif;
	}

	public void setTarif(BigDecimal tarif) {
		this.tarif = tarif;
	}

	public List<Detailcommande> getDetailcommandes() {
		return this.detailcommandes;
	}

	public void setDetailcommandes(List<Detailcommande> detailcommandes) {
		this.detailcommandes = detailcommandes;
	}

	public Detailcommande addDetailcommande(Detailcommande detailcommande) {
		getDetailcommandes().add(detailcommande);
		detailcommande.setProduitBean(this);

		return detailcommande;
	}

	public Detailcommande removeDetailcommande(Detailcommande detailcommande) {
		getDetailcommandes().remove(detailcommande);
		detailcommande.setProduitBean(null);

		return detailcommande;
	}

	public VenteOuLocation getVenteOuLocation() {
		return this.venteOuLocation;
	}

	public void setVenteOuLocation(VenteOuLocation venteOuLocation) {
		this.venteOuLocation = venteOuLocation;
	}

	public List<ProduitGenresAge> getProduitGenresAges() {
		return this.produitGenresAges;
	}

	public void setProduitGenresAges(List<ProduitGenresAge> produitGenresAges) {
		this.produitGenresAges = produitGenresAges;
	}

	public ProduitGenresAge addProduitGenresAge(ProduitGenresAge produitGenresAge) {
		getProduitGenresAges().add(produitGenresAge);
		produitGenresAge.setProduit(this);

		return produitGenresAge;
	}

	public ProduitGenresAge removeProduitGenresAge(ProduitGenresAge produitGenresAge) {
		getProduitGenresAges().remove(produitGenresAge);
		produitGenresAge.setProduit(null);

		return produitGenresAge;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setProduitBean(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setProduitBean(null);

		return reservation;
	}

}
package com.last.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idadresse;

	private int codepostal;

	private int numero;

	private String pays;

	private String rue;

	private String ville;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="adresseBean")
	private List<Client> clients;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="adresse1")
	private List<Commande> commandes1;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="adresse2")
	private List<Commande> commandes2;

	public Adresse() {
	}

	public int getIdadresse() {
		return this.idadresse;
	}

	public void setIdadresse(int idadresse) {
		this.idadresse = idadresse;
	}

	public int getCodepostal() {
		return this.codepostal;
	}

	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setAdresseBean(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setAdresseBean(null);

		return client;
	}

	public List<Commande> getCommandes1() {
		return this.commandes1;
	}

	public void setCommandes1(List<Commande> commandes1) {
		this.commandes1 = commandes1;
	}

	public Commande addCommandes1(Commande commandes1) {
		getCommandes1().add(commandes1);
		commandes1.setAdresse1(this);

		return commandes1;
	}

	public Commande removeCommandes1(Commande commandes1) {
		getCommandes1().remove(commandes1);
		commandes1.setAdresse1(null);

		return commandes1;
	}

	public List<Commande> getCommandes2() {
		return this.commandes2;
	}

	public void setCommandes2(List<Commande> commandes2) {
		this.commandes2 = commandes2;
	}

	public Commande addCommandes2(Commande commandes2) {
		getCommandes2().add(commandes2);
		commandes2.setAdresse2(this);

		return commandes2;
	}

	public Commande removeCommandes2(Commande commandes2) {
		getCommandes2().remove(commandes2);
		commandes2.setAdresse2(null);

		return commandes2;
	}

}
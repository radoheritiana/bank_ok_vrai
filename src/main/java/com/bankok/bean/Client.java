package com.bankok.bean;

import java.util.ArrayList;

public class Client {
	private int id_client;
	private String nom;
	private String prenom;
	private String adresse;
	private String mot_de_passe;
	private String email;
	private String telephone;
	private String numero_cin;
	private int id_charger_clientele;
	private boolean est_verifie;

	private ArrayList<Client> clients;
	
	public Client() {

	}


	public Client(int id_client, String nom, String prenom, String adresse, String mot_de_passe, String email,
			String telephone, String numero_cin, int id_charger_clientele) {
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mot_de_passe = mot_de_passe;
		this.email = email;
		this.telephone = telephone;
		this.numero_cin = numero_cin;
		this.id_charger_clientele = id_charger_clientele;
	}


	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getMot_de_passe() {
		return mot_de_passe;
	}


	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getNumero_cin() {
		return numero_cin;
	}


	public void setNumero_cin(String numero_cin) {
		this.numero_cin = numero_cin;
	}


	public int getId_charger_clientele() {
		return id_charger_clientele;
	}


	public void setId_charger_clientele(int id_charger_clientele) {
		this.id_charger_clientele = id_charger_clientele;
	}

	public boolean isEst_verifie() {
		return est_verifie;
	}

	public void setEst_verifie(boolean est_verifie) {
		this.est_verifie = est_verifie;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id_client=" + id_client +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", adresse='" + adresse + '\'' +
				", mot_de_passe='" + mot_de_passe + '\'' +
				", email='" + email + '\'' +
				", telephone='" + telephone + '\'' +
				", numero_cin='" + numero_cin + '\'' +
				", id_charger_clientele=" + id_charger_clientele +
				'}';
	}


}

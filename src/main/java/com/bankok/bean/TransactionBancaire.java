package com.bankok.bean;

import java.util.ArrayList;

public class TransactionBancaire {
	private int id;
	private String montant;
	private String dateTransaction;
	private String type;
	private int numCompteDepart;
	private int numCompteArrive;

	private ArrayList<TransactionBancaire> transactionBancaires;
	public TransactionBancaire() {
	}

	public TransactionBancaire(int id, String montant, String dateTransaction, String type,
							   int numCompteDepart, int numCompteArrive) {
		super();
		this.id = id;
		this.montant = montant;
		this.dateTransaction = dateTransaction;
		this.type = type;
		this.numCompteDepart = numCompteDepart;
		this.numCompteArrive = numCompteArrive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public String getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(String dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumCompteDepart() {
		return numCompteDepart;
	}

	public void setNumCompteDepart(int numCompteDepart) {
		this.numCompteDepart = numCompteDepart;
	}

	public int getNumCompteArrive() {
		return numCompteArrive;
	}

	public void setNumCompteArrive(int numCompteArrive) {
		this.numCompteArrive = numCompteArrive;
	}

	public ArrayList<TransactionBancaire> getTransactionBancaires() {
		return transactionBancaires;
	}

	public void setTransactionBancaires(ArrayList<TransactionBancaire> transactionBancaires) {
		this.transactionBancaires = transactionBancaires;
	}

	@Override
	public String toString() {
		return "TransactionBancaire{" +
				"id=" + id +
				", montant=" + montant +
				", dateTransaction='" + dateTransaction + '\'' +
				", type='" + type + '\'' +
				", numCompteDepart=" + numCompteDepart +
				", numCompteArrive=" + numCompteArrive +
				'}';
	}
}

package com.bankok.dao;

import java.sql.*;
import java.util.ArrayList;

import com.bankok.bean.Client;
import com.bankok.bean.TransactionBancaire;
import com.bankok.util.DBConnection;

public class ChargerClientelleDAO {
	private Connection connection;
	
	public ChargerClientelleDAO() {
		super();
		this.connection = DBConnection.connection();
	}
	
	public ArrayList<Client> selectClientNotVerified() {
		ArrayList<Client> list_of_client_not_verified = new ArrayList<>();
		
		try {
			Statement statement = this.connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM select_client_not_verified()");
			while (result.next()) {
				Client client = new Client();
				client.setId_client(result.getInt(1));
				client.setNom(result.getString(2));
				client.setPrenom(result.getString(3));
				client.setAdresse(result.getString(4));
				client.setEmail(result.getString(6));
				client.setTelephone(result.getString(7));
				client.setNumero_cin(result.getString(8));
				list_of_client_not_verified.add(client);
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list_of_client_not_verified;
	}

	public boolean verifierClient(int _id_client, int _id_charger_clientele) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("call update_client(?, ?)");
			preparedStatement.setInt(1, _id_client);
			preparedStatement.setInt(2, _id_charger_clientele);
			boolean update = preparedStatement.execute();
			if(update) {
				return true;
			}
		} catch  (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Client> selectClientChargedBy(int id_charger_clientele) {
		ArrayList<Client> list_of_client_charged = new ArrayList<>();

		try {
			PreparedStatement preparedStatement =
					this.connection.prepareStatement("SELECT * FROM select_user_by_id_charge_clientele(?)");
			preparedStatement.setInt(1, id_charger_clientele);
			ResultSet res = preparedStatement.executeQuery();
			while (res.next()) {
				Client c = new Client();
				c.setId_client(res.getInt(1));
				c.setNom(res.getString(2));
				c.setPrenom(res.getString(3));
				c.setAdresse(res.getString(4));
				c.setEmail(res.getString(6));
				c.setTelephone(res.getString(7));
				c.setNumero_cin(res.getString(8));
				//System.out.println(res.getInt(9));
				c.setId_charger_clientele(res.getInt(10));
				list_of_client_charged.add(c);
			}
			res.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list_of_client_charged;
	}

	public ArrayList<TransactionBancaire> selectTransactionByIdClient(int id_client) {
		ArrayList<TransactionBancaire> list_of_transaction = new ArrayList<>();

		try {
			PreparedStatement preparedStatement =
					this.connection.prepareStatement("SELECT * FROM select_transaction_by_id_client(?)");
			preparedStatement.setInt(1, id_client);
			ResultSet res = preparedStatement.executeQuery();
			while (res.next()) {
				TransactionBancaire transactionBancaire = new TransactionBancaire();
				transactionBancaire.setId(res.getInt(1));
				transactionBancaire.setMontant(res.getString(2));
				transactionBancaire.setDateTransaction(res.getString(3));
				transactionBancaire.setType(res.getString(4));
				transactionBancaire.setNumCompteDepart(res.getInt(5));
				transactionBancaire.setNumCompteArrive(res.getInt(6));
				list_of_transaction.add(transactionBancaire);
			}
			res.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list_of_transaction;
	}

	public Client selectClientById(int id_client) {
		Client client = new Client();
		try {
			PreparedStatement preparedStatement =
					this.connection.prepareStatement("SELECT * FROM select_client_by_id(?)");
			preparedStatement.setInt(1, id_client);
			ResultSet res = preparedStatement.executeQuery();
			while (res.next()) {
				client.setId_client(res.getInt(1));
				client.setNom(res.getString(2));
				client.setPrenom(res.getString(3));
				client.setAdresse(res.getString(4));
				client.setEmail(res.getString(6));
				client.setTelephone(res.getString(7));
				client.setNumero_cin(res.getString(8));
				client.setId_charger_clientele(res.getInt(10));
				client.setEst_verifie(res.getBoolean(9));
			}
			res.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
}

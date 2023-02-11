package com.bankok.servlet;

import com.bankok.bean.Client;
import com.bankok.bean.TransactionBancaire;
import com.bankok.dao.ChargerClientelleDAO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String TRANSACTION_VUE = "/WEB-INF/jsp/liste-transaction.jsp";

	ChargerClientelleDAO chargerClientelleDAO;
    
    public ViewTransactionServlet() {
        super();
		this.chargerClientelleDAO = new ChargerClientelleDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(TRANSACTION_VUE);
		String id_client = request.getParameter("id_client");
		//select client by id
		Client client = this.chargerClientelleDAO.selectClientById(Integer.parseInt(id_client));
		request.setAttribute("client", client);
		//select transaction by client id
		TransactionBancaire transactionBancaire = new TransactionBancaire();
		transactionBancaire.setTransactionBancaires(
				this.chargerClientelleDAO.selectTransactionByIdClient(
						Integer.parseInt(id_client)));
		request.setAttribute("transaction", transactionBancaire);
		dispatcher.forward(request, response);	
	}

}

package com.bankok.servlet;

import com.bankok.bean.Client;
import com.bankok.dao.ChargerClientelleDAO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX_VUE = "/WEB-INF/jsp/index.jsp";
	private static int id_charger_clientele = 1;
	ChargerClientelleDAO chargerClientelleDAO;
       
  
    public IndexServlet() {
        super();
		this.chargerClientelleDAO = new ChargerClientelleDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX_VUE);
		request.getSession().setAttribute("id_charger_clientele", 1);
		this.chargerClientelleDAO = new ChargerClientelleDAO();
		//list of client charged by the charger_clientele
		Client my_client = new Client();
		my_client.setClients(this.chargerClientelleDAO.selectClientChargedBy(1));
		System.out.println(my_client.getClients().size());
		request.setAttribute("my_clients", my_client);

		//list of client not verified
		Client client_not_verified = new Client();
		client_not_verified.setClients(this.chargerClientelleDAO.selectClientNotVerified());

		request.setAttribute("client_not_verified", client_not_verified);

		dispatcher.forward(request, response);
		request.getSession().removeAttribute("success_message");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_client = request.getParameter("id_client");
		int id = Integer.parseInt(id_client);
		System.out.println(this.chargerClientelleDAO.verifierClient(id, id_charger_clientele));
		request.getSession().setAttribute("success_message", "Le client a été approuvé!");
		response.sendRedirect(request.getContextPath() + "/index.php");
	}

}

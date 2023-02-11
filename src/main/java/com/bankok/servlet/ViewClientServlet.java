package com.bankok.servlet;

import com.bankok.bean.Client;
import com.bankok.dao.ChargerClientelleDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ViewClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int id_charger_clientele = 1;
	private static final String VIEW_CLIENT_VUE = "/WEB-INF/jsp/view_client.jsp";
	ChargerClientelleDAO chargerClientelleDAO;


    public ViewClientServlet() {
        super();
		this.chargerClientelleDAO = new ChargerClientelleDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_CLIENT_VUE);
		this.chargerClientelleDAO = new ChargerClientelleDAO();
		//get client by id
		System.out.println("view client servlet");
		String id_client = request.getParameter("id_client");
		Client client = this.chargerClientelleDAO.selectClientById(Integer.parseInt(id_client));
		request.setAttribute("client", client);
		dispatcher.forward(request, response);
	}

}

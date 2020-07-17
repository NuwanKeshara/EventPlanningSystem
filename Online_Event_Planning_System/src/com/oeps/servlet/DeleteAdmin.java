package com.oeps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oeps.service.AdminRelative;


/**
 * Servlet implementation class DeleteAdmin
 */
@WebServlet("/DeleteAdmin")
public class DeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdmin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");

		/*
		 * get deleting admins ID
		 */
		String AdminID = request.getParameter("AdminID");
	
		/*
		 * Delete Admin's details from the database
		 */
		AdminRelative adminRel = new AdminRelative();
		adminRel.delete(AdminID);
		
		/*
		 * redirect to table content page
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Admins.jsp");
		dispatcher.forward(request, response);
	}

}

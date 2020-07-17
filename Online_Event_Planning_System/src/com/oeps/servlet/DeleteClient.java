package com.oeps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oeps.service.ClientRelative;


/**
 * Servlet implementation class DeleteClient
 */
@WebServlet("/DeleteClient")
public class DeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteClient() {
        super();
    }

    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		/*
		 * get deleting client's ID
		 */
		String ClientID = request.getParameter("ClientID");
	
		/*
		 * Delete client details from the table 
		 */
		ClientRelative clientRel = new ClientRelative();
		clientRel.delete(ClientID);
		
		/*
		 * redirect to client table content page
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Users.jsp");
		dispatcher.forward(request, response);
	}

}

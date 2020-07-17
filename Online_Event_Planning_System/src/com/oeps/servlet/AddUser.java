package com.oeps.servlet;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oeps.model.User;
import com.oeps.service.ClientRelative;
import com.oeps.service.GenerateID;


/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
	private ClientRelative registerUser = new ClientRelative();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		/*
		 * create a user object
		 */
		User user = User.getInstance();
		
		
		/*
		 * generate client ID
		 */
		user.setClientID(GenerateID.Client());
		
		/*
		 * get client details from registration page
		 */
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setContact(request.getParameter("contact"));
		user.setEmail(request.getParameter("email"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		
		String role = user.getUserName();
		
		/*
		 * create client session
		 */
		HttpSession session = request.getSession();
		session.setAttribute("role",role);
		session.setMaxInactiveInterval(30*60);
		
		ClientRelative clientRel = new ClientRelative();
		clientRel.Register(user);
		
		
		/*
		 * client redirect to the home page
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserHome.jsp");
		dispatcher.forward(request , response);

	}

}

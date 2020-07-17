package com.oeps.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oeps.model.Login;
import com.oeps.model.User;
import com.oeps.service.AdminRelative;
import com.oeps.service.ClientRelative;


/**
 * Servlet implementation class LoginValidate
 */
@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginValidate() {
        super();
    }

	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		/*
		 * Get user name and password from the login page
		 */
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		/*
		 * check if the user login as a client or a Admin 
		 */
		String button1 = request.getParameter("user");
		String button2 = request.getParameter("admin");
		
		/*
		 * from singleton class method
		 */
		Login login = User.getInstance();
		
		login.setUserName(userName);
		login.setPassword(password);
		
		ClientRelative validateUser = new ClientRelative();
		AdminRelative validateAdmin = new AdminRelative();
		
		/*
		 * check what login button user clicked
		 */
		
		if(button2==null && button1.equals("Sign in")) {
			
			
			if(validateUser.Validation(login)) {
				
				/*
				 * start a session as a client
				 */
				String role = userName;
				HttpSession session = request.getSession();
				session.setAttribute("role",role);
				session.setMaxInactiveInterval(30*60);
				
				/*
				 * client redirect to home page
				 */
				request.getRequestDispatcher("/UserHome.jsp").forward(request,response);
				
				
			}else {
				
				/*
				 * if login credentials are invalid 
				 */
				String ValidateMsg = "Invalid login credentials";
				request.setAttribute("role",ValidateMsg);
				request.getRequestDispatcher("/Login.jsp").forward(request,response);
			}
			
		}
		else if(button1==null && button2.equals("Log in as a admin")) {
			
			if(validateAdmin.Validation(login)) {
				
				/*
				 * Establish a session to the admin
				 */
				String role = userName;
				HttpSession session = request.getSession();
				session.setAttribute("role",role);
				session.setMaxInactiveInterval(30*60);
				
				/*
				 * redirect to the Admin login page
				 */
				request.getRequestDispatcher("/home.jsp").forward(request,response);
				
			}else {
				String ValidateMsg = "Invalid login credentials";
				request.setAttribute("role",ValidateMsg);
				request.getRequestDispatcher("/Login.jsp").forward(request,response);
			}
			
		}
		
		
		
		
	}

}

package com.oeps.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oeps.model.Admin;
import com.oeps.model.User;
import com.oeps.service.AdminRelative;
import com.oeps.service.GenerateID;

/**
 * Servlet implementation class AddAdmin
 */
@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdmin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Admin redirect to the Admin form page ( No sensitive data passing through URL)
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AdminForm.jsp");
		dispatcher.forward(request , response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * send Admin to Admins page and dispaly Admin details table 
		 */
		
		response.setContentType("text/html");
		
		/*
		 *check if Admin wants add another Admin
		 */
		if(request.getParameter("newAdmin").equals("return")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Admins.jsp");
			dispatcher.forward(request , response);
			
		}
		else {
		Admin admin = Admin.getInstance();
		
		admin.setAdminID(GenerateID.Admin());
		
		/*
		 * collect Admin details
		 */
		admin.setFirstName(request.getParameter("firstName"));
		admin.setLastName(request.getParameter("lastName"));
		admin.setContact(request.getParameter("contact"));
		admin.setAddress(request.getParameter("address"));
		admin.setUserName(request.getParameter("userName"));
		admin.setPassword(request.getParameter("password"));
		
		AdminRelative AdminRel = new AdminRelative();
		AdminRel.Register(admin);
		
		/*
		 * redirect to the Admins page
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Admins.jsp");
		dispatcher.forward(request , response);
		}
	}

}

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
import com.oeps.service.AdminRelative;


/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminRelative adminRel = new AdminRelative();
       
    
    public UpdateAdmin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		/*
		 * create admin instance
		 */
		Admin uAdmin = Admin.getInstance();
		
		
		uAdmin.setAdminID(request.getParameter("AdminID"));
		uAdmin.setFirstName(request.getParameter("firstName"));
		uAdmin.setLastName(request.getParameter("lastName"));
		uAdmin.setContact(request.getParameter("contact"));
		uAdmin.setAddress(request.getParameter("address"));
		uAdmin.setPassword(request.getParameter("password"));
		
		/*
		 * update admin details
		 */
		adminRel.Update(uAdmin);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Admins.jsp");
		dispatcher.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String AdminID = request.getParameter("AdminID");			
		Admin admin = adminRel.showAdmin(AdminID);

		/*
		 * redirect to update admin details
		 */
		request.setAttribute("admin",admin);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/UpdateAdmin.jsp");
		dispatcher.forward(request, response);
	}

}

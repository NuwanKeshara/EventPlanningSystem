package com.oeps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oeps.service.AdminRelative;
import com.oeps.service.ClientRelative;
import com.oeps.util.CommonUtil;
import com.oeps.util.DBconnection;

/**
 * Servlet implementation class UserNameCheck
 */
@WebServlet("/UserNameCheck")
public class UserNameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserNameCheck() {
        super();
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * take User name
		 */
		String userName = request.getParameter("userName");
		
		
		try {
			
			AdminRelative adminrel = new AdminRelative();
			ClientRelative clientRel = new ClientRelative();
			
			ResultSet result1 = adminrel.AdminUserNameCheck(userName);
			ResultSet result2 = clientRel.UserUserNameCheck(userName);
			/*
			 * check if user name already taken or not
			 */
			if(result1.next() || result2.next()) {
				
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Already Exist");
				
			}else {
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("");
				
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}

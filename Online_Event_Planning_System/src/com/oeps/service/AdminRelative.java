package com.oeps.service;


/*
 *Use flyweight Design pattern 
 *to minimise the number of objects create from the Admin class
 */

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;


import org.xml.sax.SAXException;

import com.oeps.model.Admin;
import com.oeps.model.Login;
import com.oeps.model.User;
import com.oeps.util.CommonUtil;
import com.oeps.util.DBconnection;
import com.oeps.util.Query;




/*
 * IMPLEMENT CLASS FROM INTERFACE
 */


public class  AdminRelative implements Admin_Interface{

	public static final Logger log = Logger.getLogger(AdminRelative.class.getName());
	
	static {
		
		/**create table or drop if exist*/
		//createTable();
	}
	
	public AdminRelative() {}
	
	
	public static void createTable() {

		try {
			
			Connection connection = DBconnection.getConnection();
			Statement statement = connection.createStatement();
			
			/* Drop tables admin if already exists and as per SQL query available in
			* Query.xml
			*/
			statement.executeUpdate(Query.query(CommonUtil.DROP_TABLE_ADMIN));
			
			
			/* Create new table as per SQL query available in
			* Query.xml
			*/
			statement.executeUpdate(Query.query(CommonUtil.CREATE_TABLE_ADMIN));
			
			
			/*
			 * default admin username = 'root' & password = 'root'
			 */
			statement.executeUpdate(Query.query(CommonUtil.DEFAULT_ADMIN));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/*
	 * Admin Login Validation
	 * check for the Admin credentials are valid 
	 * if so return true 
	 */
	public boolean Validation(Login login) {

		boolean flag = false;

		try {
			
			/*
			 * get the Established connection with Database from the DBconnection class
			 * and create a Statement to execute the SQL statements 
			 */
			Connection connection = DBconnection.getConnection();
			Statement statement = connection.createStatement();

			/*
			 * Execute the SQL statement and get the table content to a Object set
			 * user name and password as one object
			 */
			ResultSet result = statement.executeQuery(Query.query(CommonUtil.SELECT_ADMIN_SQL));

			
			/*
			 * iterate the set until no table contents 
			 */
			while (result.next()) {
				
				/*
				 * check for the user name and the password are valid 
				 */
				if (login.getUserName().equals(result.getString(1))
						&& login.getPassword().equals(result.getString(2))) {

					/*
					 * Close prepared statement and database connectivity at the end of transaction
					 */
					if (statement != null) {
						statement.close();
					}
					if (connection != null) {
						connection.close();
					}

					/*
					 * if credentials are valid then send true
					 */
					flag = true;
					return flag;
				}
			}
			// response.sendRedirect("error.jsp");
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
			return flag;

		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}
		return flag;

	}

	
	
	public void Register(Admin admin) {

		try {
			
			Connection connection = DBconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Query.query(CommonUtil.INSERT_ADMIN_SQL));

			/*
			 * Add data to the SQL statement
			 */
			preparedStatement.setString(1, admin.getAdminID());
			preparedStatement.setString(2, admin.getFirstName());
			preparedStatement.setString(3, admin.getLastName());
			preparedStatement.setString(4, admin.getContact());
			preparedStatement.setString(5, admin.getAddress());
			preparedStatement.setString(6, admin.getUserName());
			preparedStatement.setString(7, admin.getPassword());
			
			/*
			 * Execute the SQL statement
			 */
			preparedStatement.executeUpdate();

			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}

	}
	
	
	
	/*
	 *take Registered admin from the table as a List of Admin objects
	 */
	public ArrayList<Admin> ViewAdmins(){

		/*
		 *Declare Admin array object
		 */
		ArrayList<Admin> list = new ArrayList<>();

		Connection connection = DBconnection.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(Query.query(CommonUtil.SELECT_ADMINS_SQL));
			
			ResultSet results = preparedStatement.executeQuery();

			while (results.next()) {
				

				String ID = results.getString(1);
				String firstName = results.getString(2);
				String lastName = results.getString(3);
				String contact = results.getString(4);
				String address = results.getString(5);
				String userName = results.getString(6);
				String password = results.getString(7);
				
				Admin admin = new Admin(ID , firstName , lastName , contact , address , userName , password);
				
				list.add(admin);
			}

			/*
			 *close the connection
			 */
			preparedStatement.close();
			connection.close();
		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}

		

		return list;
	}

	
	/*
	 * Delete a admin from the table/system
	 */
	public void delete(String AdminID) {

		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Query.query(CommonUtil.DELETE_ADMIN_SQL));

			preparedStatement.setString(1, AdminID);
			preparedStatement.executeUpdate();

			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			preparedStatement.close();
			connection.close();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}

	}

	
	/*
	 * Return the selected admin as a Admin object from the table 
	 */
	public Admin showAdmin(String AdminID) {

		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Query.query(CommonUtil.SELECT_A_ADMIN_SQL));

			preparedStatement.setString(1, AdminID);
			ResultSet results = preparedStatement.executeQuery();

			Admin admin = Admin.getInstance();

			if (results.next()) {
				
				admin.setAdminID(results.getString(1));
				admin.setFirstName(results.getString(2));
				admin.setLastName(results.getString(3));
				admin.setContact(results.getString(4));
				admin.setAddress(results.getString(5));
				admin.setUserName(results.getString(6));
				admin.setPassword(results.getString(7));
			}

			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			preparedStatement.close();
			connection.close();
			return admin;

		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}
		return null;

	}

	
	/*
	 * Update Admin detail changes to the table
	 */
	public void Update(Admin uAdmin) {

		Connection connection = DBconnection.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(Query.query(CommonUtil.UPDATE_ADMIN_SQL));
		
			preparedStatement.setString(1, uAdmin.getFirstName());
			preparedStatement.setString(2, uAdmin.getLastName());
			preparedStatement.setString(3, uAdmin.getContact());
			preparedStatement.setString(4, uAdmin.getAddress());
			preparedStatement.setString(5, uAdmin.getPassword());
			preparedStatement.setString(6, uAdmin.getAdminID());

			/*
			 *execute the SQL statement
			 */
			preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();
		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}
		

	}
	
	public ResultSet AdminUserNameCheck(String userName) {
		
		ResultSet result = null;
		
		try {
			
			Connection con = DBconnection.getConnection();
			
			PreparedStatement preparedStatement = con.prepareStatement(Query.query(CommonUtil.SELECT_ADMIN_TO_CHECK_SQL));
			preparedStatement.setString(1,userName);
			
			result = preparedStatement.executeQuery();
			
			return result;
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}
		
		return result;
		
	}

}

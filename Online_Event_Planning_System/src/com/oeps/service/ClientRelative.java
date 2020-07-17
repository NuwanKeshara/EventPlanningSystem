package com.oeps.service;

/*
 *Use flyweight Design pattern 
 *to minimise the number of objects create from the User class
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

import com.oeps.model.Login;
import com.oeps.model.User;
import com.oeps.util.CommonUtil;
import com.oeps.util.DBconnection;
import com.oeps.util.Query;



/*
 * IMPLEMENT CLASS FROM INTERFACE
 */


public class ClientRelative implements Client_Interface{

	public static final Logger log = Logger.getLogger(ClientRelative.class.getName());
	
	static {
		
		/**create table or drop if exist*/
		//createTable();
		
	}
	
	
	public ClientRelative() {}
	
	
	public static void createTable() {

		try {
			
			Connection connection = DBconnection.getConnection();
			Statement statement = connection.createStatement();
			
			/* Drop table client if already exists and as per SQL query available in
			* Query.xml
			*/
			
			statement.executeUpdate(Query.query(CommonUtil.DROP_TABLE_CLIENT));
			
			/* Create new table as per SQL query available in
			* Query.xml
			*/
			
			statement.executeUpdate(Query.query(CommonUtil.CREATE_TABLE_CLIENT));
			
			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/*
	 * User Login Validation
	 * check for the user credentials are valid 
	 * if so return true 
	 */
	public boolean Validation(Login login){

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
			ResultSet result = statement.executeQuery(Query.query(CommonUtil.SELECT_A_CLIENT_SQL));

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

	/*
	 * User Registration
	 */
	public void Register(User user){

		try {
			
			Connection connection = DBconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Query.query(CommonUtil.INSERT_CLIENTS_SQL));

			/*
			 * Add data to the SQL statement
			 */
			preparedStatement.setString(1, user.getClientID());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getContact());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getUserName());
			preparedStatement.setString(7, user.getPassword());
			
			
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
	 * 
	 */
	public ArrayList<User> ViewUsers(){

		/*
		 * declare a User object ArrayList to get user objects
		 */
		ArrayList<User> list = new ArrayList<>();

		Connection connection = DBconnection.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(Query.query(CommonUtil.SELECT_CLIENTS_SQL));
			
			ResultSet results = preparedStatement.executeQuery();

			while (results.next()) {

				/*
				 * set user Attributes
				 */
				String ID = results.getString(1);
				String firstName = results.getString(2);
				String lastName = results.getString(3);
				String contact = results.getString(4);
				String email = results.getString(5);
				String userName = results.getString(6);
				String password = results.getString(7);
				
				User user = new User(ID , firstName , lastName , contact , email , userName , password);
				
				list.add(user);
			}

			/*
			 * close the connection
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
	 * to delete the users from the table/system
	 */
	public void delete(String ClientID) {

		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Query.query(CommonUtil.DELETE_CLIENT_SQL));

			preparedStatement.setString(1, ClientID);
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
	
	public ResultSet UserUserNameCheck(String userName) {
		
		ResultSet result = null;
		
		try {
			
			Connection con = DBconnection.getConnection();
			
			PreparedStatement preparedStatement = con.prepareStatement(Query.query(CommonUtil.SELECT_CLIENT_TO_CHECK_SQL));
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

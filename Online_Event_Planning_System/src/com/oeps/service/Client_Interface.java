/**
 * 
 */
package com.oeps.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.oeps.model.Login;
import com.oeps.model.User;

/**
 * INTERFACE
 *
 */
public interface Client_Interface {
	
	/*
	 * client access credentials validate
	 */
	boolean Validation(Login login);
	
	/*
	 * add a new client
	 */
	void Register(User user);
	
	/*
	 * display all the clients and their details
	 */
	ArrayList<User> ViewUsers();
	
	/*
	 * remove a particular client
	 */
	void delete(String UserName);
	
	/*
	 * check for a username already exists
	 */
	ResultSet UserUserNameCheck(String userName);
	
}

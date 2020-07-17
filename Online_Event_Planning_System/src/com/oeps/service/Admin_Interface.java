
package com.oeps.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.oeps.model.Admin;
import com.oeps.model.Login;
/**
 * INTERFACE
 *
 */
public interface Admin_Interface {
	
	/*
	 * validate the access credentials
	 */
	boolean Validation(Login login);
	
	
	/*
	 * add new admins
	 */
	void Register(Admin admin);
	
	/*
	 * display all the admins in db 
	 */
	ArrayList<Admin> ViewAdmins();

	/*
	 * remove a particular admin from db
	 */
	void delete(String UserName);
	
	/*
	 * select to a admin and view his details
	 */
	Admin showAdmin(String UserName);

	/*
	 * update a admin details
	 */
	void Update(Admin uAdmin);

	/*
	 * check for if a username already exists
	 */
	ResultSet AdminUserNameCheck(String userName);
}

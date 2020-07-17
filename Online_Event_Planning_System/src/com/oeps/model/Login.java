package com.oeps.model;
/*
 * ABSTRACT CLASS
 */
public abstract class Login {

	/*
	 * declare login attributes
	 */
	private String userName;
	private String password;
	
	public Login() {}
	
	
	public Login(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}


	/**
	 * @return the username
	 */
	public String getUserName() {
		return this.userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param username the username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public abstract String toString();
	
}

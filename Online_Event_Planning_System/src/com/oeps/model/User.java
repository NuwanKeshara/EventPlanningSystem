package com.oeps.model;

/*
 * User model class
 *
 */
public class User extends Login{

	/*
	 * declare User attributes
	 */
	private String clientID;

	private String firstName;

	private String lastName;

	private String contact;

	private String email;

	private static User user = null;
	

	private User() {
		
	}
	
	public static User getInstance() {
		
		if(user == null)
			return new User();
		else 
			return user;
	}
	
	

	public User(String clientID, String firstName, String lastName, String contact, String email,String userName , String password) {
		
		super(userName , password);
		this.clientID = clientID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}




	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}




	/**
	 * @return the contact
	 */
	public String getContact() {
		return this.contact;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}




	/**
	 * @return the userName
	 */
	public String getUserName() {
		 return super.getUserName();
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return super.getPassword();
	}




	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		super.setUserName(userName);
	}




	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		super.setPassword(password);
	}
	
	
	/**
	 * @return the clientID
	 */
	public String getClientID() {
		return this.clientID;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	
	
	@Override
	public String toString() {
		
		return "User ID = " + this.clientID + "\n" + "first Name = " + this.firstName + "\n" + "last Name = " + this.lastName + "\n"
				+ "Contact No = " + this.contact + "\n" + "E-mail = " + this.email + "\n" + "User Name = "
				+ super.getUserName();
	}

}
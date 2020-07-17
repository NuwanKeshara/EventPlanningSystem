package com.oeps.model;

/*
 * User model class
 * Singleton design pattern used 
 */
public class Admin extends Login{
	
	/*
	 * declare user attributes
	 */
	private String adminID;
	
	private String firstName;
	
	private String lastName;
	
	private String contact;
	
	private String address;
	
	private static Admin admin = null;
	

	
	private Admin() {}
	
	public static Admin getInstance() {
		
		if(admin == null)
			return new Admin();
		else 
			return admin;
	}
	
	
	
	public Admin(String adminID, String firstName, String lastName, String contact, String address,String userName , String password) {
		
		super(userName , password);
		this.adminID = adminID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.address = address;
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
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
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
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the adminID
	 */
	public String getAdminID() {
		return this.adminID;
	}

	/**
	 * @param adminID the adminID to set
	 */
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "first Name = " + this.firstName + "\n" + "last Name = " + this.lastName + "\n"
		+ "Contact No = " + this.contact + "\n" + "Address = " + this.address + "\n" + "User Name = "
		+ super.getUserName();
	}
	
	
}

package com.oeps.util;


import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oeps.service.ClientRelative;

/*
 * database connection
 */
public class DBconnection{

	public static final Logger log = Logger.getLogger(DBconnection.class.getName());
	/*
	 * establish the connection between Database and the Application
	 */
	public static Connection getConnection(){
		
		Connection connection = null;
		
		try {
			/*
			 * load the property file
			 */
			Properties property = new Properties();
			property.load(DBconnection.class.getResourceAsStream(CommonUtil.property_File));
			System.out.println("ABC");
			/*
			 * JDBC driver and connection path 
			 */
			Class.forName(property.getProperty(CommonUtil.jdbcDriver));
			System.out.println(property.getProperty(CommonUtil.URL));
			System.out.println(property.getProperty(CommonUtil.userName));
			System.out.println(property.getProperty(CommonUtil.password));
			
			
			connection = DriverManager.getConnection(property.getProperty(CommonUtil.URL),
					property.getProperty(CommonUtil.userName),property.getProperty(CommonUtil.password));
			
			System.out.println("DEF");
		
			
		}catch(ClassNotFoundException | SQLException | IOException e) {
			
			System.out.println("ERRRR");
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
			
		}
		
		return connection;
	}
}

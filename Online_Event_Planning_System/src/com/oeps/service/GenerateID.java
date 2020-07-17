package com.oeps.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oeps.util.CommonUtil;
import com.oeps.util.DBconnection;
import com.oeps.util.Query;

/*
 * ID GENERATOR FOR DATABASE CONTENTS
 */

public class GenerateID {

	public static final Logger log = Logger.getLogger(GenerateID.class.getName());
	
	/*
	 * unique ID patterns for clients and Admins
	 */
	private static String ClientID = "OEPS";
	private static String AdminID = "AD";

	/*
	 * generate ids for clients
	 */
	public static String Client(){

		
		/*
		 * get db connection
		 */
		Connection con = DBconnection.getConnection();
		PreparedStatement preSt;
		
		try {
			preSt = con.prepareStatement(Query.query(CommonUtil.COUNT_ROWS_CLIENTS));
			
			/*
			 * take database data to a Set
			 */
			ResultSet results = preSt.executeQuery();
			results.next();
			
			/*
			 * convert object to a integer
			 */
			int count = Integer.parseInt(results.getString(1));
			count += 1001;

			String id = String.valueOf(count);
			String newId = ClientID.concat(id);

			return newId;
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}
		
		return null;
	
	}

	
	/*
	 * generate ids for Admins
	 */
	public static String Admin(){

		
		/*
		 * get db connection
		 */
		Connection con = DBconnection.getConnection();
		PreparedStatement preSt;
		
		
		try {
			preSt = con.prepareStatement(Query.query(CommonUtil.COUNT_ROWS_ADMINS));
			
			ResultSet results = preSt.executeQuery();
			results.next();

			
			int count = Integer.parseInt(results.getString(1));
			count += 1001;

			String id = String.valueOf(count);
			String newId = AdminID.concat(id);

			return newId;
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage());
		}

		return null;

	}

}

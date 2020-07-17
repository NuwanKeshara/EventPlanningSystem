package com.oeps.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Query{
	
	/*
	 * read from the xml file and return the sql query
	 * for the corresponding query id  
	 */

	public static String query(String id) throws SAXException, IOException, ParserConfigurationException {

		Element element = null;
		NodeList node;
		
		
		String link1 = System.getProperty("catalina.home");
		String link2 = "\\webapps\\Online_Event_Planning_System\\WEB-INF\\Query.xml";
		
		
		/*
		 * Read the Query.xml file and read each query node into node
		 * list. It refers tag name query
		 */
			

		File xml = new File(link1 + link2);
		
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(xml);
		
		node = document.getElementsByTagName("query");

		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < node.getLength(); value++) {
			
			element = (Element) node.item(value);
			if (element.getAttribute("id").equals(id))
				break;
		}
		return element.getTextContent().trim();
	}

}
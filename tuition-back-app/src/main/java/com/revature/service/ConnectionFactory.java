package com.revature.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	private static Connection connect = null;
	
	//returns the connection to our database
	public static Connection getConnected() throws ClassNotFoundException {
		//if no connection yet: 
		//register the driver
		Class.forName("org.postgresql.Driver");
		if(connect == null) {
			//set up credentials (username, password)
			//pull these from db config file
			ResourceBundle bundle = ResourceBundle.getBundle("dbConfig.properties");
			String url = bundle.getString("url");
			String username = bundle.getString("rob");
			String password = bundle.getString("sap");
		//try connecting to the database
		try {
			//get connection:
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return connect;
	}
}

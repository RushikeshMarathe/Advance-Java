package com.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	
	private static Connection connection;
	private static String url = "jdbc:mysql://localhost:3306/assignment";
	private static String username = "root";
	private static String password = "rushikesh2623";

	
	public static Connection dbConnect() throws SQLException {
		connection = DriverManager.getConnection(url,username,password);
		
		return connection;
	}
	
	public static void closeDbconnect() throws SQLException{
		if(connection != null)
		{
			connection.close();
		}
	}
}

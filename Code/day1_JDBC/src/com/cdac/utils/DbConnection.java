package com.cdac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static Connection connection;
	private static String url="jdbc:mysql://localhost:3306/iacsd0925";
	private static String username="root";
	private static String password="rushikesh2623";
	
	
	public static Connection dbConnection() throws SQLException {
		
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}

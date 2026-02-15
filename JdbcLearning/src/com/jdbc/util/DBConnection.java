package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbcpracticeex";
	private static final String USER = "root";
	private static final String PASSWORD = "password";
	
	public static Connection getConnection() {
		try {
			// Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

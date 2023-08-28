package com.amdocs.PropertyManagement;
import java.sql.*;

public class ConnectionData {

	public static Connection getConnection(Connection conn) {
		String dbURL = "jdbc:mysql://localhost:3306/project";
		String username = "root" ; 
		String password = "root" ; 
		
		try {
			System.out.println("Database connected Successfully"); 
			return DriverManager.getConnection(dbURL,username,password) ; 
		}
		catch(Exception e){  
			System.err.println(e) ; 
		}
		return null ; 
	}
	
}

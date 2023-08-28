package DAO;

import java.sql.*;

public class DisplayProperty {
	
	Statement statement ; 
	
	public void displayProp(Connection conn , String pName) {
		try {
			statement = conn.createStatement() ; 
			String Query = "SELECT * FROM property where pName='"+pName+"';" ; 
			ResultSet rs = statement.executeQuery(Query) ; 
			
			while(rs.next()) {
				System.out.println("pid:"+ rs.getInt("Pid"));
				System.out.println("Name:"+ rs.getString("pname"));
				System.out.println("Area:"+ rs.getString("area"));
				System.out.println("Price:"+ rs.getFloat("price"));
				System.out.println("Owner:"+ rs.getString("oName"));
				System.out.println("Buyer:"+ rs.getString("bName"));
				
			}
			System.out.println("\n***************************************\n");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}

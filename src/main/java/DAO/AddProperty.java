package DAO;

import java.sql.PreparedStatement;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import com.amdocs.PropertyManagement.ConnectionData;

import Files.POJO;

public class AddProperty {
	
	POJO daoObj ; 
	Scanner sc ;
	PreparedStatement statement ; 
	
	public AddProperty() {
		daoObj = new POJO();
	}
	public void addData(Connection conn,Scanner sc , BufferedReader br) throws IOException {
		try {
			System.out.println("Enter Property Name ");
			String pname = br.readLine() ; 
			daoObj.setPname(pname);
			System.out.println("Enter Property Area");
			String area = br.readLine() ;
			daoObj.setArea(area);
			System.out.println("Enter Property Price");
			Float price = sc.nextFloat() ;
			daoObj.setPrice(price);
			System.out.println("Enter Property Owner");
			String oName = br.readLine() ;
			daoObj.setoName(oName);
			System.out.println("Enter Property Buyer");
			String bName = br.readLine() ;
			daoObj.setbName(bName);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String sql = "INSERT INTO property (pid, pname , area , price , oName , bName) VALUES (?,?,?,?,?,?)" ; 
			statement = conn.prepareStatement(sql) ; 
			statement.setInt(1, daoObj.getPid());
			statement.setString(2, daoObj.getPname());
			statement.setString(3, daoObj.getArea());
			statement.setFloat(4, daoObj.getPrice());
			statement.setString(5, daoObj.getoName());
			statement.setString(6, daoObj.getbName());
			statement.executeUpdate() ; 
			System.out.println(daoObj.getPname());
			
			String pName = daoObj.getPname().toString() ; 
			DisplayProperty dispObj = new DisplayProperty() ; 
			dispObj.displayProp(conn, pName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

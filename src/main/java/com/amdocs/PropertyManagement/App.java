package com.amdocs.PropertyManagement;

import java.sql.*;
import java.util.*;

import DAO.AddProperty;

import java.io.*;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Connection conn = null ; 
        Scanner sc = new Scanner(System.in) ; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ; 
        int opt ; 
        try {
        	while(true) {
    			Connection connRes = ConnectionData.getConnection(conn) ; 
    			System.out.println("1.Add Property");
    			System.out.println("2.Update Property");
    			System.out.println("3.View all Property");
    			System.out.println("4.Delete Property");
    			System.out.println("5.Search Property");
    			System.out.println("6. Exit");
    			System.out.println("Enter Your Option ");
    			
    			opt = sc.nextInt() ; 
    			sc.nextLine() ; 
    			
    			if(opt==6) {
    				System.out.println("Thank You");
    				break ; 
    			}
    			switch (opt) {
				case 1:
					AddProperty addObj = new AddProperty() ; 
					addObj.addData(connRes, sc, br);
					break;

				default:
					break;
				}
    			
    			
        	}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
    }
}

package com.amdocs.PropertyManagement;

import java.sql.*;
import java.util.*;

import com.mysql.cj.jdbc.BlobFromLocator;

import DAO.AddProperty;
import DAO.DeleteProperty;
import DAO.DisplayProperty;
import DAO.Search;
import DAO.UpdateProperty;

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
					break ;
				case 2:
					UpdateProperty updObj = new UpdateProperty() ;
					updObj.updateProperty(connRes, sc, br);
					break;
				case 3:
					DisplayProperty dispObj = new DisplayProperty() ; 
					dispObj.displayProp(conn, null);
					break;
				case 4:
					DeleteProperty delObj = new DeleteProperty() ; 
					delObj.deleteProperty(connRes, sc);
					break;
				case 5:
					System.out.println("Please Enter the area to Search ");
					String area = br.readLine() ; 
					Search sObj = new Search(); 
					sObj.searchPro(connRes, area);
					break;
				default:
					break;
				}
    			
    			
        	}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Choose Valid Options ");
		}
        sc.close();
    }
}

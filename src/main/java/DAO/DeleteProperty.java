package DAO;
import java.sql.Statement;
import java.util.* ; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DeleteProperty {
	Statement statement;

	public void deleteProperty(Connection conn, Scanner sc) {
		try {
			System.out.println("Enter the Property Id to delete");
			int deleteId =  sc.nextInt() ; 
			String QUERY = "Delete from property where pid=?";
			PreparedStatement preparedStatement = conn.prepareStatement(QUERY) ; 
			preparedStatement.setInt(1, deleteId);
			int rowsAffected = preparedStatement.executeUpdate() ;

			if (rowsAffected>0) {
				System.out.println(rowsAffected + "Rows deleted Successfully");
			}
			else {
				System.out.println("Specified Id is not found ");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}

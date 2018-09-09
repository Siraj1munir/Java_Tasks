import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUser {
	
	//Delete person
	public void DeletePerson(String personName){
	//Connection Strings	
		String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "";
		String personname ="";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
	    personname = personName; 
			String sql = "DELETE FROM `users` WHERE personname ='"+personname+"'";	
		    PreparedStatement statement = conn.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
		//Handling Database Exceptions	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}
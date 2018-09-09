import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class InsertPerson {
		//simple method for Add Person	
	public void addPerson(String personName,String phonenoInput ){
		//Initializing Strings for Database connection 		
		String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
				String personname=personName;
				String phoneno =phonenoInput;			 
		//Query
				String sql = "INSERT INTO `users`(`personname`, `phoneno`) VALUES ('"+personname+"',"+phoneno+")";		    
			    PreparedStatement statement = conn.prepareStatement(sql);
			   int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new person was inserted successfully!");
			}

		//Handling Database Exception	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
		
	}
	
}
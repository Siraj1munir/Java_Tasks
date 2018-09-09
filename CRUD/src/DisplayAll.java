

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class DisplayAll {
	//simple method Displaying All Person
	public void Display(){
	//Initializing Strings for Database connection 
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
	//Query		
			String sql = "SELECT * FROM Users";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			int count = 0;
			
			while (result.next()){
				String personname = result.getString("personname");
				String phoneno = result.getString("phoneno");
				
				String output = "User  %s - %s";
				System.out.println(String.format(output, ++count,personname, phoneno));
			}
		//Handling Database Exception		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	
	
}
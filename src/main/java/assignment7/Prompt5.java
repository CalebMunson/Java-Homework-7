package assignment7;

//Prompt 5: Write a program for transaction management

//This file contains a simple SQL insert statement which is run with transaction management.
//It also contains a SQL delete statement to instead remove the entry.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Prompt5 {

	public static void main(String[] args) {
		
		//Query for adding student
		String Q1 = "INSERT INTO student (id, name, age) VALUES (55, 'Jean', 16);";
		
		//Query for removing student
		String R1 = "DELETE FROM student WHERE id = 55 AND name =  'jean' AND age = 16;";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment7", "root", "");
			Statement stmt = con.createStatement();
			
			con.setAutoCommit(false);
			
			stmt.executeUpdate(Q1);

			con.commit();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

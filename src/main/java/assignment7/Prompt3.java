package assignment7;

//Prompt 3: Write a program for calling a procedure

//This file calls a procedure which returns the top 5 oldest students.
//It also provides optional methods for creating the procedure and adding students to test the procedure.

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prompt3 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment7", "root", "");
			CallableStatement call = null;
			
			//Optional Statement for creating procedure (Will cause error if procedure exists already
			createProcedure(con);
			
			//Optional Statement for adding students to test the statement
			addStudents(con);
			
			call = con.prepareCall("{call oldest_students()}");
			call.execute();
			System.out.println("Call Executed...");
			
			con.close();
			call.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void createProcedure(Connection con) {
		try {
			Statement stmt = con.createStatement();
			String procedure = "CREATE PROCEDURE oldest_students() " +
					   		   "BEGIN " +
					   		   " SELECT * FROM student ORDER BY age DESC LIMIT 5; " +
					   		   "END";
			stmt.execute(procedure);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void addStudents(Connection con) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into student (id, name, age) values (35, 'Jane', 14)");
			stmt.executeUpdate("insert into student (id, name, age) values (36, 'Earl', 15)");
			stmt.executeUpdate("insert into student (id, name, age) values (37, 'Jeff', 14)");
			stmt.executeUpdate("insert into student (id, name, age) values (38, 'Jenna', 19)");
			stmt.executeUpdate("insert into student (id, name, age) values (39, 'Jill', 13)");
			stmt.executeUpdate("insert into student (id, name, age) values (40, 'Bob', 18)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package assignment7;

//Prompt 6: Write a program for batch processing using statement and PreparedStatement

//This file contains 2 different batch executes, one with statement and other with PreparedStatement
//It also contains optional statements for removing the entries from the database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Prompt6 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		//Queries for adding students
		String Q1 = "insert into student (id, name, age) values (12, 'Isaac', 8)";
		String Q2 = "insert into student (id, name, age) values (13, 'James', 7)";
		String Q3 = "insert into student (id, name, age) values (14, 'Sarah', 9)";
		String Q4 = "insert into student (id, name, age) values (15, 'Joe', 8)";
		String Q5 = "insert into student (id, name, age) values (?, ?, ?)";
		
		//Queries for removing students
		String R1 = "DELETE FROM student WHERE id = 12";
		String R2 = "DELETE FROM student WHERE id = 13";
		String R3 = "DELETE FROM student WHERE id = 14";
		String R4 = "DELETE FROM student WHERE id = 15";
		String R5 = "DELETE FROM student WHERE id = ?";
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment7", "root", "");
			stmt = con.createStatement();
			stmt.addBatch(Q1);
			stmt.addBatch(Q2);
			stmt.addBatch(Q3);
			stmt.addBatch(Q4);
			stmt.executeBatch();
			
			pstmt = con.prepareCall(Q5);
			//pstmt = con.prepareCall(R5);
			
			pstmt.setInt(1, 16);
			pstmt.setString(2, "Jerry");
			pstmt.setInt(3, 4);
			pstmt.addBatch();
			
			pstmt.setInt(1, 17);
			pstmt.setString(2, "Jake");
			pstmt.setInt(3, 6);
			pstmt.addBatch();
			
			pstmt.setInt(1, 18);
			pstmt.setString(2, "Jackson");
			pstmt.setInt(3, 5);
			pstmt.addBatch();
			
			pstmt.setInt(1, 19);
			pstmt.setString(2, "Jenny");
			pstmt.setInt(3, 4);
			pstmt.addBatch();
			
//			pstmt.setInt(1, 12);
//			pstmt.addBatch();
//			pstmt.setInt(1, 13);
//			pstmt.addBatch();
//			pstmt.setInt(1, 14);
//			pstmt.addBatch();
//			pstmt.setInt(1, 15);
//			pstmt.addBatch();
//			pstmt.setInt(1, 16);
//			pstmt.addBatch();
//			pstmt.setInt(1, 17);
//			pstmt.addBatch();
//			pstmt.setInt(1, 18);
//			pstmt.addBatch();
//			pstmt.setInt(1, 19);
//			pstmt.addBatch();
			
			System.out.println("Executed...");
			pstmt.executeBatch();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}


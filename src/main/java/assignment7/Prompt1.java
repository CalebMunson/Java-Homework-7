package assignment7;

//Prompt 1: Write a program for Statement for doing insert, select, update

//This file contains a demonstration of 3 different Statements which are all executed

import java.sql.*;

public class Prompt1 {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment7", "root", "");
			stmt = con.createStatement();
			
			stmt.executeUpdate("insert into student (id, name, age) values (39, 'Jane', 47)");
			
			rs = stmt.executeQuery("select * from student");
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			
			stmt.executeUpdate("update student set id = 82 where id = 39");
			
			stmt.executeUpdate("delete from student where id = 82");
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

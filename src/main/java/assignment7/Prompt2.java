package assignment7;

//Prompt 2: Write a program for PreparedStatement for doing insert, select, update with positional parameters

//This file contains a demonstration of 4 PreparedStatements which are executed after values are given to their parameters

import java.sql.*;

public class Prompt2 {

	public static void main(String[] args) {
		Connection con;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment7", "root", "");
			PreparedStatement stmt1 = con.prepareStatement("insert into student (id, name, age) values (?, ?, ?)");
			PreparedStatement stmt2 = con.prepareStatement("select * from student"); 
			PreparedStatement stmt3 = con.prepareStatement("update student set id = ? where id = ?");
			PreparedStatement stmt4 = con.prepareStatement("delete from student where id = ?");
			
			stmt1.setInt(1, 39);
			stmt1.setString(2, "Jane");
			stmt1.setInt(3, 47);
			stmt1.executeUpdate();
			
			
			rs = stmt2.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			
			stmt3.setInt(1, 42);
			stmt3.setInt(2, 39);
			stmt3.executeUpdate();
			
			stmt4.setInt(1, 42);
			stmt4.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
package assignment7;

//Prompt 4: Write a program for ResultSet metadata and Database metadata

//This prompt contains print statements which print data of both the database and the given statement for ResultSet

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Prompt4 {

	public static void main(String[] args) {
		String Q1 = "select * from student";
		Connection con = null;
		
		try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment7", "root", "");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(Q1);
				DatabaseMetaData DBMD = con.getMetaData();
				
				System.out.println("Begin result set metadata");
				while (rs.next()) {
					ResultSetMetaData meta = rs.getMetaData();
					System.out.println("Total cols: " + meta.getColumnCount());
					System.out.println("" + meta.getColumnName(1) + " " + meta.getColumnTypeName(1));
					System.out.println("" + meta.getColumnName(2) + " " + meta.getColumnTypeName(2));
					System.out.println("" + meta.getColumnName(3) + " " + meta.getColumnTypeName(3));
				}
				System.out.println("End result set metadata\n");
				
				System.out.println("Begin database metadata");
				System.out.println(DBMD.getDatabaseProductName());
				System.out.println(DBMD.getDatabaseMajorVersion());
				System.out.println(DBMD.getDriverName());				
				System.out.println(DBMD.getSchemas());
				System.out.println("End database metadata");
				
			} catch (SQLException e) {
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

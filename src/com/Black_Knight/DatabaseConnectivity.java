package com.Black_Knight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseConnectivity {
	Connection con;
	PreparedStatement s1;
	 Statement s;
	public DatabaseConnectivity() {
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmangmentsystem", "root", "");
			s = con.createStatement();

			
//			PreparedStatement s1;
		} catch (Exception e) {
			System.out.println(e);
	
		}
  }

}

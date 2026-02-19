package com.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBDemo {
	public static Connection getDbcon() {
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/mlafeb";
			
			String user = "root";
			
			String pas = "root@39";
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			con = DriverManager.getConnection(url,user,pas);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
		//not needed as of this version
		
//		Connection con = DriverManager.getConnection(url,user,pas);
//		
//		Statement stmt = con.createStatement();
//		
//		String sql = "create table user101(fullname varchar(50), username varchar(50),password varchar(50))";
//		stmt.execute(sql);
//		con.close();
//		System.out.println("Done..");
	}
}

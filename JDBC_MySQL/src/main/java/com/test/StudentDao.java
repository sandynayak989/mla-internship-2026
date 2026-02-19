package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

public class StudentDao {
	public static Connection getCon() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mlafeb";
		String user = "root";
		String pass = "root@39";
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void saveStudent(Student std) {
		try {
			String sql = "insert into student(id,age,name,city) values(?,?,?,?) ";
			Connection con = StudentDao.getCon();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,std.getId());
			pst.setInt(2, std.getAge());
			pst.setString(3, std.getName());
			pst.setString(4, std.getCity());
			pst.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> getAllStudent(){
		List<Student> stdList = new ArrayList<>();
		try {
			String sql = "select * from student";
			Connection con = StudentDao.getCon();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Student std = new Student();
				std.setId(rs.getInt(1));
				std.setAge(rs.getInt(2));
				std.setName(rs.getString(3));
				std.setCity(rs.getString(4));
				
				stdList.add(std);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stdList;
	}
	
	public void updateStudent(Student std) {
		try {
			String sql = "update student set age= ?, name= ?, city= ? where id = ?";
			Connection con = StudentDao.getCon();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, std.getAge());
			pst.setString(2, std.getName());
			pst.setString(3, std.getCity());
			pst.setInt(4, std.getId());
			
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(int id) {
		try {
			String sql = "Delete from student where id= ? ";
			Connection con = StudentDao.getCon();
			PreparedStatement pst = EmpDao.getCon().prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

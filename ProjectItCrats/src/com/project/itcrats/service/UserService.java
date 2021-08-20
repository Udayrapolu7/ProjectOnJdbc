package com.project.itcrats.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.itcrats.dao.UserDao;

public class UserService {
	
   public void insertUserValues() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String uname = "root";
		String password = "Uday@123";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, password);
//		Statement st = con.createStatement();
//		st.executeUpdate("create table user(userId int(8),userName varchar(200),userEmail varchar(200),"
//				+ "userPassword varchar(200),userPhone varchar(200),userPhoto varchar(200), userAddress varchar(200),"
//				+ "userType varchar(200) )");
//		System.out.println("table was created");
		String query = "insert into user values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("enter user id :");
			int userId = sc.nextInt();
			System.out.println("enter user name :");
			String userName = sc.next();
			System.out.println("enter userEmail :");
			String userEmail = sc.next();
			System.out.println("enter userPassword ;");
			String userPassword = sc.next();
			System.out.println("enter userPhone :");
			String userPhone = sc.next();
			System.out.println("enter userPhoto :");
			String userPhoto = sc.next();
			System.out.println("enter userAddress :");
			String userAddress = sc.next(); 
			System.out.println("enter userType :");
			String userType = sc.next();
           pst.setInt(1, userId);
           pst.setString(2,userName);
           pst.setString(3, userEmail);
           pst.setString(4, userPassword);
           pst.setString(5, userPhone);
           pst.setString(6, userPhoto);
           pst.setString(7, userAddress);
           pst.setString(8, userType);
			 pst.addBatch();
	          System.out.println("are you want to insert one more record? [yes/no]");
	          String operation = sc.next();
	             if(operation.equalsIgnoreCase("No")) {
	           	 break;
	            }	

		}
		pst.executeBatch();
		System.out.println("success");
		con.close();
	}
	public void updateUserValues() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String uname = "root";
		String password = "Uday@123";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, password);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter userid");
		int userId = sc.nextInt();
		System.out.println("enter  new userPassword");
		String userPassword = sc.next();
		String query = "update user set userPassword = ? where userId = ? ";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, userPassword);
		pst.setInt(2, userId);
		 pst.executeUpdate();
		 System.out.println("update succesfully");
	 
	   con.close();
		
	}
	public void deleteUserValues() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String uname = "root";
		String password = "Uday@123";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, password);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter user id");
		int userId = sc.nextInt();
		String query = " delete from user where  userId = ? ";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,userId);
		 pst.executeUpdate();
		 System.out.println("deleted succesfully");
	 
	   con.close();
		
	}
}
package com.project.itcrats.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CategoryService {
	
	public void insertCategoryValues() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String uname = "root";
		String password = "Uday@123";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, password);
//		Statement st = con.createStatement();
//		st.executeUpdate("create table category(categoryId int(8),categoryTitle varchar(200),categoryDiscription varchar(200))");
//		System.out.println("table was created");
		String query = "insert into category values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("enter category id");
			int categoryId = sc.nextInt();
			System.out.println("enter category title");
			String categoryTitle = sc.next();
			System.out.println("enter category Discripition");
			String categoryDiscription = sc.next();
			pst.setInt(1, categoryId);
			pst.setString(2, categoryTitle);
			pst.setString(3, categoryDiscription);
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
	public void UpdateCategoryValues() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String uname = "root";
		String password = "Uday@123";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, password);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter category id");
		int categoryId = sc.nextInt();
		System.out.println("enter  new categoryDiscription");
		String categoryDiscription = sc.next();
		String query = "update category set categoryDiscription = ? where categoryId = ?; ";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, categoryDiscription);
		pst.setInt(2, categoryId);
		 pst.executeUpdate();
		 System.out.println("update succesfully");
	 
	   con.close();
		
	}
	public void DeleteCategoryValues() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String uname = "root";
		String password = "Uday@123";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, password);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter category id");
		int categoryId = sc.nextInt();
		String query = " delete from category where  categoryId = ? ";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,categoryId);
		 pst.executeUpdate();
		 System.out.println("deleted succesfully");
	 
	   con.close();
		
	}
	

}

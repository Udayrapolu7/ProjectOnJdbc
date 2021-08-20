package com.project.itcrats.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ProductService {
	
	public void  insertProductValues() throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String uname = "root";
		String password = "Uday@123";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, password);
//		Statement st = con.createStatement();
//		st.executeUpdate("create table product(productId int(8),productName varchar(200),productDiscription varchar(200),"
//				+ "productPhoto varchar(200),productPrice int(40),productDiscount int(30),productQuantity int(87) )");
//		System.out.println("table was created");
		String query = "insert into product values(?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("enter Product id :");
			int productId = sc.nextInt();
			System.out.println("enter product name :");
			String productName = sc.next();
			System.out.println("enter product Discripition :");
			String productDiscription = sc.next();
			System.out.println("enter product photo ;");
			String productPhoto = sc.next();
			System.out.println("enter Product price :");
			int productPrice = sc.nextInt();
			System.out.println("enter productDiscount :");
			int productDiscount = sc.nextInt();
			System.out.println("enter productQuantity :");
			int productQuantity = sc.nextInt(); 
            pst.setInt(1, productId);
            pst.setString(2,productName);
            pst.setString(3, productDiscription);
            pst.setString(4, productPhoto);
            pst.setInt(5, productPrice);
            pst.setInt(6, productDiscount);
            pst.setInt(7, productQuantity);
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
		System.out.println("enter productid");
		int productId = sc.nextInt();
		System.out.println("enter  new productPrice");
		String productPrice = sc.next();
		String query = "update product set productPrice = ? where productId = ? ";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, productPrice);
		pst.setInt(2, productId);
		 pst.executeUpdate();
		 System.out.println("update succesfully");
	 
	   con.close();
		
	}
	public void deleteProductValues() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String uname = "root";
		String password = "Uday@123";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, password);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter productid");
		int productId = sc.nextInt();
		String query = " delete from product where  productId = ? ";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,productId);
		 pst.executeUpdate();
		 System.out.println("deleted succesfully");
	 
	   con.close();
		
	}
}

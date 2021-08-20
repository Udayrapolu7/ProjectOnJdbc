package com.project.itcrats;

import java.sql.*;
import java.util.Scanner;

import com.project.itcrats.service.ProductService;

public class Product {

	public static void main(String[] args) throws Exception {
	 
		int choice = 0;
		ProductService productservice = new ProductService();
		  System.out.println(" select an option \n1 -insertproductValues \n2 -UpdateProdctValues \n3-DeleteProductValues");
	         Scanner sc = new Scanner(System.in);
	         System.out.println(" select the choice");
	         choice =sc.nextInt();
	        switch(choice)
	        {
	        case 1:
	        	productservice.insertProductValues();
	        break;
	        case 2:
	        	productservice.updateUserValues();
	        break;
	        case 3:
	        	productservice.deleteProductValues();
	         break;
	       default:
	    	   System.out.println(" select correct option");
	    	   break;
	        }
	}

}

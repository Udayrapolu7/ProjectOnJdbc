package com.project.itcrats;

import java.sql.*;
import java.util.Scanner;

import com.project.itcrats.service.CategoryService;
import com.project.itcrats.service.UserService;
public class User {

	public static void main(String[] args) throws Exception {
		
		int choice = 0;
		UserService userservice = new UserService();
		System.out.println("select an option \n1-insertUserValues \n2-updateUserValues \n3-deleteUserValues");
		 Scanner sc = new Scanner(System.in);
         System.out.println(" select the choice");
         choice =sc.nextInt();
        switch(choice)
        {
        case 1 :
        	userservice.insertUserValues();
        	break;
        case 2:
        	userservice.updateUserValues();
        	break;
        case 3 :
        	userservice.deleteUserValues();
        	break;
        	default:
        		  System.out.println(" select correct option");
           	   break;
        }
	}

}

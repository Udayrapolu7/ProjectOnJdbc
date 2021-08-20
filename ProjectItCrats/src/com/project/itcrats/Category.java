package com.project.itcrats;

import java.sql.*;
import java.util.Scanner;

import com.project.itcrats.service.CategoryService;
public class Category {

	public static void main(String[] args) throws Exception  , SQLException{
		// TODO Auto-generated method stub
		 int choice = 0;
        CategoryService categoryservice = new CategoryService();
        System.out.println(" select an option \n1 -insertCategoryValues \n2 -UpdateCategoryValues \n3-DeleteCategoryValues");
         Scanner sc = new Scanner(System.in);
         System.out.println(" select the choice");
         choice =sc.nextInt();
        switch(choice)
        {
        case 1:
        categoryservice.insertCategoryValues();
        break;
        case 2:
            categoryservice.UpdateCategoryValues();
        break;
        case 3:
            categoryservice.DeleteCategoryValues();
         break;
       default:
    	   System.out.println(" select correct option");
    	   break;
        }
       
	}

}

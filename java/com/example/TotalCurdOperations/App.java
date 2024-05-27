package com.example.TotalCurdOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class App 
{
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
	public static Connection conn;
	public static PreparedStatement pmst;

	
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
        	display();
        	System.out.println("Enter your Option Number: ");
        	ch = Integer.parseInt(sc.next());
        	
        	switch(ch) {
        	case 1:
        		create_database();
        		break;
        	case 2:
        		drop_database();
        		break;
        	case 3:
        		create_table();
        		break;
        	case 4:
        		drop_table();
        		break;
        	case 5:
        		inserted();
        		break;
        	case 6:
        		update_values();
        		break;
        	case 7:
        		select_all();
        		break;
        	case 8:
        		select_by_id();
        		break;
        	case 9:
        		delete_data();
        		break;
        	case 10:
        		
        		System.out.println("Your process is teriminated");
        		System.exit(0);
        		break;
        	default:
        		System.out.println("Invalid Option Number :");
        		break;
        	}   	
        	
        	
        }while(ch>0);
        
    }
    private static void create_database() {
    	String url = "jdbc:mysql://localhost:3306/";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Database Name :");
			String sql ="create database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println(" Database Created Successfully !!!");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    private static void drop_database() {
    	String url = "jdbc:mysql://localhost:3306/";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Database Name :");
			String sql ="drop database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println(" Database Dropped Successfully !!!");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    }
    private static void create_table() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Table Name :");
			String u=sc.next();
			String sql = "create table "+u+"("+u+"Id int,"+u+"Name varchar(20),"+u+"Email varchar(20))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			
			if(i==0) {
				System.out.println(u+" Table is Created Successfully !!!");
				
			}
			else {
				System.out.println("Error");
			}
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    private static void drop_table() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database Name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Table Name:");
			String u=sc.next();
			String sql = "drop table "+u;
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			
			if(i==0) {
				System.out.println(u+" Table is Droped Successfully !!!");
				
			}
			else {
				System.out.println("Error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    private static void inserted() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database Name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Table Name:");
			String u=sc.next();
			String sql = "insert into "+u+"("+u+"Id,"+u+"Name,"+u+"Email) values (?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter "+u+" id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter "+u+" name");
			pmst.setString(2, sc.next());
			System.out.println("Enter "+u+" email");
			pmst.setString(3, sc.next());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println(u+" Table Values are Inserted Successfully !!!");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    private static void update_values() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database Name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Table name:");
			String u=sc.next();
			String sql = "update "+u+" set "+u+"name = ?,"+u+"email = ? where "+u+"id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter "+u+" name:");
			pmst.setString(1, sc.next());
			System.out.println("Enter "+u+" Email:");
			pmst.setString(2, sc.next());
			System.out.println("Enter "+u+" Id:");
			pmst.setInt(3, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println(u+" Table Vlaues are Updated Successfully !!!");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();  
		}
    	
    }
    private static void select_all() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database Name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,Username,Password);
			System.out.println("Enter Table Name");
			String u=sc.next();
			String sql = "select * from "+u;
			pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				
			System.out.println(u+"Id"+ rs.getInt(u+"Id")+ 
					u+"Name"+rs.getString(u+"Name")+
					u+"Email"+rs.getString(u+"Email"));
			}      

		} catch (Exception e) {
			e.printStackTrace();
		}

    	
    }
    private static void select_by_id() {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database Name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,Username,Password);
			System.out.println("Enter Table Name:");
			String u=sc.next();
			
			String sql = "select * from "+u+" where "+u+"Id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter employee id");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
			System.out.println(u+"Id"+ rs.getInt(u+"Id")+ 
					u+"Name"+rs.getString(u+"Name")+
					u+"Email"+rs.getString(u+"Email"));
			}       

		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
   private static void delete_data() {
	   Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database Name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Table Name:");
			String u=sc.next();
			String sql = "delete from "+u+" where "+u+"Id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter "+u+" Id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println(u+" Table data Deleted Successfully");
			}
			else {
				System.out.println("error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }


    private static void display() {
    	System.out.println("***************OPEN CURD OPERATIONS******************");
    	System.out.println("\t1.CREATE DATABASE");
    	System.out.println("\t2.DROP DATABASE");
    	System.out.println("\t3.CREATE TABLE");
    	System.out.println("\t4.DROP TABLE");
    	System.out.println("\t5.ADD VALUES INTO TABLE");
    	System.out.println("\t6.UPDATE VALUES");
    	System.out.println("\t7.SELECT ALL");
    	System.out.println("\t8.SELECT BY ID");
    	System.out.println("\t9.DELETE DATA");
    	System.out.println("\t10.EXIT");
    	System.out.println("***************CLOSE CURD OPERATIONS******************");
    }
}

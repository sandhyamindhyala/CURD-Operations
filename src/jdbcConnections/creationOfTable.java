package jdbcConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class creationOfTable {
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
	public static final String Url = "jdbc:mysql://localhost:3306/demo";
	public static Connection conn;
	public static PreparedStatement pmst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter Table Name:");
			String sql = "create table "+sc.next() + "(id int,name varchar(20),email varchar(20))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			
			if(i==0) {
				System.out.println("Successfully Inserted!!!");
				
			}
			else {
				System.out.println("Error");
			}
			sc.close();
			pmst.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

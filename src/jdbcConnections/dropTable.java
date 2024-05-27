package jdbcConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class dropTable {
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
			String sql = "drop table "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			
			if(i==0) {
				System.out.println("Successfully droped!!!");
				
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

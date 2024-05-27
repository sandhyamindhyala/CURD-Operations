package jdbcConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertionIntoTable {
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
//	public static final String Url = "jdbc:mysql://localhost:3306/demo";
	public static Connection conn;
	public static PreparedStatement pmst;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter table name:");
			String sql = "insert into "+sc.next()+"(id,name,email) values (?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter employee id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter employee name");
			pmst.setString(2, sc.next());
			System.out.println("Enter employee email");
			pmst.setString(3, sc.next());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Successfully Inserted into table");
			}
			else {
				System.out.println("error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



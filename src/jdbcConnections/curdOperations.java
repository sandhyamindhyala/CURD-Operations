package jdbcConnections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class curdOperations {
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
	public static Connection conn;
	public static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			display();
			System.out.println("Enter choice");
			ch = Integer.parseInt(sc.nextLine());
			
			switch (ch) {
			case 1:
				createdatabase();
				break;
			case 2:
				createtable();
				break;
			case 3:
				insertion();
				break;
			case 4:
				deletion();
				break;
			case 5:
				getall();
				break;
			case 6:
				getbyid();
				break;
			case 7:
				droptable();
				break;
			case 8:
				dropdatabase();
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
			
			}
		} while (ch>0);
	}
	private static void dropdatabase() {
		String url = "jdbc:mysql://localhost:3306/";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Database Name");
			String sql ="drop database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("database dropped");
			}
			else {
				System.out.println("Error");
			}
//			pmst.close();
//			sc.close();
//			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	private static void droptable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
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
//			sc.close();
//			pmst.close();
//			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getbyid() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,Username,Password);
			System.out.println("Enter Table name:");
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
//			pmst.close();
//			sc.close();
//			conn.close();       

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getall() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,Username,Password);
			System.out.println("Enter table name");
			String u=sc.next();
			String sql = "select * from "+u;
			pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				
			System.out.println(u+"Id"+ rs.getInt(u+"Id")+ 
					u+"Name"+rs.getString(u+"Name")+
					u+"Email"+rs.getString(u+"Email"));
			}
//			pmst.close();
//			sc.close();
//			conn.close();       

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	private static void deletion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Table name:");
			String u=sc.next();
			String sql = "delete from "+u+" where "+u+"Id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter "+u+" Id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Deleted Successfully");
			}
			else {
				System.out.println("error");
			}
//			sc.close();
//			conn.close();
//			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void insertion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Table name:");
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
				System.out.println("Successfully Inserted into table");
			}
			else {
				System.out.println("error");
			}
//			sc.close();
//			conn.close();
//			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createtable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name:");
		String url = "jdbc:mysql://localhost:3306/"+sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Table Name:");
			String u=sc.next();
			String sql = "create table "+u+"("+u+"Id int,"+u+"Name varchar(20),"+u+"Email varchar(20))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			
			if(i==0) {
				System.out.println("Successfully Inserted!!!");
				
			}
			else {
				System.out.println("Error");
			}
//			sc.close();
//			pmst.close();
//			conn.close();
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createdatabase() {
		String url = "jdbc:mysql://localhost:3306/";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, Username, Password);
			System.out.println("Enter Database Name");
			String sql ="create database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("database created");
			}
			else {
				System.out.println("Error");
			}
//			pmst.close();
//			sc.close();
//			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void display() {
		System.out.println("Operations");
		System.out.println("\t1 .create database");
		System.out.println("\t2 .create table");
		System.out.println("\t3 .insertion of data");
		System.out.println("\t4 .deletion of data");
		System.out.println("\t5 .fetch all records");
		System.out.println("\t6 .get record by id");
		System.out.println("\t7 .deletion of table");
		System.out.println("\t8 .deletion of database");
		System.out.println("\t9 .Terminate process");



	}
}

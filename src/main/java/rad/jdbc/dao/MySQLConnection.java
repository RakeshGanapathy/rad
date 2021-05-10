
package rad.jdbc.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection {
	static String url = "jdbc:mysql://localhost:3306";
	static String user = "user";
	static String password = "admin";

	public static void main(String[] args) {
		/*
		 * Step :1 Load and register the driver Loading of Driver is done by using
		 * forName() registering driver code will get executed in the static block of
		 * Driver class
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded and registered");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		/* Step 2 Establish a Connection
		 * by calling the getConnection() in the DriverManager class
		 */
		
		// Step2 using 3 parameter getConnection()
		Connection connection1 =null;
		try {
			connection1 = DriverManager.getConnection(url, user, password);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println("Connection Established" + connection1);
		try {
			connection1.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		// Step2 using 2 parameter getConnection()

		Properties pros = new Properties();
		Connection connection2 = null;
		try(FileReader fr = new FileReader("G:\\CodingClown\\Rad\\src\\main\\resources\\application-dev.properties")){
			pros.load(fr);
			try {
				connection2 = DriverManager.getConnection(url, pros);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("connection Extablished" + connection2);
			try {
				connection2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// Step2 using 1 parameter getConnection()
		Connection connection3 = null;
		String singleUrl = url + "?user=" + user + "&password=" + password;
		System.out.println(singleUrl);
		try {
			connection3 = DriverManager.getConnection(singleUrl);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Connection Established" + connection3);
		try {
			connection3.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
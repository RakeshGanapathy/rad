package rad.jdbc.statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import rad.jdbc.util.JDBCUtil;

public class RetrieveDataUsingPreparedStatements {

	public static void main(String[] args) {
		PreparedStatement ps = null;
		try(Connection con = JDBCUtil.getMySqlConnection();
				Scanner scan = new Scanner(System.in)){
		System.out.println("Enter Name");
		String name = scan.next();
		System.out.println("Enter Id");
		int id = scan.nextInt();
		System.out.println("Enter mail");
		String mail = scan.next();
		System.out.println("Enter phone");
		long phone = scan.nextLong();
		//place holder mechanism 
		String query = "insert into students values (?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, mail);
		ps.setLong(4, phone);
		int x= ps.executeUpdate();
		getStatus(x);
		System.out.println("Enter id");
		id = scan.nextInt();
		ps.setInt(1, id);
		x= ps.executeUpdate();
		getStatus(x);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(null, ps);
		}
	}

	private static void getStatus(int x) {
		if(x==1) {
			System.out.println("row inserted");
		}
		else {
			System.out.println("row not inserted");
		}
	}

}

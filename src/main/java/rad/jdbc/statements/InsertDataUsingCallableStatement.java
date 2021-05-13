package rad.jdbc.statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import rad.jdbc.util.JDBCUtil;

public class InsertDataUsingCallableStatement {

	public static void main(String[] args) {
		CallableStatement cs =null;
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
		String storeProc ="call insertStudentInfo(?,?,?,?)";
		cs = con.prepareCall(storeProc);
		cs.setInt(1, id);
		cs.setString(2, name);
		cs.setString(3, mail);
		cs.setLong(4,phone);
		cs.execute();
		System.out.println("called successfully");
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.cleanup(null, cs);
	}

}
}

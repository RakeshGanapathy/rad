package rad.jdbc.statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import rad.jdbc.util.JDBCUtil;

public class UpdateCallableStatement {

	public static void main(String[] args) {
		CallableStatement cs =null;
		try(Connection con = JDBCUtil.getMySqlConnection();
				Scanner scan = new Scanner(System.in)){
		System.out.println("Enter Id");
		int id = scan.nextInt();
		System.out.println("Enter Installament");
		float inc = scan.nextFloat();
		String storeProc ="call updateInfo(?,?,?)";
		cs = con.prepareCall(storeProc);
		cs.setInt(1, id);
		cs.setFloat(3, inc);
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.registerOutParameter(3, Types.FLOAT);
		cs.execute();
		String name=cs.getString(2);
		float fee=cs.getFloat(3);
		System.out.println(name+"\t"+fee);
		System.out.println("called successfully");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(null, cs);
		}
	}

}

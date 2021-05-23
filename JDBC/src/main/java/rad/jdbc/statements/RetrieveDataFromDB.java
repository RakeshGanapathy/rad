package rad.jdbc.statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import rad.jdbc.util.JDBCUtil;

public class RetrieveDataFromDB {

	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs= null;
		
		
		try (Scanner scan = new Scanner(System.in);
				Connection con = JDBCUtil.getMySqlConnection();){
			System.out.println("Enter the id");
			int id =scan.nextInt();
			System.out.println("Enter the name");
			String name = scan.next();
			String query = String.format("select * from students where studname=\"%s\"",name);
			String query2 = String.format("insert into students values(%d,'qsp','abc@gmail',93894738789)",id);
			String query3 = "select * from students";
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			con.close();
			JDBCUtil.getRecordsFromResultSet(rs);
			// Multiple queries can be executed using statement 
			boolean status = stmt.execute(query2);// false
			System.out.println("the status is "+status);
			int updatedRecordCount = stmt.getUpdateCount();
			System.out.println("the no of records updated is "+updatedRecordCount);
			boolean status2 = stmt.execute(query3);
			System.out.println("the status is "+status2);
			ResultSet rs2 = stmt.getResultSet();
			JDBCUtil.getRecordsFromResultSet(rs2);// true 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(rs, stmt);
		}
	}

}

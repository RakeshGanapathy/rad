package rad.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetrieveDataFromDB {

	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs= null;
		
		
		try (Scanner scan = new Scanner(System.in);
				Connection con = JDBCUtil.getMySqlConnection();){
			//System.out.println("Enter the id");
			//int id =scan.nextInt();
			System.out.println("Enter the name");
			String queryInput = scan.nextLine();
			String name = scan.nextLine();
			String query = String.format("select * from students where studname=\"%s\"",name);
			//String query = "select * from students";
			System.out.println(queryInput);
			stmt = con.createStatement();
			rs=stmt.executeQuery(queryInput);
			
			if(rs.next()) {
				do {
					int studid = rs.getInt(1);
					String studname = rs.getString(2);
					String mail =rs.getString(3);
					long phone=rs.getLong(4);
					System.out.println(studid+"\t"+studname+"\t"+mail+"\t"+phone);
				}while(rs.next());
			}
			else {
				System.out.println("sorry , student record not found");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(rs, stmt);
		}
	}

}

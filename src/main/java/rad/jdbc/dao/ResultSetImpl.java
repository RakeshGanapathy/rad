package rad.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import rad.jdbc.util.JDBCUtil;

public class ResultSetImpl {

	public static void main(String[] args) {
		
		try (Connection con = JDBCUtil.getMySqlConnection();
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				) {
			ResultSet rs = stmt.executeQuery("select * from students");
			System.out.println("forward Direction");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			System.out.println("backward Direction");
			while(rs.previous()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			System.out.println("*** 1st Record***");
			rs.first();
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			System.out.println("*** last Record***");
			rs.last();
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			System.out.println("*** 4th Record***");
			rs.absolute(4);
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			System.out.println("*** relative 2nd record from 4th Record***");
			rs.relative(2);
			//updating the result set
			rs.updateString(2, "random");
			rs.updateRow();
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			System.out.println("*** 4th Record***");
			rs.absolute(4);
			rs.deleteRow();
			rs.updateRow();
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			JDBCUtil.cleanup(rs, stmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

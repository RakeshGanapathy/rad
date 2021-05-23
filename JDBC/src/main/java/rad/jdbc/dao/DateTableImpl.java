package rad.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import rad.jdbc.util.JDBCUtil;

public class DateTableImpl {

	public static void main(String[] args) {
		String sql = "insert into datetable values(?,?)";
		String sql2 = "select * from datetable";
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter id ");
		int id = scan.nextInt();
		System.out.println("Enter Date");
		int d = scan.nextInt();
		System.out.println("Enter Month");
		int m = scan.nextInt();
		System.out.println("Enter year");
		int y = scan.nextInt();
		Date dt = new Date(y - 1900, m - 1, d);
		System.out.println(dt);
		try (Connection con = JDBCUtil.getMySqlConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				PreparedStatement ps2 = con.prepareStatement(sql2);) {
			ps.setInt(1, id);
			ps.setDate(2, dt);
			int x = ps.executeUpdate();
			if (x > 0)
				System.out.println("row inserted");

			rs = ps2.executeQuery();
			while (rs.next()) {
				int xid = rs.getInt(1);
				Date date = rs.getDate(2);
				System.out.println(xid +"\t"+date);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, null);
			scan.close();
		}

	}

}

package rad.jdbc.statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import rad.jdbc.util.JDBCUtil;

public class PreparedStatmentBatch {

	public static void main(String[] args) {
		String sql = "insert into students values(?,?,?,?)";
		try (Connection con = JDBCUtil.getMySqlConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				Scanner scan = new Scanner(System.in)) {
			char choice = 'y';
			do {
				System.out.println("Enter Name");
				String name = scan.next();
				System.out.println("Enter Id");
				int id = scan.nextInt();
				System.out.println("Enter mail");
				String mail = scan.next();
				System.out.println("Enter phone");
				long phone = scan.nextLong();
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, mail);
				ps.setLong(4, phone);
				ps.addBatch();
				System.out.println("do you want to add more..");
				scan.nextLine();
				choice = scan.nextLine().charAt(0);
			} while (choice == 'y');
			ps.executeBatch();
			int res[] = ps.executeBatch();
			for(int index =0;index<res.length;index++) {
				System.out.println("res : "+res[index]);
			}
			for (int index : res) {
				System.out.println("result : " + index);
			}
			JDBCUtil.cleanup(null, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

package rad.jdbc.statements;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import rad.jdbc.util.JDBCUtil;

public class StatementBatch {
	
	public static void main(String[] args) {
		// queries 
		
		String sql = "insert into students values(53,'jsp','abc@gmail',93894738789)";
		String sql2 = "insert into students values(54,'qsp','abc@gmail',93894738789)";
		String sql3 = "update students set studname='darun' where studid = 47";
		String sql4 = "update students set studname='jsp' where studname = 'pysp'";
		String sql5 = "delete from students where studid = 44";
		String sql6 = "delete from students where studid = 45";
		try(Connection con = JDBCUtil.getMySqlConnection();
				Statement stmt = con.createStatement()){
		stmt.addBatch(sql);
		stmt.addBatch(sql2);
		stmt.addBatch(sql3);
		stmt.addBatch(sql4);
		stmt.addBatch(sql5);
		stmt.addBatch(sql6);
		int x[] = stmt.executeBatch();
		for(int element :x) {
			System.out.println(element);
		}
		JDBCUtil.cleanup(null, stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

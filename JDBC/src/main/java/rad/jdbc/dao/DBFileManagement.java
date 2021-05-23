package rad.jdbc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;

import rad.jdbc.util.JDBCUtil;

public class DBFileManagement {

	public static void main(String[] args) {
		
		String sql = "Insert into datatable(?,?,?)";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = scan.nextInt();
		String fileName = "G:\\test.txt";
		String absFileName=fileName;
		File file = new File(absFileName);
		try {
			file.createNewFile();
			FileWriter fw =new FileWriter(file);
			fw.write("hey hifun");
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		StringTokenizer tok = new StringTokenizer(fileName,"\\");
		while(tok.hasMoreElements()) {
			fileName = tok.nextToken();
		}
		try (Connection con = JDBCUtil.getMySqlConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				FileInputStream fis = new FileInputStream(file)) {
		ps.setInt(1, id);
		ps.setString(2, fileName);
		ps.setBinaryStream(3, fis);
		ps.execute();
		
	}
	catch(SQLException e) {
		System.out.println(e.getMessage());
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
		finally {
			scan.close();
		}
	}
}

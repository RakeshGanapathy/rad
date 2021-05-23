package rad.jdbc.util;

import static rad.classloading.properties.GlobalConstants.ENV;
import static rad.classloading.properties.GlobalConstants.RESOURCE_PREFIX;
import static rad.classloading.properties.GlobalConstants.RESOURCE_SUFFIX;
import static rad.classloading.properties.GlobalConstants.URL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static {
		// step 1: load and register driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/* Provides all data in the database table */

	public static void getRecordsFromResultSet(ResultSet rs) throws SQLException {
		if (rs.next()) {
			do {
				int studid = rs.getInt(1);
				String studname = rs.getString(2);
				String mail = rs.getString(3);
				long phone = rs.getLong(4);
				System.out.println(studid + "\t" + studname + "\t" + mail + "\t" + phone);
			} while (rs.next());
		} else {
			System.out.println("sorry , student record not found");
		}
	}

	public static Connection getMySqlConnection() throws SQLException {
		String env = System.getenv(ENV);
		Properties properties = new Properties();
		// Connection connection = null;
		try (InputStream is = ClassLoader
				.getSystemResourceAsStream(String.format("%s%s%s", RESOURCE_PREFIX, env, RESOURCE_SUFFIX))) {
			properties.load(is);
			// Step 2 Create a Connection
			Connection connection = DriverManager.getConnection(properties.getProperty(URL), properties);
			System.out.println("connection created");
			return connection;

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return null;
	}

	public static void cleanup(ResultSet rs, Statement st) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

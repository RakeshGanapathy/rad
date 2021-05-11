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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DaoUtil {

	public static void main(String[] args) {
		// sql query
		String sql = "insert into students values(44,'qsp','abc@gmail',93894738789)";
		// Step 1: load and register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded and registered");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		String env = System.getenv(ENV);
		Properties properties = new Properties();

		try (InputStream is = ClassLoader
				.getSystemResourceAsStream(String.format("%s%s%s", RESOURCE_PREFIX, env, RESOURCE_SUFFIX))) {
			properties.load(is);
			// Step 2 Create a Connection, Step 3: Create a Statement
			try (Connection connection = DriverManager.getConnection(properties.getProperty(URL), properties);
					Statement statement = connection.createStatement()) {
				// Step 4 : execute sql Query
				int x = statement.executeUpdate(sql);
				// Step5: process the result
				if (x == 1)
					System.out.println("inserted 1 record");
				else
					System.out.println("Record not inserted");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Step 6 Close the connection is not needed due to usage of try with resource

	}

}

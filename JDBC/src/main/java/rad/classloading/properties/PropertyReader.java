package rad.classloading.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static void main(String[] args) {
		Properties props = new Properties();
		try (FileReader fr = new FileReader("Resources/application-dev.properties")) {
			props.load(fr);
			// 1st method
			String user = props.getProperty("app.user");
			String pass = props.getProperty("app.pass");
			System.out.println("user name is " + user);
			System.out.println("the password is " + pass);
			// 2nd method
			String user2 = props.getProperty("app.user", "user name not found");
			String pass2 = props.getProperty("app.pass", "password not found");
			System.out.println("user name is " + user2);
			System.out.println("the password is " + pass2);
			// checking with wrong keyname
			String user3 = props.getProperty("user", "user name not found");
			System.out.println("user name is " + user3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package rad.classloading.properties;

public class LoadTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.classloading.LoadMe");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			System.out.println(ce.getMessage());
		}
	}

}

class LoadMe {
	static {
		System.out.println("loaded static block from different class");
	}
}

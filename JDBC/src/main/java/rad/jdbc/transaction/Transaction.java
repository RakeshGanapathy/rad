package rad.jdbc.transaction;

public class Transaction {

	public static void main(String[] args) {
		Account acc =new Account();
		acc.transfer(77, 87, 5000);
	}

}

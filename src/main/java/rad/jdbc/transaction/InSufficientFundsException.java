package rad.jdbc.transaction;

public class InSufficientFundsException extends Exception {

	private static final long serialVersionUID = 1L;

	InSufficientFundsException(String message){
		super(message);
	}
	
}

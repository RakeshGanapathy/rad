package rad.jdbc.transaction;

public class InValidAccountNumberException extends Exception {

	private static final long serialVersionUID = 1L;
	
	int accNo;

	public InValidAccountNumberException (int accNo) {
		this.accNo=accNo;
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "AccNo:"+ accNo +" is not Found ";
	}
	
	
	
}

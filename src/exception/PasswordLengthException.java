package exception;

public class PasswordLengthException extends LoginException{
	public PasswordLengthException(){
		message = "Password must at least be 3 characters long.";
		title = "Unsecure Data Supplied";
	}
}
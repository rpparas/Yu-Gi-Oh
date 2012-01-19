package exception;

public class EmptyFieldException extends LoginException{
	public EmptyFieldException(){
		message = "Please supply all fields with required data.";
		title = "Missing Information";
	}
}

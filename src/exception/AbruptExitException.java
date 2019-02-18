package exception;

public class AbruptExitException extends LoginException{
	public AbruptExitException(){
		message = "Program has detected an abrupt exit.";
		title = "Yu-Gi-Oh Fast Exit";
	}
}
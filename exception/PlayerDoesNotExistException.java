package exception;

public class PlayerDoesNotExistException extends LoginException{
	public PlayerDoesNotExistException(){
		message = "Would you like to create an account instead?";
		title = "Player Profile Not Found!";
	}
}
package exception;

public class MultipleLoginException extends LoginException{
	public MultipleLoginException(){
		message = "Player has already logged in to the game.";
		title = "Multiple Login";
	}
}
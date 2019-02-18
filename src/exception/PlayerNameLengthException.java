package exception;

public class PlayerNameLengthException extends LoginException{
	public PlayerNameLengthException(){
		message = "Player's name must at least be 3 characters long.";
		title = "Unsecure Data Supplied";
	}
}
package exception;

public class PlayerAlreadyExistsException extends LoginException{
	public PlayerAlreadyExistsException(){
		message = "Overwrite existing player's account?";
		title = "Player Already Exists!";
	}	
}
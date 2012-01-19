package exception;

public class NewSummonException extends GameException{
	public NewSummonException(){
		message = "You have already summoned a monster during this turn.";
		title = "Multiple Summons Not Allowed";
	}
}
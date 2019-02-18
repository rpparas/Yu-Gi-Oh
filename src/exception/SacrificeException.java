package exception;

public class SacrificeException extends GameException{
	public SacrificeException(){
		message = "You do not have monsters in your field to be sacrificed.";
		title = "No Monsters in Field";
	}

	public SacrificeException(int number){
		message = "There should be " + number + " monsters offered as sacrifice.";
		title = "More Monsters Needed";
	}
}
package exception;

public class SetCardException extends GameException{
	public SetCardException(){
		message = "Something has prevented this card from being summoned. " +
					" Game Mat magic & trap card placeholders may be full.";
		title = "Card Can't Be Placed in Field";
	}
}
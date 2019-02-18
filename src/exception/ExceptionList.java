import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExceptionList extends RuntimeException{
	public void output(){

	}
}

class EmptyFieldException extends ExceptionList{
	public void output(){
		JOptionPane.showMessageDialog(null, "Please supply all fields with required data.", "Missing Information",
		JOptionPane.ERROR_MESSAGE);
	}
}

class PlayerDoesNotExistException extends ExceptionList{
	public void output(){
		JOptionPane.showConfirmDialog(null, "Would you like to create an account instead?", "Player Profile Not Found!",
		JOptionPane.YES_NO_OPTION);
	}
}

class PlayerAlreadyExistsException extends ExceptionList{
	public void output(){
		JOptionPane.showConfirmDialog(null, "Overwrite existing player's account?", "Player Already Exists!",
		JOptionPane.YES_NO_OPTION);
	}
}


class PlayerNameLengthException extends ExceptionList{
	public void output(){
		JOptionPane.showMessageDialog(null, "Player Name must have at least 3 characters.", "Vulnerable Data",
		JOptionPane.ERROR_MESSAGE);
	}
}


class PasswordLengthException extends ExceptionList{
	public void output(){
		JOptionPane.showMessageDialog(null, "Password must have at least 3 characters", "Vulnerable Data",
		JOptionPane.ERROR_MESSAGE);
	}
}

class AbruptExitException extends ExceptionList{
	public void output(){
		JOptionPane.showMessageDialog(null, "Program has detected an abrupt exit.", "Yu-Gi-Oh Exit Message",
		JOptionPane.WARNING_MESSAGE);
	}
}

class MultipleLoginException extends ExceptionList{
	public void output(){
		JOptionPane.showMessageDialog(null, "Player has already logged in to the game.", "Multiple Login",
		JOptionPane.ERROR_MESSAGE);
	}
}
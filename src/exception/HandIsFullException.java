package exception;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HandIsFullException extends GameException{
	public HandIsFullException(){
		message = "No additional cards can be placed in hand.";
		title = "Player's Hand Is Full";
	}
}

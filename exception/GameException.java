package exception;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameException extends RuntimeException{
	Object message;
	String title;

	public void output(){
		JOptionPane.showMessageDialog(null, message, title,
		JOptionPane.ERROR_MESSAGE);
	}
}
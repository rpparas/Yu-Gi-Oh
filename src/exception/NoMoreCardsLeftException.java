package exception;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NoMoreCardsLeftException extends GameException{
	public NoMoreCardsLeftException(){
		message = "You have run out of cards in your deck.";
		title = "No More Cards In Deck";
	}
}
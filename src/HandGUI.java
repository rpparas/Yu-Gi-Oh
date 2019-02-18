import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;

import java.text.*;


public class HandGUI extends MouseAdapter{
	private JPanel panel;
	private JButton[] buttons;

	private JDialog dialog;
	private JOptionPane pane;
	private ImageIcon icon;

	private Player player;
	private boolean isActive;

	private final int WIDTH = 80;
	private final int HEIGHT = 110;

	private static int clickedButton;
	private static Card cardClicked;
	static boolean buttonTriggered;


	public HandGUI(Player player, boolean isActive){
		panel = new JPanel();
		panel.setLayout( new GridLayout(1, 8, 10, 10) );

		this.player = player;
		this.isActive = isActive;
		clickedButton = -1;
	}

	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			clickedButton = Integer.parseInt( event.getActionCommand() );
			cardClicked = player.hand.getCard( clickedButton );

			changeColors();
			buttonTriggered = true;
		}

		private void changeColors(){
			Color color;
			for(int j = 0; j < player.hand.getNumberOfCards(); j++){
				color = new Color(238, 238, 238);
				buttons[j].setBackground( color );
			}

			if(cardClicked instanceof MonsterCard)
				buttons[clickedButton].setBackground( Color.YELLOW );
			else if(cardClicked instanceof MagicCard)
				buttons[clickedButton].setBackground( Color.GREEN.darker() );
			else
				buttons[clickedButton].setBackground( Color.MAGENTA.darker() );
		}
	}

	public void createPanels(){
		buttons = new JButton[player.hand.HAND_SIZE_MAX];

		for(int i = 0; i < player.hand.getNumberOfCards(); i++){
			setImage(i);
			panel.add( buttons[i] );
		}
	}

	public void setImage(int i){
		String group = null;
		Image image;
		ImageIcon icon;

		Card card = player.hand.getCard(i);

		if(isActive){
			icon = new ImageIcon( "../images/back.jpg" );
		}

		else{
			if(card instanceof MonsterCard)
				group = "monster/";
			else if(card instanceof MagicCard)
				group = "magic/";
			else if(card instanceof TrapCard)
				group = "trap/";

			icon = new ImageIcon( "../deck/" + group + card.getFileName() + ".jpg" );
		}

		image = icon.getImage();
		if(isActive)
			image = image.getScaledInstance(WIDTH, icon.getIconHeight(), Image.SCALE_SMOOTH);
		else
			image = image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

		icon = new ImageIcon( image );
		buttons[i] = new JButton( icon );
		buttons[i].setActionCommand( new Integer(i).toString() );
		buttons[i].addActionListener( new ButtonHandler() );
	}

	public static int getSelectedButton(){
		return clickedButton;	
	}
	
	public static Card getSelectedCard(){
		return cardClicked;
	}

	public JPanel getPanel(){
		return panel;
	}

	public void printCards(){
		DecimalFormat twoDigits = new DecimalFormat("00");
		Card card = null;
		int i;

		System.out.println("\n\nPlayerName: " + player.getPlayerName());
		for(i = 0; i < player.hand.getNumberOfCards(); i++){
			card = player.hand.getCard(i);
			System.out.print( twoDigits.format(i+1) + ": " + card.getCardName() + "  [");

			if( card instanceof MonsterCard )
				System.out.println("Monster Card]");

			else if( card instanceof TrapCard )
				System.out.println("Trap Card]");

			else
				System.out.println("Magic Card]");
		}
	}
}
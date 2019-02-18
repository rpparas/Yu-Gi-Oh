import exception.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.*;

public class FieldGUI{
	private JPanel panel;
	private JButton[] buttons;
	private	ImageIcon[] icons;
	private	Image image;

	private Player player;
	private boolean isActive;

	private final int WIDTH = 80;
	private final int HEIGHT = 110;
	private	int index;

	private static boolean isSacrifice;
	private static String[] sacrifice;
	private static int clickedButton = -1;
	private static int counter;

	private static Card cardClicked;
	static boolean buttonTriggered;


	public FieldGUI(Player player, boolean isActive){
		this.player = player;
		this.isActive = isActive;

		panel = new JPanel();
		panel.setLayout( new GridLayout(2, 7, 5, 5) );
	}

	private class ButtonHandler implements ActionListener{
		private ImageIcon icon;

		public void actionPerformed(ActionEvent event){
			clickedButton = Integer.parseInt( event.getActionCommand() );
			
			if( clickedButton >= 1 && clickedButton <= 5 ){
				cardClicked = player.field.getMonster(clickedButton-1);
			}else if( clickedButton >= 8 && clickedButton <= 12 ){
				cardClicked = player.field.getMagicTrap(clickedButton-8);
			}

			if(cardClicked != null){
				buttonTriggered = true;
			}
		}
	}

	public void createPanels(){
		buttons = new JButton[14];
		icons = new ImageIcon[14];

		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton();
		}

		index = 0;
		if(isActive){
			createDeck();
			createMagicTrap();
			createFusion();

			createGraveyard();
			createMonster();
			createField();
		}

		else{
			createField();
			createMonster();
			createGraveyard();

			createFusion();
			createMagicTrap();
			createDeck();
		}

		for(int i = 0; i < buttons.length; i++){
			buttons[i].setActionCommand( new Integer(i).toString() );
			buttons[i].addActionListener( new ButtonHandler() );
			panel.add( buttons[i] );
		}
	}

	/** Field Card Holder */
	private void createField(){
		if(player.field.getField() != null){
			icons[index] = new ImageIcon( "../deck/magic/" + player.field.getField().getFileName() + ".jpg" );
		}
		else{
			icons[index] = new ImageIcon("../images/field.gif");
		}

		createButton(true);
	}

	/** Monster Cards Holder */
	private void createMonster(){
		for(int i = 0; i < 5; i++){
			if(player.field.getMonster(i) != null){
				if( player.field.getMonster(i).getPosition().equals(Field.FACE_UP) ){
					icons[index] = new ImageIcon( "../deck/monster/" + player.field.getMonster(i).getFileName() + ".jpg" );
					createButton(true);
				}

				else if( player.field.getMonster(i).getPosition().equals(Field.FACE_DOWN) ){
					icons[index] = new ImageIcon( "../images/hback.jpg" );
					createButton(false);
				}

				else if( player.field.getMonster(i).getPosition().equals(Field.DEFENSE) ){
					icons[index] = new ImageIcon( "../deck/monster/" + player.field.getMonster(i).getFileName() + ".jpg" );
					createButton(false);
				}
			}

			else{
				icons[index] = new ImageIcon("../images/monster.gif");
				createButton(true);
			}
		}
	}

	/** Graveyard Card Holder */
	private void createGraveyard(){
		Card card = player.graveyard.getLastCard();
		String group = null;

		if(card instanceof MonsterCard)
			group = "monster/";
		else if(card instanceof MagicCard)
			group = "magic/";
		else
			group = "trap/";

		if(card != null){
			icons[index] = new ImageIcon( "../deck/" + group + player.graveyard.getLastCard().getFileName() + ".jpg" );
		}
		else{
			icons[index] = new ImageIcon("../images/grave.gif");
		}


		createButton(true);
	}

	/** Fusion Card Holder */
	private void createFusion(){
		if(player.field.getFusion() != null){
			icons[index] = new ImageIcon( "../deck/monster/" + player.field.getFusion().getFileName() + ".jpg" );
		}
		else{
			icons[index] = new ImageIcon("../images/fusion.gif");
		}

		createButton(true);
	}

	/** Trap & Magic Cards */
	private void createMagicTrap(){
		Card card;
		String group = null;

		for(int i = 0; i < 5; i++){
			card = player.field.getMagicTrap(i);
			group = (card instanceof MagicCard ? "magic/" : "trap/");

			if(card != null){
				if( card.getPosition().equals(Field.ACTIVATE) ){
					icons[index] = new ImageIcon( "../deck/" + group + card.getFileName() + ".jpg" );
				}

				else{
					icons[index] = new ImageIcon( "../images/back_orig.jpg" );
				}
			}

			else{
				if(i % 2 == 0){
					icons[index] = new ImageIcon("../images/magic.gif");
				}
				else{
					icons[index] = new ImageIcon("../images/trap.gif");
				}
			}

			createButton(true);
		}
	}

	/** Deck Card Holder */
	private void createDeck(){
		icons[index] = new ImageIcon( "../images/back_orig.jpg" );

		createButton(true);
	}

	private void createButton(boolean isPlacedVertical){
		image = icons[index].getImage();
		if( isPlacedVertical ){
			image = image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_FAST);
		}else{
			int height = (int)(WIDTH * 0.75);
			int width = (int)(HEIGHT * 0.75);
			image = image.getScaledInstance(width, height, Image.SCALE_FAST);			
		}
		
		ImageIcon newIcon = new ImageIcon( image );

		buttons[index] = new JButton( newIcon );
		index++;
	}

	public static String makeSelection(MonsterCard[] monsters, int sacrificeNum){
		String option = null;

		if(sacrifice == null){
			sacrifice = new String[sacrificeNum];
		}

		else{
			option = CardViewer.showOption(monsters);
			sacrifice[counter] = option;
			counter++;
		}

		return option;
	}

	public static int getSelectedButton(){
		return clickedButton;	
	}
	
	public static Card getSelectedCard(){
		return cardClicked;
	}
	
	public static String[] getSacrifice(){
		return sacrifice;
	}

	public JPanel getPanel(){
		return panel;
	}

	public void printCards(){
		DecimalFormat twoDigits = new DecimalFormat("00");
		Card card = null;
		int i;

		for(i = 0; i < player.field.getMonsterCounter(); i++){
			if(i == 0){
				System.out.println("\n\nPlayerName: " + player.getPlayerName());
				System.out.println("Monster Cards:");
			}

			card = player.field.getMonster(i);
			System.out.println( twoDigits.format(i+1) + ": " + card.getCardName() );
		}

		for(i = 0; i < player.field.getMagicTrapCounter(); i++){
			if(i == 0){
				System.out.println("\nMagic/Trap Cards:");
			}

			card = player.field.getMagicTrap(i);
			System.out.println( twoDigits.format(i+1) + ": " + card.getCardName() );
		}
	}
}
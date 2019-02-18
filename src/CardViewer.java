import exception.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class CardViewer{
	public CardViewer(){
		
	}
	
	public static int showOption(MonsterCard card){
		String[] choices  = {Field.FACE_UP, Field.FACE_DOWN, Field.CANCEL};
		ImageIcon icon = new ImageIcon("../deck/monster/" + card.getFileName() + ".jpg");

		int option = JOptionPane.showOptionDialog(null, null, "Are you going to summon this Monster?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, choices, choices[0]);
		return option;
	}
	
	public static int showOption(MagicCard card){
		String[] choices  = {Field.ACTIVATE, Field.SET, Field.CANCEL};
		ImageIcon icon = new ImageIcon("../deck/magic/" + card.getFileName() + ".jpg");

		int option = JOptionPane.showOptionDialog(null, null, "Would you like to Activate or Set this card?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, choices, choices[0]);
		return option;		
	}
	
	public static int showOption(TrapCard card){
		String[] choices  = {Field.ACTIVATE, Field.SET, Field.CANCEL};
		ImageIcon icon = new ImageIcon("../deck/trap/" + card.getFileName() + ".jpg");

		int option = JOptionPane.showOptionDialog(null, null, "How would you like to use to use this card?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, choices, choices[0]);
		return option;		
	}

	public static int showOption(int sacrificeNum){
		int option;

		String[] choices  = {"Select", "Cancel"};
		option = JOptionPane.showOptionDialog(null, "Select " + sacrificeNum + " sacrifice monster/s to summon this card.", "Your intended summon requires sacrifice monsters.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

		return option;
	}

	public static String showOption(MonsterCard[] monsters) throws EquipException{
		String option = null;

		if(monsters.length == 0){
			throw new EquipException(0);

		}else{
			String[] choices = new String[monsters.length];

			for(int i = 0; i < monsters.length; i++){
				choices[i] = monsters[i].getCardName();
			}

			option = (String)JOptionPane.showInputDialog(null, "Designate a target monster for this card.", "Target Monster", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		}

		return option;
	}
	
	public static void viewCard(Card card){
		ImageIcon icon;
		
		if(card instanceof MonsterCard){
			icon = new ImageIcon("../deck/monster/" + card.getFileName() + ".jpg");
		}else if(card instanceof MagicCard){
			icon = new ImageIcon("../deck/magic/" + card.getFileName() + ".jpg");			
		}else{
			icon = new ImageIcon("../deck/trap/" + card.getFileName() + ".jpg");						
		}

		JOptionPane.showConfirmDialog(null, null, card.getCardName(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public static String viewCard(MonsterCard card, int targetNum){
		ImageIcon icon = new ImageIcon("../deck/monster/" + card.getFileName() + ".jpg");
		String[] choices = new String[2];
		String option = null;
		
		if( card.getPosition().equals(Field.FACE_UP) ){
			if( targetNum == 0 ){
				choices[0] = "Direct Attack";
				choices[1] = "Cancel";
			}else{
				choices[0] = "Select Target";
				choices[1] = "Cancel";
			}
			option = (String)JOptionPane.showInputDialog(null, null, "Do you wish this monster to attack?", JOptionPane.QUESTION_MESSAGE, icon, choices, choices[0]);
		}else if( card.getPosition().equals(Field.FACE_DOWN) ){
			JOptionPane.showConfirmDialog(null, null, card.getCardName() + " in Face Down Position", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
		}else{
			JOptionPane.showConfirmDialog(null, null, card.getCardName() + " in Defense Position", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);			
		}
		
		return option;		
	}
}
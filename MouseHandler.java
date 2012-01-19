import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;

import java.text.*;

public class MouseHandler extends MouseAdapter{
	private ImageIcon icon;
	private Card cardClicked;

	private final int SINGLE_CLICK = 1;
	private final int DOUBLE_CLICK = 2;
	private final int DOUBLE_CLICK_INTERVAL = 500;

	private static long timeLastMouseClicked; 		// last mouse down time
	private static int clickNumTimes;
	private static int optionSelected;

	public MouseHandler(){
		optionSelected = -1;
	}
	
	public void mouseClicked(MouseEvent event){
		cardClicked = HandGUI.getSelectedCard();
		
		long currentTime = event.getWhen();

		if( currentTime - timeLastMouseClicked < DOUBLE_CLICK_INTERVAL ){
			clickNumTimes = DOUBLE_CLICK;
			optionSelected = FieldGUI.showOption(cardClicked);
			timeLastMouseClicked = 0;
		}
		else{
			clickNumTimes = SINGLE_CLICK;
			if( timeLastMouseClicked != 0){
				initDialog();
				resizeIcon();
				showDialog();
			}
			
			timeLastMouseClicked = currentTime;				
		}
		
		HandGUI.buttonTriggered = true;
	}

	private void initDialog(){
		String cardGroup = null;

		if( cardClicked instanceof MonsterCard )
			cardGroup = "monster/";
		else if( cardClicked instanceof MagicCard )
			cardGroup = "magic/";
		else
			cardGroup = "trap/";

		icon = new ImageIcon( "../deck/" + cardGroup + cardClicked.getFileName() + ".jpg" );
	}

	private void resizeIcon(){
		Image image = icon.getImage();
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();

		image = image.getScaledInstance(width, height, Image.SCALE_FAST);
		icon = new ImageIcon( image );
	}

	private void showDialog(){
		JOptionPane pane = new JOptionPane( null, JOptionPane.INFORMATION_MESSAGE );
		pane.setIcon( icon );

		JDialog dialog = pane.createDialog(null, cardClicked.getCardName() );
		dialog.setVisible(true);
	}
	
	public static int getSelectedOption(){
		int temp = optionSelected;
		optionSelected = -1;
		return temp;
	}
}
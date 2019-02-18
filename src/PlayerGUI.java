import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.text.*;
import java.util.*;

import exception.*;

public class PlayerGUI{
	private Frame frame;
	private JSplitPane splitPane;
	private Player player;

	private String[] list;
	String successful;

	public PlayerGUI(Player player){
		this.player = player;
		successful = new String("wait");

		frame = new Frame(player.getPlayerName() + "'s Deck");
		frame.setLayout( new BorderLayout(2, 2) );
		createList();
	}

	private void createList(){
		DecimalFormat twoDigits = new DecimalFormat("00");
		int i;

		list = new String[player.deckSize];

		for(i = 0; i < player.deckSize; i++){
			list[i] = new String( twoDigits.format(i+1) );
			list[i] += "    ";
			list[i] += player.getCard(i).getCardName();
		}
	}

	public void displayWindow(){
		Panel panel;
		JButton cont, exit;
		JLabel top;

		// display instructions to the user
		top = new JLabel("Click on an entry below to view it on the right.");
		frame.add(top, BorderLayout.NORTH);

		// create buttons and add them to new panel
		cont = new JButton("Continue");
		exit = new JButton("Exit");

		panel = new Panel( new FlowLayout() );
		panel.add(cont);
		panel.add(exit);
		frame.add(panel, BorderLayout.SOUTH);

		// create image preview area
		previewImage();

		// display GUI Window;
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setResizable(false);

		// bind action listener to button
		ButtonHandler handler = new ButtonHandler();
		cont.addActionListener( handler );
		exit.addActionListener( handler );
	}


	private void previewImage(){
		ImagePreview imagePrev;

		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){ System.exit(0); }
        });

		imagePrev = new ImagePreview( player.getDrawnCards(), list );

        frame.add(imagePrev.getSplitPane(), BorderLayout.CENTER);
	}


	private class ButtonHandler implements ActionListener{
		int selectedIndex;

		public void actionPerformed(ActionEvent event){
			try{
				frame.setVisible(false);

				if( event.getActionCommand().equalsIgnoreCase("exit") )
					throw new AbruptExitException();
			}

			catch(LoginException e){
				e.output();
			}

			finally{
				successful = event.getActionCommand();
			}
		}
	}
}
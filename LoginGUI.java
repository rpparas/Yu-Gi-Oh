import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import exception.*;

public class LoginGUI{
	private PlayerList playerList;

	private JFrame frame;
	private JTextField playerName;
	private JPasswordField password;

	private Player playerInfo, otherPlayer;

	boolean successful, isMultiple;


	public LoginGUI(){
		frame = new JFrame("Yu-Gi-Oh! Goes Digital");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ImageIcon icon = new ImageIcon("../images/yugi.png");		
		//frame.setIconImage( icon.getImage() );
		
		playerInfo = new Player();
		playerList = new PlayerList();
	}

	public void setOtherPlayer(Player otherPlayer){
		this.otherPlayer = otherPlayer;
	}

	public void displayLoginWindow(int playerCounter){
		Container container;
		GridLayout grid;

		JButton[] buttons = new JButton[2];
		JLabel[] label = new JLabel[2];

		int i;

		// get content pane and set its layout
		grid = new GridLayout(3, 2, 5, 5);
		container = frame.getContentPane();
		container.setLayout(grid);


		// create and set labels
		if(playerCounter == 1)
			label[0] = new JLabel("Player 1: ");
		else
			label[0] = new JLabel("Player 2: ");

		label[1] = new JLabel("Password: ");

		for(i = 0; i < label.length; i++)
			container.add( label[i] );


		// create and add textFields
		playerName = new JTextField(15);
		password = new JPasswordField(15);
		container.add( playerName );
		container.add( password );


		// create and add buttons
		buttons[0] = new JButton("Start New Game");
		buttons[1] = new JButton("Create Account");
		buttons[0].setBackground(Color.RED);
		buttons[1].setBackground(Color.RED);
		container.add( buttons[0] );
		container.add( buttons[1] );

		// bind buttons to event handlers
		ButtonHandler handler = new ButtonHandler();
		buttons[0].addActionListener( handler );
		buttons[1].addActionListener( handler );

		// display GUI Window;
		frame.setSize(280, 120);
		frame.setVisible(true);
		frame.setResizable(false);

	}

	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				successful = false;
				isMultiple = false;

				if( playerName.getText() == null || playerName.getText().equals("") || password.getPassword() == null)

					throw new EmptyFieldException();

				else if( event.getActionCommand().equals( "Create Account" ) ){

					playerList.createPlayer( playerName.getText(), password.getPassword() );
					playerInfo = playerList.getPlayer();

					if(otherPlayer != null && playerInfo.getPlayerName().equals( otherPlayer.getPlayerName() )){
						isMultiple = true;
						throw new MultipleLoginException();
					}

					else
						JOptionPane.showMessageDialog(null, "An account has been created for " + playerInfo.getPlayerName() + ".", "Account Creation Successful!", JOptionPane.INFORMATION_MESSAGE);

					frame.setVisible(false);
					successful = true;
				}

				else if( event.getActionCommand().equals( "Start New Game" ) ){

					if(!playerList.verifyPlayer( playerName.getText(), password.getPassword() ))
						throw new PlayerDoesNotExistException();

					else
						playerInfo = getPlayer();

					JOptionPane.showMessageDialog(null, "Welcome back, " + playerInfo.getPlayerName() + ".", "Login Successful!", JOptionPane.INFORMATION_MESSAGE);

					frame.setVisible(false);
					successful = true;
				}
			}

			catch(LoginException e){
				e.output();
			}
		}
	}

	public void whoStarts(Player[] player){
		Player temp = new Player();

		int seed = playerList.whoStarts();

		if(seed == 0){
			player[0] = player[0];
			player[1] = player[1];
		}

		else{
			temp = player[0];
			player[0] = player[1];
			player[1] = temp;
		}

		//JOptionPane.showMessageDialog(null, player[0].getPlayerName() + " starts first.", "Who starts first?", JOptionPane.INFORMATION_MESSAGE);
	}

	public Player getPlayer(){
		return playerInfo;
	}
}
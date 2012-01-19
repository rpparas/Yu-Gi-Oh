import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class MainGUI extends JFrame{
	private Container container;
	private JSplitPane[] splitPane;
	private JPanel[] cardPanel;
	private JPanel playerPanel;
	private JLabel logo;

	private FieldGUI[] fieldGUI;
	private HandGUI[] handGUI;

	private Player[] players;
	private Player player1, player2;

	private Image image;
	private ImageIcon icon;
	private Color color;
	private String text;


	public MainGUI(Player[] players, int active){
		splitPane = new JSplitPane[2];
		cardPanel = new JPanel[2];

		fieldGUI = new FieldGUI[2];
		handGUI = new HandGUI[2];

		this.players = new Player[2];
		setPlayer( players, active );

		this.addKeyListener( new KeyboardHandler() );
	}

	public class KeyboardHandler extends KeyAdapter{
		public void keyPressed(KeyEvent event){
			if(event.getKeyCode() == KeyEvent.VK_F5){
				addComponents(true);
			}
		}
	}

	public class ButtonControls implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String source = event.getActionCommand();
			if( source.equals("Next  Phase") ){
				MainPhase.isComplete = true;
			}else if( source.equals("End of Turn") ){
				GamePlay.isEndOfTurn = true;
			}else if( source.equals(" Surrender ") ){
				GamePlay.isSurrender = true;
			}
			System.out.println("source button: " + source);
		}
	}

	public void setPlayer(Player[] players, int active){
		this.players[0] = (active == 0 ? players[1] : players[0]);
		this.players[1] = (active == 0 ? players[0] : players[1]);
	}


	public void setImage(String fileName){
		icon = new ImageIcon( fileName );
		image = icon.getImage();
	}

	public void setText(String text){
		this.text = text;
	}

	/** creates real-world Game Mat for each player */
	public void addComponents(boolean isRefresh){
		if( isRefresh ){
			container.remove( splitPane[1] );
			container = new Container();
		}

		container = getContentPane();
		container.setLayout( new GridLayout(1, 2, 5, 5) );

		buildControls();

		buildInterface(0, true);
		buildInterface(1, false);

		splitPane[0] = new JSplitPane( JSplitPane.VERTICAL_SPLIT, true, cardPanel[0], cardPanel[1] );
		splitPane[0].setDividerLocation(320);
		splitPane[1] = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, true, playerPanel, splitPane[0] );
		splitPane[1].setDividerLocation(200);

		for(int i = 0; i < splitPane.length; i++){
			splitPane[i].setOneTouchExpandable(true);
		}

		container.add( splitPane[1] );

		if( isRefresh ){
			setContentPane( container );
			validate();
		}
	}

	public void buildControls(){
		playerPanel = new JPanel();
		playerPanel.setLayout( new GridLayout(6, 1) );

		for(int i = 0; i < players.length; i++){
			JPanel[] panels = new JPanel[3];

			for(int j = 0; j < panels.length; j++){
				panels[j] = new JPanel();
				panels[j].setLayout( new FlowLayout(FlowLayout.CENTER) );
			}

			panels[0].add( showPlayerName(i) );
			panels[1].add( showLifePoints(i) );

			if( i == 0 ){
				setLogo();
				panels[2].add( logo );
			}
			else
				panels[2].add( showControls() );


			for(int j = 0; j < panels.length; j++)
				playerPanel.add( panels[j] );
		}
	}


	public JLabel showPlayerName(int i){
		String name = players[i].getPlayerName().toLowerCase();
		JLabel playerName = null;

		if( PlayerList.hasAvatar(name) ){
			ImageIcon icon = new ImageIcon( "../players/" + name + ".gif");
			playerName = new JLabel( icon );
		}
		else{
			playerName = new JLabel( name );
			if(i == 0)
				playerName.setForeground(Color.RED);
			else
				playerName.setForeground(Color.BLUE);
		}

		return playerName;
	}

	public JPanel showLifePoints(int i){
		JProgressBar progress = new JProgressBar( JProgressBar.HORIZONTAL, 0, Player.getMaximumLifePoints() );
		if(i == 0){
			progress.setValue( players[i].getLifePoints() );
		}else{
			progress.setValue( players[i].getLifePoints() );
		}

		progress.setIndeterminate( true );
		progress.setBorderPainted( true );
		progress.setStringPainted( true );

		JLabel label = new JLabel("Player's Life Points", JLabel.CENTER);
		label.setLabelFor(progress);

		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(2, 1) );
		panel.add(label);
		panel.add(progress);

		return panel;
	}

	public void setLogo(){
		if(logo == null)
			logo = new JLabel();

		logo.setIcon( new ImageIcon("../images/yugi.jpg") );
	}

	public JPanel showControls(){
		JButton[] controls = new JButton[3];

		controls[0] = new JButton("BattlePhase");
		controls[1] = new JButton("End of Turn");
		controls[2] = new JButton(" Surrender ");

		if( GamePlay.getNumberOfTurns() == 0 ){
			controls[0].setEnabled(false);
		}else{
			controls[0].setEnabled(true);
		}

		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(3, 1, 5, 5) );

		for(int i = 0; i < controls.length; i++){
			controls[i].addActionListener( new ButtonControls() );
			panel.add( controls[i] );
		}

		return panel;
	}


	/** places small boxes for each card in game mat */
	public void buildInterface(int i, boolean isActive){
		cardPanel[i] = new JPanel();
		cardPanel[i].setLayout( new FlowLayout(FlowLayout.CENTER) );

		fieldGUI[i] = new FieldGUI( players[i], isActive );
		fieldGUI[i].createPanels();

		handGUI[i] = new HandGUI( players[i], isActive );
		handGUI[i].createPanels();

		if( isActive ){
			cardPanel[i].add( handGUI[i].getPanel() );
			cardPanel[i].add( fieldGUI[i].getPanel() );
		}
		else{
			cardPanel[i].add( fieldGUI[i].getPanel() );
			cardPanel[i].add( handGUI[i].getPanel() );
		}

		// debugging info
		handGUI[i].printCards();
		fieldGUI[i].printCards();
	}

	public void displayWhoStarts(){
		JOptionPane.showConfirmDialog(null, players[1].getPlayerName() + " starts first.  Press OK when you're ready.", "Start Game",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void displayWhosTurn(String playerName){
		int random = (int)(Math.random() * 5);
		Object message = null;
		String title = "Next Player";
		
		switch(random){
			case 0:	message = "It's " + playerName + "'s turn.  Press OK when you're ready.";
					break;
			case 1:	message = "Kindly call " + playerName + " to deliver his/her might.";
					break;
			case 2:	message = playerName + ", it's about time you show us your skill.";
					break;
			case 3:	message = "Oh, come on, " + playerName + " could do better than that!";
					break;
			case 4:	message = "Yeah baby! " + playerName + " are you up to the challenge?";
					break;
		}		
		
		JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}	

	public void paint(Graphics g){
		if( image != null ){
			g.drawImage(image, 430, 220, icon.getIconWidth(), (int)(icon.getIconHeight()*.90), this);
			repaint();
			image = null;
		}
		else if( text != null ){
			g.setColor(color);
			g.drawString(text, 200, 200);
			text = null;
			repaint();
		}
	}

	public void launchFrame(){
		setTitle("Yu-Gi-Oh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(1024, 750);
		setUndecorated(true);

		setResizable(false);
		setVisible(true);
	}
}
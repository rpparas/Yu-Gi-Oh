// Yu-Gi-Oh! is a registered trademark of Konami.  Thus, this program is intended for non-commercial use.
// The program doesn't do networking (just yet)... Double play is facilitated by changing windows.
import exception.*;

public class Main{
	private PlayerGUI[] playerGUI;
	private LoginGUI[] loginGUI;
	private MainGUI mainGUI;

	private MainPhase mainPhase;
	private BattlePhase battlePhase;
	private Player[] players;


	public Main(){
		loginGUI = new LoginGUI[2];
		playerGUI = new PlayerGUI[2];
		players = new Player[2];
	}

	/** Debugging Information */
	public void initPlayers(){
		players[0] = new Player("Rommel");
		players[0].buildDeck();
		players[1] = new Player("Kline");
		players[1].buildDeck();
	}

	/** requests player information by verifying login with existing player accounts */
	/** or by creating a new account, along with a new set of deck and avatar.  This */
	/** method utilizes the loginGUI class and interacts with the PlayerList class. */
    private void askPlayer(){
		boolean isError;

		loginGUI[0] = new LoginGUI();
		loginGUI[1] = new LoginGUI();

		loginGUI[0].displayLoginWindow(1);
		while( !loginGUI[0].successful );
		players[0] = loginGUI[0].getPlayer();

		do{
			isError = false;

			loginGUI[1].setOtherPlayer( players[0] );
			loginGUI[1].displayLoginWindow(2);

			while( !loginGUI[1].successful ){
				if( loginGUI[1].isMultiple )
					isError = true;
				else
					isError = false;
			}

			players[1] = loginGUI[1].getPlayer();

		}while(isError);

		loginGUI[0].whoStarts(players);
	}


	/** displays an image gallery for the players' deck, letting the user preview the */
	/** cards in his deck in cardGroup-sorted arrangement (monsters, magic, then trap cards */
	/** This method creates a playerGUI which contains the card viewing window. */ 
	private void showGallery(){
		int i;

		for(i = 0; i < players.length; i++){
			if( players[i].isNewPlayer )
				players[i].buildDeck();
			else
				players[i].loadDeck();

			playerGUI[i] = new PlayerGUI( players[i] );
			playerGUI[i].displayWindow();

			while( playerGUI[i].successful.equalsIgnoreCase("wait") );

			if( playerGUI[i].successful.equalsIgnoreCase("exit") )
				System.exit(0);
		}
	}

	/** constructs the program's main window, which replicates a real world Yu-Gi-Oh Game */
	/** Mat.  Upon creating this window, five cards are drawn from the player's deck deck */
	/** and placed into the hand, which appears at the bottommost part of the screen. This */
	/** method utilizes the DrawPhase (first phase) class, which enables the drawing of cards. */
	private void buildInterface(){
		DrawPhase drawPhase = new DrawPhase( players );
		players = drawPhase.getPlayers();

		mainGUI = new MainGUI( players, 0 );
		mainGUI.addComponents(false);
		mainGUI.setImage("../images/logo.gif");
		mainGUI.launchFrame();
	}

	/** refreshes the active user's game interface by resetting screen components.  This */
	/** method is invoked after a button in the mainGUI (user interface) has caused an */
	/** event where there is a need to update the active player's window */
	private void updateUserInterface(int active){
		players = mainPhase.getPlayers();
		mainGUI.setPlayer( players, active );
		mainGUI.addComponents(true);		
	}

	/** indicates the start of a player's turn by assigning him or her as the "active player". */
	/** During this instance, a new card is drawn from the player's deck and placed in his card. */
	/** This method makes use of the second constructor the DrawPhase class */
	private void beginDrawPhase(int active){
		DrawPhase drawPhase = new DrawPhase( players[active] );
		players[active] = drawPhase.getPlayer();

		if( GamePlay.getNumberOfTurns() == 0 && active == 0){
			mainGUI.displayWhoStarts();
		}else{
			mainGUI.displayWhosTurn(players[active].getPlayerName());
		}			
		mainGUI.setPlayer( players, active );
		mainGUI.addComponents(true);
	}

	/** launches the Main Phase (second phase) of the players' turn into action. */
	/** This method creates an instance of class MainPhase, which is responsible for */
	/** summoning monsters into the field, setting magic and trap cards, and often
	/** times activating magic and trap cards. during the second phase.  This method */
	/** returns true when the player proceeds into BattlePhase, false if otherwise. */
	private boolean beginMainPhase(int active) throws GameOverException{
		mainPhase = new MainPhase( players, active );
		Card card;
		int button;

		while( !GamePlay.isEndOfTurn && !mainPhase.isComplete && !GamePlay.isSurrender ){		
			if( HandGUI.buttonTriggered ){
				card = HandGUI.getSelectedCard();
				button = HandGUI.getSelectedButton();

				if( card instanceof MonsterCard ){
					mainPhase.playMonsterCard( (MonsterCard)card, button );
				}
				else if( card instanceof MagicCard ){
					mainPhase.playMagicCard( (MagicCard)card, button );
				}
				else{
					mainPhase.playTrapCard( (TrapCard)card, button );
				}
				
				updateUserInterface(active);
				HandGUI.buttonTriggered = false;
			}
			else if( FieldGUI.buttonTriggered ){
				card = FieldGUI.getSelectedCard();				
				CardViewer.viewCard(card);

				updateUserInterface(active);
				FieldGUI.buttonTriggered = false;
			}
		}

		if( GamePlay.isSurrender ){
			GamePlay.isSurrender = false;
			throw new GameOverException(true);
		}
		if( GamePlay.isEndOfTurn ){
			GamePlay.isEndOfTurn = false;
			return false;
		}
		else{
			return true;
		}
	}
	/** launches the Battle Phase (third phase) of the players' turn into action. */
	/** This method creates an instance of class BattlePhase, which is responsible for */
	/** controlling and analyzing the player's actions during the third phase */
	
	private boolean beginBattlePhase(int active) throws GameOverException{
		battlePhase = new BattlePhase( players, active );
		String optionSelected = null;
		int button, targetNum;
		Card card;

		while( !GamePlay.isEndOfTurn && !battlePhase.isComplete && !GamePlay.isSurrender ){
			System.out.println("Battle Phase bleh");			
			System.out.println(GamePlay.isEndOfTurn +""+ battlePhase.isComplete +""+ GamePlay.isSurrender );
			
			/*if( FieldGUI.buttonTriggered ){
				card = FieldGUI.getSelectedCard();
				System.out.println("sulod diri card: " + card);
				button = HandGUI.getSelectedButton();
				
				if( card instanceof MonsterCard ){
					targetNum = players[1-active].field.getMonsterCounter();
					System.out.println("\t\t\tTARGETNUM: " + targetNum);
					optionSelected = CardViewer.viewCard( (MonsterCard)card, targetNum );
				}
				
				updateUserInterface(active);
				FieldGUI.buttonTriggered = false;			
			}*/
		}

		if( GamePlay.isSurrender ){
			throw new GameOverException(true);
		}
		if( GamePlay.isEndOfTurn ){
			return false;
		}
		else{
			return true;
		}
	}
	/** facilitates actions during GamePlay, such as drawing of cards, summoning of */
	/** monsters, activation of magic and trap cards, and monster vs. monster battles */
	/** This method is very vital in ensuring the execution of the game. */

	private void startGame(){
		int active = 0;
		boolean proceed;

		try{
			do{
				beginDrawPhase(active);
				try{
					proceed = beginMainPhase(active);
				}catch(GameException e){
					e.output();
					players[active].setLifePoints(0);
					throw new GameOverException(false);
				}

				if(proceed){
					proceed = false;
					System.out.println("b4 bp");
					beginBattlePhase(active);
					System.out.println("af bp");
				}

				active = 1 - active;

				if(active == 1){
					GamePlay.incrementNumberOfTurns();
					System.out.println("\t\t\t active: " + active);
					System.out.println( "Number of Turns: " + GamePlay.getNumberOfTurns() );
				}
			}while( (players[0].getLifePoints() != 0) && (players[1].getLifePoints() != 0) );
		}catch(GameException e){
			e.output();
			players[active].setLifePoints(0);
		}
	}

	private void gameOver(){
		if( players[0].getLifePoints() != 0 ){
			// output Player[1] as winner, likewise include Life Points
		}

		else{
			// do the steps listed above but award it to Player[0]
		}

		// do whatever you like: ask if player wants to buy cards,
		// or you may close the app or just say something to the player
	}

	/** creates an instance of the class Main and starts off this Yu-Gi-Oh! program. */
	/** main() method facilitates the user login inputs, creation of card deck and */
	/** execution of the game proper.  This method encompasses the most fundamental 
	/** section of the code, program launch. */

	public static void main(String[] args){
		Main main = new Main();

		//main.askPlayer();
		//main.showGallery();
		main.initPlayers();
		main.buildInterface();

		main.startGame();
		main.gameOver();
	}
}

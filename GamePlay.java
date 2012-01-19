public class GamePlay{
	private Player[] players;
	private Player player;

	private static int numberOfTurns;
	
	static boolean isEndOfTurn;
	static boolean isSurrender;


	public void GamePlay(Player[] players){
		isEndOfTurn = false;
		setPlayer(players);
	}


	public void GamePlay(Player player){
		isEndOfTurn = false;
		setPlayer(player);
	}


	public void setPlayer(Player[] players){
		this.players = players;
	}


	public void setPlayer(Player player){
		this.player = player;
	}

	public Player[] getPlayers(){
		return players;
	}

	public Player getPlayer(){
		return player;
	}

	public static void incrementNumberOfTurns(){
		numberOfTurns++;
	}
	
	public static int getNumberOfTurns(){
		return numberOfTurns;
	}
}
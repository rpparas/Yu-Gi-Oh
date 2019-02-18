import exception.*;

public class BattlePhase extends GamePlay{
	private Player active;
	private Player passive;

	private boolean hasSummoned;
	private int activePlayer;
	private int option;

	private static boolean canStillAttack;
	static boolean isComplete;


	public BattlePhase(Player[] players, int active){
		if(active == 0){
			this.active = players[0];
			this.passive = players[1];
		}
		else{
			this.active = players[1];
			this.passive = players[0];
		}

		activePlayer = active;
	}

	// attack Monster
	// active trap card
	// compute damage
	// destroy monster
	// repeat if there are still monsters which can attack
	
	public boolean canStillAttack(){
		boolean canStillAttack = true;
		return canStillAttack;
	}

	public Player[] getPlayers(){
		Player[] players = new Player[2];

		if(activePlayer == 0){
			players[0] = active;
			players[1] = passive;
		}else{
			players[0] = passive;
			players[1] = active;
		}

		return players;
	}
}
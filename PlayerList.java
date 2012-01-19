import exception.*;

public class PlayerList {
	private Player[] player;

    private String plyr, pswd;
    private int playerIndex;
	private final static int LENGTH = 3;


    public PlayerList(){
        playerIndex = 0;				// file operation here & load all players & their index i
        player = new Player[playerIndex+2];
	}


    public boolean verifyPlayer(String plyr, char[] pswd)
    	throws PlayerDoesNotExistException{

		String password = new String(pswd);

		boolean playerNameOk = false;
		boolean passwordOk = false;
		int playersInList = playerIndex;

		for(int i = 0; i < playersInList; i++){
			if( plyr.equalsIgnoreCase(player[i].getPlayerName()) ){
				playerNameOk = true;

				if( pswd.equals(player[i].getPassword()) ){
					passwordOk = true;
					break;
				}
			}
		}

		if( !playerNameOk || !passwordOk)
			return false;

		else
			return true;
    }


    public void createPlayer(String plyr, char[] pswd)
    	throws PlayerAlreadyExistsException, PlayerNameLengthException, PasswordLengthException{

		if( verifyPlayer(plyr, pswd) )
			throw new PlayerAlreadyExistsException();

		else if( plyr.length() < LENGTH )
			throw new  PlayerNameLengthException();

		else if( pswd.length < LENGTH )
			throw new PasswordLengthException();

		else{
			// create new player on available index
			player[playerIndex] = new Player(plyr, pswd);
			player[playerIndex].isNewPlayer = true;
			playerIndex++;
		}
    }

    public int whoStarts(){
		int seed = (int)(Math.random() * 2);
		return seed;
	}

	public Player getPlayer(){
		return player[playerIndex-1];
	}

	public static boolean hasAvatar(String playerName){
		// file operations: inputStream then tokenize
		boolean result = false;

		if(playerName.equalsIgnoreCase("Rommel") )
			result = true;
		else if(playerName.equalsIgnoreCase("Kline") )
			result = true;

		return result;
	}
}
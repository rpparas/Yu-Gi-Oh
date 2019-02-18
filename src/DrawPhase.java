import exception.*;

public class DrawPhase extends GamePlay{
	private int cardIndex;

	public DrawPhase(Player[] players){
		Card card;
		int i, draws;

		for(i = 0; i < players.length; i++){
			for(draws = 1; draws <= 5; draws++){
				card = drawCard(players[i]);
				try{
					players[i] = updatePlayer(players[i]);
				}catch(GameException e){
					e.output();
				}
			}
		}

		setPlayer(players);
	}

	public DrawPhase(Player player) throws GameOverException{
		Card card;

		try{
			card = drawCard(player);
		}catch(GameException e){
			e.output();
			throw new GameOverException();
		}

		try{
			player = updatePlayer(player);
		}catch(GameException e){
			e.output();
		}finally{
			setPlayer(player);
		}
	}

	private Card drawCard(Player player) throws NoMoreCardsLeftException{
		if(player.deckSize == 0){
			throw new NoMoreCardsLeftException();
		}

		cardIndex = (int)(Math.random() * player.deckSize);

		return player.getCard(cardIndex);
	}


	private Player updatePlayer(Player player) throws HandIsFullException{
		if( !player.hand.addCard(player.getCard(cardIndex)) ){
			throw new HandIsFullException();
		}

		while( player.arrangeDeck(cardIndex++) );

		player.deckSize--;

		return player;
	}
}
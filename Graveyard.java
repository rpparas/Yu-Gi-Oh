public class Graveyard{
	private Card[] cards;
	private int cardCounter;

	public Graveyard(int deckSize){
		cards = new Card[deckSize];
		cardCounter = 0;
	}

	public void addToGrave(Card card){
		cards[cardCounter++] = card;
	}

	public boolean removeFromGrave(Card card){
		// search for card then move (overwrite / record) index
		// return false if not possible
		return false;
	}

	public int getCardCounter(){
		return cardCounter;
	}

	public Card getCard(int i){
		if(i < 0 || i > cardCounter)
			return null;
		else
			return cards[i];
	}

	public Card getLastCard(){
		if(cardCounter == 0)
			return null;
		else
			return cards[cardCounter-1];
	}
}
public class Hand{
	private Card[] cards;
	private int cardCounter;
	protected final static int HAND_SIZE_MAX = 8;

	public Hand(){
		cardCounter = 0;
		cards = new Card[HAND_SIZE_MAX];

		for(int i = 0; i < cards.length; i++)
			cards[i] = null;
	}

	public boolean addCard(Card card){
		if(cardCounter+1 > HAND_SIZE_MAX){
			return false;
		}

		else{
			cards[cardCounter] = card;
			cardCounter++;
			return true;
		}
	}

	public void removeCard(int i){
		do{
			if(i < cardCounter - 1)
				cards[i] = cards[i + 1];
		}while(i++ < cardCounter - 1);

		cards[i-1] = null;
		cardCounter--;		
	}
	
	public void removeCard(Card card){
		int i;
		
		for(i = 0; i < cardCounter; i++){
			if( cards[i].getCardName() == card.getCardName() ){
				break;
			}
		}

		do{
			if(i < cardCounter - 1)
				cards[i] = cards[i + 1];
		}while(i++ < cardCounter - 1);

		cards[i-1] = null;
		cardCounter--;
	}


	public int getNumberOfCards(){
		return cardCounter;
	}

	public Card getCard(int cardIndex){
		return cards[cardIndex];
	}
}
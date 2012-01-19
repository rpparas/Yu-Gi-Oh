public class Player{
    private Card[] card;
    Hand hand;
	Graveyard graveyard;				// consider declaring graveyard as an object of type Graveyard;
    Field field;						// not sure about this, whether to have it in GamePlay or here

	private String player, password;
	private String drawnCards;
    private int lifePoints, cardIndex;

	boolean isNewPlayer;
    int deckSize;

    private static final int MAX_LIFE_POINTS = 8000;


    public Player(){
		field = new Field();
		graveyard = new Graveyard(deckSize);
		hand = new Hand();

		drawnCards = new String("");
		isNewPlayer = false;

		lifePoints = MAX_LIFE_POINTS;
		deckSize = 40;

		if( player == null ){
   			// 1. load player name, password, deckSize from file
   			// 2. store them in String player, String password
   			// this overrides the deckSize variables above
		}
   	}


    public Player(String player){
		this();

		this.player = player;
		card = new Card[deckSize];
	}


    public Player(String player, char[] pswd){	// for new players
	   this(player);

	   password = new String(pswd);
    }


 	public void setLifePoints(int points){
		if(points == 0)
			lifePoints = 0;

		else
			lifePoints += points;
	}


	public boolean arrangeDeck(int i){
		if(i < deckSize - 1){
			card[i] = card[i + 1];
			return true;
		}
		else
			return false;
	}


	/* Methods Pertaining to (Array of Cards) Deck */
	public void buildDeck(){
		CardList cardList = new CardList();
		int i = 0;

		cardList.generateMonsterCards();										// monster cards comprise 60% of initial deck (index: 0 to 23)
		for(i = 0, cardIndex = 0; i < deckSize * 0.50; i++){
			cardIndex = (int)( Math.random() * cardList.getNumberOfCards() );	// generate random cards
			card[i] = cardList.getCard(cardIndex);
			drawnCards += "monster/" + card[i].getFileName() + ".jpg ";
		}

		cardList.generateMagicCards();											// magic cards comprise 20% of initial deck (index: 32 to 39)
		for(cardIndex = 0; i < deckSize * 0.75; i++){							// i is not initialized since this would overwrite the contents of the array
			cardIndex = (int)( Math.random() * cardList.getNumberOfCards() );	// randomize the card which would be released
			card[i] = cardList.getCard(cardIndex);
			drawnCards += "magic/" + card[i].getFileName() + ".jpg ";

		}

		cardList.generateTrapCards();											// trap cards comprise 20% of initial deck (index: 24 to 31)
		for(cardIndex = 0; i < deckSize; i++){							// i is not initialized since this would overwrite the contents of the array
			cardIndex = (int)( Math.random() * cardList.getNumberOfCards() );	// generate random cards
			card[i] = cardList.getCard(cardIndex);
			drawnCards += "trap/" + card[i].getFileName() + ".jpg ";

		}
	}

	public void loadDeck(){
		// load array of cardIndex from file
		// these cardIndices will be used to retrieve
		// the cards from buildDeck() & some other method

		CardList cardList = new CardList();

		int[] cardIndex = new int[deckSize];		// this loads all card indices to the array

		// for debugging purposes, fill cardIndex with numbers from 1 to 15, with repetition
		for(int j = 0; j < 40; j++){
			cardIndex[j] = j % 16;
		}

		int i = 0;									// index for card array

		cardList.generateMonsterCards();
		while( i < deckSize * 0.60 ){
			card[i++] = cardList.getCard( cardIndex[i] );
		}

		cardList.generateTrapCards();
		while( i < deckSize * 0.80 ){
			card[i++] = cardList.getCard( cardIndex[i] );
		}

		cardList.generateMagicCards();
		while( i < deckSize){
			card[i++] = cardList.getCard( cardIndex[i] );
		}
	}

    /* Methods Pertaining to (Object) Hand */
    
    /*public void buyCards(int cards){
        check for rewardPoints, then subract rewardPoints
        deckSize will increase

        1. display cards
        2. user chooses
        3. check for rewardPoints, confirm
        4. subract rewardPoints
        5. deckSize will increase
        6. save new cards
    }*/

    public void quitGame(){
		lifePoints = 0;
	}

    public boolean saveInfo(){
		// save the following information:
		// 1. player name
		// 2. password
		// 3. deckSize
		// 4. cards (objects)

		// return false is there is an error in saving
		return true;
    }

    // getter methods

    public String getPlayerName(){
        return player;
    }

    public String getPassword(){
        return password;
    }

	public int getLifePoints(){
		return lifePoints;
	}

    public Card getCard(int cardIndex){
		return card[cardIndex];
	}

	public String getDrawnCards(){
		return drawnCards;
	}

	public static int getMaximumLifePoints(){
		return MAX_LIFE_POINTS;
	}
}
// Possible bone of contention on method removeCard();

public class Field{
	private Card[] monster, magicTrap;
	private Card field, fusion;

	private int monsterCounter;
	private int trapCounter;
	private int magicCounter;

	static final String SUMMON = "SUMMON";
	static final String PLAY = "PLAY";
	static final String NOPE = "NOPE";

	static final String FACE_UP = "FACE UP";
	static final String FACE_DOWN = "FACE DOWN";
	static final String DEFENSE = "DEFENSE";

	static final String ACTIVATE = "ACTIVATE";
	static final String SET = "SET";
	static final String CANCEL = "CANCEL";

	public Field(){
		monster = new Card[5];
		magicTrap = new Card[5];

		for(int i = 0; i < 5; i++){
			monster[i] = null;
			magicTrap[i] = null;
		}
	}

	/* This part contains the methods dealing with Monster Cards */
	public boolean setFaceUp(MonsterCard card){
		return (summonMonster(card) ? card.setPosition(FACE_UP) : false);
	}


	public boolean setFaceDown(MonsterCard card){
		return (summonMonster(card) ? card.setPosition(FACE_DOWN) : false);
	}


	public boolean changePosition(MonsterCard card){
		if( card.getPosition().equals(FACE_UP) )
			card.setPosition(FACE_DOWN);
		else
			card.setPosition(FACE_UP);

		return true;
	}


	private boolean summonMonster(MonsterCard card){
		if(card.getStars() > 4)
			return false;

		else if( monsterCounter+1 > 5 )
			return false;

		else{
			monster[monsterCounter++] = card;
			return true;
		}
	}


	public void removeMonster(MonsterCard card){
		int i;

		for(i = 0; i < monster.length; i++){
			if( card.getCardName().equals(monster[i].getCardName()) ){
				break;
			}
		}
		
		do{
			monster[i] = monster[i+1];
		}while(++i < monster.length - 1);

		monster[i-1] = null;
		monsterCounter--;
	}

	/* This part contains the methods dealing with Magic & Trap Cards */
	public boolean activateCard(MagicCard magic, String target){
		MonsterCard monster = null;
		int i;

		for(i = 0; i < monsterCounter; i++){
			if( this.monster[i].getCardName().equals(target) ){
				monster = (MonsterCard)this.monster[i];
				break;
			}
		}

		if( CardList.canEquipMonster(magic, monster) ){
			if( placeCardInField(magic, Field.ACTIVATE) ){
				monster.modifyATK( magic.getATKPlus() );
				monster.modifyDEF( magic.getDEFPlus() );

				this.monster[i] = monster;
				return true;
			}else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	public boolean setCard(Card card){
		return ( placeCardInField(card, Field.SET) ? true : false );
	}

	public boolean placeCardInField(Card card, String position){
		if( getMagicTrapCounter() > 5 )
			return false;

		else{
			card.setPosition(position);
			magicTrap[getMagicTrapCounter()] = card;
			
			if(card instanceof MagicCard)
				magicCounter++;
			else
				trapCounter++;

			return true;
		}
	}

	public void removeMagicTrap(Card card){
		int i;

		for(i = 0; i < monster.length; i++){
			if( card.getCardName().equals(monster[i].getCardName()) ){
				break;
			}
		}
		
		do{
			monster[i] = monster[i+1];
		}while(++i < monster.length - 1);

		monster[i-1] = null;

		if(card instanceof MagicCard)
			magicCounter--;
		else
			trapCounter--;
		
	}

	public Card getMonster(int i){
		if(i > 4)
			return null;

		else
			return monster[i];
	}

	public Card getMagicTrap(int i){
		if(i > 4)
			return null;
		else
			return magicTrap[i];
	}

	public Card getField(){
		if(field == null)
			return null;
		else
			return field;
	}

	public Card getFusion(){
		return fusion;
	}

	public int getMonsterCounter(){
		return monsterCounter;
	}

	public int getMagicCounter(){
		return magicCounter;
	}

	public int getTrapCounter(){
		return trapCounter;
	}

	public int getMagicTrapCounter(){
		return (magicCounter + trapCounter);
	}
}
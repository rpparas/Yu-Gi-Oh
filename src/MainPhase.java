import exception.*;

public class MainPhase extends GamePlay{
	private Player active;
	private Player passive;

	private boolean hasSummoned;
	private int activePlayer;
	private int option;

	static boolean isComplete;


	public MainPhase(Player[] players, int active){
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

	public void playMonsterCard(MonsterCard monster, int hand){
		try{
			if( hasSummoned ){
				throw new NewSummonException();
			}
			else if( monster.getStars() < 5 ){
				if( summonMonster(monster) ){
					active.hand.removeCard(hand);
				}	
			}
			else{
				int sacrificeNum = (int)(monster.getStars()-4)/2 + 1;

				if( active.field.getMonsterCounter() == 0 )
					throw new SacrificeException();

				else if( active.field.getMonsterCounter() < sacrificeNum )
					throw new SacrificeException(sacrificeNum);
				else{
					sacrificeMonster(sacrificeNum);
					
					if( summonMonster(monster) ){
						active.hand.removeCard(hand);						
					}
				}
			}
		}catch(GameException e){
			e.output();
		}
	}
	
	private boolean summonMonster(MonsterCard monster){
		option = CardViewer.showOption( monster );

		if(option == 0){
			hasSummoned = active.field.setFaceUp( monster );
		}
		else if(option == 1){
			hasSummoned = active.field.setFaceDown( monster );
		}

		return hasSummoned;
	}
	
	private void sacrificeMonster(int sacrificeNum){
		option = CardViewer.showOption( sacrificeNum );
		MonsterCard[] monsters;

		if(option == 0){
			for(int counter = 0; counter < sacrificeNum; counter++){
				String option = FieldGUI.makeSelection( getMonsterCards(), sacrificeNum );

				monsters = new MonsterCard[ active.field.getMonsterCounter() ];

				for(int i = 0; i < active.field.getMonsterCounter(); i++){
					monsters[i] = (MonsterCard)active.field.getMonster(i);

					if( monsters[i].getCardName().equals(option) ){
						active.field.removeMonster( monsters[i] );
						break;
					}
				}
			}
		}
	}

	public void playMagicCard(MagicCard magic, int hand){
		try{
			option = CardViewer.showOption( magic );

			if(option == 0){
				if( magic.getCardTypes(0).equals("equip") ){
					if( equipMonster(magic) == 0 ){
						throw new EquipException(false);
					}else if( equipMonster(magic) == 1 ){
						active.hand.removeCard(hand);
					}
				}
			}else if(option == 1){
				if( !active.field.setCard(magic) )
					throw new SetCardException();
				else
					active.hand.removeCard(hand);
			}
		}catch(GameException e){
			e.output();
		}
	}

	public void playTrapCard(TrapCard trap, int hand){
		try{
			option = CardViewer.showOption( trap );
			
			if(option == 0){
				
			}
			
		}catch(GameException e){
			e.output();
		}

	}

	private int equipMonster(MagicCard magic){
		String target = CardViewer.showOption( getMonsterCards() );
		
		if( target == null ){
			return -1;
		}
		else if( !active.field.activateCard(magic, target) ){
			return 0;
		}
		else 
			return 1;
	}
	
	private MonsterCard[] getMonsterCards(){
		int numMonster = active.field.getMonsterCounter();
		MonsterCard[] monsters = new MonsterCard[numMonster];

		for(int i = 0; i < numMonster; i++){
			monsters[i] = (MonsterCard)active.field.getMonster(i);
		}

		return monsters;
	}

	public boolean hasSummoned(){
		return hasSummoned;
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
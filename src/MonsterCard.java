public class MonsterCard extends Card{
    private Effect effect;
	private int stars;
    private int ATK, DEF;
    private String fightStance;

    public MonsterCard(String name, String[] type, String fileName, int stars, int ATK, int DEF){
        super(name, type, fileName);

        this.stars = stars;
       	this.ATK = ATK;
       	this.DEF = DEF;
    }

    public MonsterCard(String name, String[] type, String fileName, String effect, int stars, int ATK, int DEF){
		this(name, type, fileName, stars, ATK, DEF);

		this.effect = new Effect(effect);
	}

	// to activate effect, invoke activateEffect() from superclass

	public void modifyATK(int value){
		ATK += value;
	}
	
	public void modifyDEF(int value){
		DEF += value;			
	}
	
	public void changeFS(){
		if( fightStance.equals("attack") )
			fightStance = "defense";
		else
			fightStance = "attack";
	}

	public int getStars(){
		return stars;
	}


	public int getATK(){
		return ATK;
	}


	public int getDEF(){
		return DEF;
	}
}

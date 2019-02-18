public class TrapCard extends Card{
    private int damage;
    private int targetNum;

    boolean isChangeLP;
    boolean isDrawCard;
    boolean isRemoveOppCard;
    boolean isCancelAttack;


    public TrapCard(String name, String[] type, String fileName){
        super(name, type, fileName);
	}

    public TrapCard(String name, String[] type, String fileName, float value){
		this(name, type, fileName);

        damage = (int)value;
	}

    public TrapCard(String name, String[] type, String fileName, int number){
		this(name, type, fileName);

        targetNum = number;
	}

	public int getDamage(){
		return damage;
	}
}
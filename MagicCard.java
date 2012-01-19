public class MagicCard extends Card{
    private int ATKPlus, DEFPlus;
    private int lifePointsPlus;
    private int targetNum;


    public MagicCard(String name, String[] type, String fileName){
        super(name, type, fileName);
	}

    public MagicCard(String name, String[] type, String fileName, float lpPlus){
		this(name, type, fileName);

        lifePointsPlus = (int)lpPlus;
	}

    public MagicCard(String name, String[] type, String fileName, int number){
		this(name, type, fileName);

        targetNum = number;
	}

    public MagicCard(String name, String[] type, String fileName, int ATKPlus, int DEFPlus){
		this(name, type, fileName);

        this.ATKPlus = ATKPlus;
        this.DEFPlus = DEFPlus;
    }

	public int getATKPlus(){
		return ATKPlus;
	}

	public int getDEFPlus(){
		return DEFPlus;
	}

	public int getLifePointsPlus(){
		return lifePointsPlus;
	}
}
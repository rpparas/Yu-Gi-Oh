public class Card{
 	//private Image image;

    private String cardName, cardType;
    private String[] cardTypes;
 	private String fileName;

 	private String position;

  	public Card(String name, String[] type, String fName){
    	cardName = name;
        cardTypes = type;
        fileName = fName;
    }

    public Card(String name, String type, String fName){
		cardName = name;
		cardType = type;
		fileName = fName;
	}


    public boolean setPosition(String position){
		this.position = position;

		return true;
	}

	public String getCardName(){
		return cardName;
	}


	public String[] getCardTypes(){
		return cardTypes;
	}

	public String getCardTypes(int i){
		return cardTypes[i];
	}

	public String getCardType(){
		return cardType;
	}


	public String getFileName(){
		return fileName;
	}

	public String getPosition(){
		if(position == null)
			return null;
		else
			return position;
	}
}
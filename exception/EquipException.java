package exception;

public class EquipException extends GameException{
	public EquipException(boolean value){
		message = "This card cannot be equipped to that monster.";
		title = "Equipment Incompatible";
	}

	public EquipException(int number){
		message = "No monsters in field to equip this card on.";
		title = "Card Not Usable";
	}
}
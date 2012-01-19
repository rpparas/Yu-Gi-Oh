public class Effect{
	private String[] keyword;

    boolean isDrawCard;
	boolean isModifyATK;
	boolean isModifyDEF;
	boolean isSacrifice;

	public Effect(String keywords) {
		process(keywords);
    }

    public void process(String keywords){
		// use tokenizer here then store results in keyword[]
	}
}

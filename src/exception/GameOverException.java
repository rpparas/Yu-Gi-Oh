package exception;

public class GameOverException extends GameException{
	public GameOverException(boolean isSurrender){
		if(isSurrender){
			message = "You lose!  Your LifePoints is considered zero.";
			title = "Game Over! -- Player Surrenders";
		}else{
			message = "In the ancient world, you are considered dead!";
			title = "Game Over! -- Zero LifePoints";
		}
	}

	public GameOverException(){
	}
}
//Really simple method just so a human can 'run' this unfinished program
//untested


package manager;

import manager.RoundManager;

public class GameManager {

	RoundManager rounds;
	
	public GameManager(){
		rounds = new RoundManager();
	}
	
	public static void main(String[] args){
		
		GameManager pokerGame = new GameManager();
		while (true){
			try{
				pokerGame.rounds.collectPlayerIDs();
				while (true){
					try{
						pokerGame.rounds.collectHands();
					}catch (IllegalArgumentException ex){
						System.out.println(ex.getMessage());
					}
				}
			}catch(IllegalArgumentException ex){
				System.out.println(ex.getMessage());
			}
		}
	
	}
	
}

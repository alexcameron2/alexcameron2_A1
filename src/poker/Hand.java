package poker;

import poker.Card;

public class Hand {

	private Card[] cards;
	private String owner;
	
	public Hand(String values){
		
	}
	
	//Getters
	public Card[] getCards(){
		return this.cards;
	}
	
	public String getOwner(){
		return this.owner;
	}
}

package poker;

import poker.Card;

public class Hand {

	private Card[] cards = new Card[5];
	private String owner;
	
	//Constructor
	public Hand(String values){
		String[] splitString = values.split("\\s+");
		if (! (splitString.length == 6)){
			throw new IllegalArgumentException("Arguments must be in form: ID RankSuit RankSuit RankSuit RankSuit RankSuit");
		}
		try{
			for (int i=1;i<splitString.length;i++){
				cards[i-1] = new Card(splitString[i]);
			}
		}catch(IllegalArgumentException e){
			System.err.println("Illegal card argument for a card: " + e.getMessage());
			throw e;
		}
		owner = splitString[0]; //It can be literally anything..for now
	}
	
	//Getters
	public Card[] getCards(){
		return this.cards;
	}
	
	public String getOwner(){
		return this.owner;
	}
}

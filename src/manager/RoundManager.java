package manager;
import java.util.Scanner;

import poker.Hand;
import poker.Card;

public class RoundManager {
	
	private String[] validPlayers;
	private Hand[] hands;
	private int index; //how many hands are committed
	
	public RoundManager(){
		index = 0;
	}
	
	//Method asks the user to enter the ID's of every player participating this round
	//PlayerIDs can be any string..for now.
		//But they are input as a single string and delimited by white space.
	public void collectPlayerIDs(){
		Scanner userInput = new Scanner(System.in);
		String playerIDs;
		int l;
		
		//Get the playerIDs as one string from the user..
		System.out.print("\nEnter the playerIDs for this round, seperated by spaces: ");
		playerIDs = userInput.nextLine();
		
		//Split the string by white space..
		String[] splitString = playerIDs.split("\\s+");
		l = splitString.length;
		
		if(l < 2){
			throw new IllegalArgumentException("Number of player ID's entered must be at least two.");
		}else if (l > 4){
			throw new IllegalArgumentException("Number of player ID's entered must be less than 5.");
		}
		
		//Assign the input values to the validPlayers list
		validPlayers = new String[l];
		for(int i=0;i<l;i++){
			validPlayers[i] = splitString[i];
		}
		hands = new Hand[validPlayers.length];
	}
	
	//Method that collects the user input for all the player hands
	public void collectHands(){
		Scanner userInput = new Scanner(System.in);
		String handString;
		Hand tempHand;
		
		//For every player in the validPlayers list
		for(int i=0;i<validPlayers.length;i++){
			System.out.print("\nEnter Hand in the form: Player RankSuit RankSuit RankSuit RankSuit RankSuit \n:: ");
			handString = userInput.nextLine();
			
			//Check the syntax on all the cards
			try{
				tempHand = new Hand(handString);
			}catch (IllegalArgumentException ex){
				throw ex;
			}
			
			//Check if the given ID is valid for this round
			if (!(isValidPlayer(tempHand.getOwner()))){
				throw new IllegalArgumentException("Invalid player ID entered for hand.");
			}
			
			//Check if the given ID has already been entered
			for(i=0;i<index;i++){
				if(tempHand.getOwner().equals(hands[i].getOwner())){
					throw new IllegalArgumentException("Player ID entered already has a hand.");
				}
			}
			
			//Check if any of the cards are the same or owned by someone else
			if (! (isValidHand(tempHand))){
				throw new IllegalArgumentException("One or more Cards entered is already in a player's hand!.");
			}
			
			//At this point the card within the hand for the player are all valid
			hands[index++] = tempHand;
		}
	}
	
	//Getters
	public String[] getPlayerIDs(){
		return validPlayers;
	}
	
	//Helpers
	private boolean isValidPlayer(String player){
		boolean value = false;
		for(int i=0;i<validPlayers.length;i++){
			if (player.equals(validPlayers[i])){
				value = true;
				break;
			}
		}
		return value;
	}
	
	private boolean isValidHand(Hand aHand){
		boolean value = true;
		Card[] potentialCards = aHand.getCards();
		Card[] commitedCards;
		
		//Compare cards to themselves
		for(int foo=0;foo<5;foo++){
			for (int bar=foo+1;bar<5;bar++){
				if((foo != bar) && (potentialCards[foo] == potentialCards[bar])){
					return false; //had duplicate within own hand
				}
			}
		}
		
		for(int i=0;i<index;i++){ //For every hand input in the system
			commitedCards = hands[i].getCards();
			for(int j=0;j<5;j++){		//For every card in those hands
				for(int k=0;k<5;k++){	//Compare them to every potential card
					if(potentialCards[j].equals(commitedCards[k])){
						//we found one hand not valid
						return false;
					}
				}
			}
		}
		return value;
	}
}

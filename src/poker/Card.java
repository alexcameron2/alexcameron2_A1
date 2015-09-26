package poker;
import java.util.*;

public class Card {
	
	//Each card consists of a numerical value or rank and a suit
	private String rank,suit;
	
	private static Set<String> suits;
	private static Map<String, Integer> ranks;
	static {
		suits = new HashSet<String>();
		ranks = new HashMap<String, Integer>();
		
		suits.add("clubs");
		suits.add("spades");
		suits.add("hearts");
		suits.add("diamonds");
		
		ranks.put("ace", 1);
		ranks.put("two", 2);
		ranks.put("three", 3);
		ranks.put("four", 4);
		ranks.put("five", 5);
		ranks.put("six", 6);
		ranks.put("seven", 7);
		ranks.put("eight", 8);
		ranks.put("nine", 9);
		ranks.put("ten", 10);
		ranks.put("jack", 11);
		ranks.put("queen", 12);
		ranks.put("king", 13);
	}
	
	//Constructor
	public Card(String rankSuit){
		String[] splitString = rankSuit.split("(?=\\p{Upper})");
		rank = splitString[0].toLowerCase();
		suit = splitString[1].toLowerCase();
	}
	
	//Getters
	public int getRank(){
		return ranks.get(this.rank);
	}
	
	public String getSuit(){
		return this.suit;
	}
	
	
	
	
}
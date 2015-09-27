package poker;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Card{
	
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
		String r, s;
		String[] splitString = rankSuit.split("(?=\\p{Upper})");
		if (!(splitString.length == 2)){
			throw new IllegalArgumentException("Card input must be in the form: RankSuit");
		}
		r = splitString[0].toLowerCase();
		if (!(ranks.containsKey(r))){
			throw new IllegalArgumentException("Rank was input incorrectly.: " + r);
		}
		s = splitString[1].toLowerCase();
		if (! (suits.contains(s))){
			throw new IllegalArgumentException("Suit was input incorrectly.: " + s);
		}
		this.suit = s;
		this.rank = r;
		
	}
	
	//Overides
	@Override
	public boolean equals(Object other){
		if (other == null) { return false;}
		if (!(other instanceof Card)){return false;}		
		if (other == this) { return true; }
		
		Card temp = (Card)other;
		if ((temp.getRank() == this.getRank()) && (temp.getSuit().equals(this.suit))){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString(){
		return this.rank + this.suit;
	}
	
	//Getters
	public int getRank(){
		return ranks.get(this.rank);
	}
	
	public String getRankAsString(){
		return this.rank;
	}
	
	public String getSuit(){
		return this.suit;
	}
		
}
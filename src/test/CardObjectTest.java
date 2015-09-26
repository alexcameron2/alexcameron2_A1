package test;

import org.junit.Test;

import junit.framework.Assert;
import poker.Card;

@SuppressWarnings("deprecation")
public class CardObjectTest {

	@Test
	public void create_card_and_return_rank(){
		//Given
		String rankSuit = "TwoClubs";
		
		//When
		Card testCard = new Card(rankSuit);
		
		//Then
		Assert.assertTrue("The rank of the card should be 2", testCard.getRank() == 2);
				
	}
	@Test
	public void create_card_and_return_suit(){
		//Given
		String rankSuit = "AceHearts";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertTrue("Card suit should be Hearts", testCard.getSuit().equals("hearts"));
	}
	
}

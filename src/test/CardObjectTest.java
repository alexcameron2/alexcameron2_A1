package test;

import org.junit.Test;
import org.junit.Assert;
import poker.Card;

public class CardObjectTest {
	@Test
	//Test to prove that a Card can be created in the system with a given rank
	public void create_card_and_return_rank(){
		//Given
		String rankSuit = "TwoClubs";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertTrue ("The rank of the card should be 2", testCard.getRank() == 2);
				
	}
	
	@Test
	//Test to prove that a Card can be created in the system with a given suit
	public void create_card_and_return_suit(){
		//Given
		String rankSuit = "AceHearts";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertTrue("Card suit should be Hearts", testCard.getSuit().equals("hearts"));
	}
	
	@Test
	//Test to prove that a Card will not be created if given a bad Rank
	public void create_card_with_bad_rank(){
		//Given
		String rankSuit = "JesterClubs";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertNull(testCard);
	}
	
	@Test
	//Test to prove that a Card will not be created if given a bad suit
	public void create_card_with_bad_suit(){
		//Given
		String rankSuit = "FourAnkhs";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertNull(testCard);
	}	
	
	@Test
	//Test to prove that a Card will not be created if given an invalid RankSuit format
	public void create_card_with_bad_format(){
		//Given
		String rankSuit = "ThReeSPadEs";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertNull(testCard);
	}
	
	@Test
	//Test to prove that a Card will not be created with garbage input
	public void create_card_with_bad_input(){
		//Given
		String rankSuit = "8YGLL YY1sfv97 005";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertNull(testCard);
	}
	
	@Test
	//Test to prove that a Card will not be created given a lowercase string
	public void create_card_with_lowercase(){
		//Given
		String rankSuit = "fivediamonds";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertNull(testCard);
	}
	
	@Test
	//Test to prove that a Card will not be created given a uppercase string
	public void create_card_with_uppercase(){
		//Given
		String rankSuit = "TWOSPADES";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertNull(testCard);
	}
	
	@Test
	//Test to prove a card will not be created when given an empty string
	public void create_card_with_empty(){
		//Given
		String rankSuit = "";
		//When
		Card testCard = new Card(rankSuit);
		//Then
		Assert.assertNull(testCard);
	}
}

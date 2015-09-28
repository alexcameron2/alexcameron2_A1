package test;

import org.junit.Test;
import org.junit.Assert;
import poker.Card;

/*Tests were modified after initial pass due to a slight flaw.
 * Exception was tested for..but no assert was being done on the exception message.
 */

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
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that a Card will not be created if given a bad Rank
	public void create_card_with_bad_rank(){
		//Given
		String rankSuit = "JesterClubs";
		String expected = "Rank was input incorrectly.";
		//When
		try{
			Card testCard = new Card(rankSuit);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for rank", expected.equals(ex.getMessage()));
			throw ex;
		}
		//Then there is an IllegalArgumentException for Card.rank
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that a Card will not be created if given a bad suit
	public void create_card_with_bad_suit(){
		//Given
		String expected = "Suit was input incorrectly.";
		String rankSuit = "FourAnkhs";
		//When
		try{
			Card testCard = new Card(rankSuit);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for suit", expected.equals(ex.getMessage()));
			throw ex;
		}
		//Then there is an IllegalArgumentException for suit
	}	
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that a Card will not be created if given an invalid RankSuit format
	public void create_card_with_bad_format(){
		//Given
		String expected = "Card input must be in the form: RankSuit";
		String rankSuit = "ThReeSPadEs";
		//When
		try{
			Card testCard = new Card(rankSuit);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for format", expected.equals(ex.getMessage()));
			throw ex;
		}
		//Then there is an IllegalArgumentException for RankSuit
	}
	
	@Test(expected = IllegalArgumentException.class)
	//Test to prove that a Card will not be created with garbage input
	public void create_card_with_bad_input(){
		//Given
		String expected = "Card input must be in the form: RankSuit";
		String rankSuit = "  00088GDV ddDSs  w81791 S";
		//When
		try{
			Card testCard = new Card(rankSuit);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for format", expected.equals(ex.getMessage()));
			throw ex;
		}
		//Then there is an IllegalArgumentException for RankSuit
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that a Card will not be created given a lowercase string
	public void create_card_with_lowercase(){
		//Given
		String expected = "Card input must be in the form: RankSuit";
		String rankSuit = "fivediamonds";
		//When
		try{
			Card testCard = new Card(rankSuit);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for format", expected.equals(ex.getMessage()));
			throw ex;
		}
		//Then there is an IllegalArgumentException for RankSuit
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that a Card will not be created given a uppercase string
	public void create_card_with_uppercase(){
		//Given
		String expected = "Card input must be in the form: RankSuit";
		String rankSuit = "TWOSPADES";
		//When
		try{
			Card testCard = new Card(rankSuit);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for format", expected.equals(ex.getMessage()));
			throw ex;
		}
		//Then there is an IllegalArgumentException for RankSuit
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove a card will not be created when given an empty string
	public void create_card_with_empty(){
		//Given
		String expected = "Card input must be in the form: RankSuit";
		String rankSuit = "";
		//When
		try{
			Card testCard = new Card(rankSuit);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for format", expected.equals(ex.getMessage()));
			throw ex;
		}
		//Then there is an IllegalArgumentException for RankSuit
	}
}

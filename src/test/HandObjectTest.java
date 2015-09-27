package test;

import org.junit.Assert;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class HandObjectTest {

	@Test
	//Test to prove that a hand can be input into the system with the expected cards
	public void create_hand_and_return_cards(){
		//IF
		Card[] expected = new Card[5];
		Card[] actual;
		expected[0] = new Card("TwoHearts");
		expected[1] = new Card("FourDiamonds");
		expected[2] = new Card("KingSpades");
		expected[3] = new Card("NineSpades");
		expected[4] = new Card("AceHearts");
		
		String testString = "00517 TwoHearts FourDiamonds KingSpades NineSpades AceHearts";
		//WHEN
		Hand testHand = new Hand(testString);
		actual = testHand.getCards();
		//THEN
		Assert.assertArrayEquals("Cards returned by the hand are the same as the manually entered expected cards: " , expected, actual);
		
	}	
	
	@Test
	//Test to prove that a hand can input into the system with the expected owner
	public void create_hand_and_return_owner(){
		//IF
		String testString = "01876 FiveClubs SixClubs SevenClubs EightClubs NineClubs";
		//WHEN
		Hand testHand = new Hand(testString);
		//THEN
		Assert.assertTrue("Owner of the testHand should be 01876", testHand.getOwner().equals("01876"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that a hand will not be created when given too few arguments
	public void create_hand_too_few_arguments(){
		//IF
		String testString = "01876 FiveClubs SevenClubs EightClubs NineClubs";
		//WHEN
		Hand testHand = new Hand(testString);
		//THEN there is an IllegalArgumentException for values;
	}
	
	@Test (expected = IllegalArgumentException.class) 
	public void create_hand_empty(){
		//IF
		String testString = "";
		//WHEN
		Hand testHand = new Hand(testString);
		//THEN there is an IllegalArgumentException for values
	}	
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that a hand will not be created given too many arguments
	public void create_hand_and_too_many_arguments(){
		//IF
		String testString = "09178 AceSpades JackClubs JackHearts JackDiamonds JackSpades TenClubs";
		//WHEN
		Hand testHand = new Hand(testString);
		//THEN there is an IllegalArgumentException for values
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void create_hand_with_invalid_card(){
		//IF
		String testString = "076517 AceClubs AceHearts AceCats AceSpades AceDiamonds";
		//WHEN
		Hand testHand = new Hand(testString);
		//THEN there is an IllegalArgumentException for the card
	}
	
}

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
		Card one = new Card("TwoHearts");
		Card two = new Card("FourDiamonds");
		Card three = new Card("KingClubs");
		Card four = new Card("NineSpades");
		Card five = new Card("AceHearts");
		Card[] cards = new Card[]{one, two, three, four, five};
		
		String testString = "00517 TwoHearts FourDiamonds KingClubs NineSpades AceHearts";
		//WHEN
		Hand testHand = new Hand(testString);
		//THEN
		Assert.assertArrayEquals("Cards returned by hand where cards input manually", cards, testHand.getCards());
		
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
		String testString = "076517 AceClubs, AceHearts, AceCats, AceSpades, AceDiamonds";
		//WHEN
		Hand testHand = new Hand(testString);
		//THEN there is an IllegalArgumentException for the card
	}
	
}

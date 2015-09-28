package test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import manager.RoundManager;

public class RoundManagerObjectTest {
	@Test
	//Test to prove that the RoundManager can be given player IDs by a user
	public void can_get_player_ids(){
		//IF
		String[] actualIDs;
		String[] expectedIDs = new String[]{"Steve", "00519", "R1-OH!-Seven"};
		RoundManager testRM = new RoundManager();
		//WHEN
		
		//Setup simulated input from System.in..most robust testing
		String userInput = "Steve 00519 R1-OH!-Seven";
		InputStream stdIn = System.in;
		try{
			System.setIn(new ByteArrayInputStream(userInput.getBytes()));
		
			//Now myScanner.nextLine() == userInput and can be tested by RoundManager
			testRM.collectPlayerIDs();
			
		}finally{
			System.setIn(stdIn);
		}
		//THEN
		actualIDs = testRM.getPlayerIDs(); 
		Assert.assertArrayEquals("Player IDs must be.: Steve, 00519, R1-OH!-Seven" , expectedIDs, actualIDs);		
	}
	
	@Test
	//Test proves that the player IDs entered by the user are counted properly
	public void can_get_number_of_players(){
		//IF
		String[] players;
		RoundManager testRM = new RoundManager();
		String userInput = "DoggyDawg User Morp";
		//WHEN
		InputStream stdIn = System.in;
		try{
			System.setIn(new ByteArrayInputStream(userInput.getBytes()));
					
			//Now Scanner.nextLine() == userInput and can be tested by RoundManager
			testRM.collectPlayerIDs();
					
		}finally{
			System.setIn(stdIn);
		}				
		//THEN
		players = testRM.getPlayerIDs();
		Assert.assertTrue("The number of players should be 3.: " + players, players.length == 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that too few playerIDs will be rejected by the RoundManager
	public void too_few_player_IDs(){
		//IF
		RoundManager testRM = new RoundManager();
		String userInput = "DoggyDawgUserMorp";
		String expected = "Number of player ID's entered must be at least two.";
		//WHEN
		InputStream stdIn = System.in;
		try{
			System.setIn(new ByteArrayInputStream(userInput.getBytes()));
					
			//Now Scanner.nextLine() == userInput and can be tested by RoundManager
			testRM.collectPlayerIDs();
					
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for too few players", ex.getMessage().equals(expected));
			throw ex;
		}
		finally{
			System.setIn(stdIn);
		}				
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that too many playerIDs will be rejected by the RoundManager
	public void too_many_player_IDs(){
		//IF
		RoundManager testRM = new RoundManager();
		String userInput = "DoggyDaw g UserMorp 0999 extraa";
		String expected = "Number of player ID's entered must be less than 5.";		
		//WHEN
		InputStream stdIn = System.in;
		try{
			System.setIn(new ByteArrayInputStream(userInput.getBytes()));
					
			//Now Scanner.nextLine() == userInput and can be tested by RoundManager
			testRM.collectPlayerIDs();
					
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception was thrown for too many players", ex.getMessage().equals(expected));
			throw ex;
		}
		finally{
			System.setIn(stdIn);
		}				
		//THEN there should be an IllegalArgumentException for RoundManager
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that the RoundManager will not accept a hand with an invalid player ID
	public void create_hand_with_invalid_id(){
		//IF
		String expected = "Invalid player ID entered for hand.";
		RoundManager testRM = new RoundManager();
		String userInput = "Meepo LoneDruid Jaws" + "\nJeeves AceSpades TwoHearts FourClubs JackDiamonds TwoClubs";
		//WHEN
		InputStream stdIn = System.in;
		System.setIn(new ByteArrayInputStream(userInput.getBytes()));
					
		//Now Scanner.nextLine() == userInput and can be tested by RoundManager
		testRM.collectPlayerIDs();
		//AND
		try{
			testRM.collectHands();
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception for invalid ID", ex.getMessage().equals(expected));
			throw ex;
		}finally{
			System.setIn(stdIn);
		}
		//THEN there is an IllegalArgumentException thrown for RoundManager
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that the RoundManager will not accept two hands with the same player ID  
	public void create_hand_with_duplicate_id(){
		//IF
		String expected = "Player ID entered already has a hand.";
		RoundManager testRM = new RoundManager();
		String userInput = "Meepo LoneDruid Jaws" + "\nMeepo AceSpades TwoHearts FourClubs JackDiamonds TwoClubs" + "\nMeepo AceSpades TwoHearts FourClubs JackDiamonds TwoClubs" ;
		//WHEN
		InputStream stdIn = System.in;
		System.setIn(new ByteArrayInputStream(userInput.getBytes()));
					
		//Now Scanner.nextLine() == userInput and can be tested by RoundManager
		testRM.collectPlayerIDs();
		//AND
		try{
			testRM.collectHands();
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception for ID existing", ex.getMessage().equals(expected));
			throw ex;
		}finally{
			System.setIn(stdIn);
		}
		//THEN there is an IllegalArgumentException thrown for RoundManager
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that the RoundManager will not accept a hand that contains duplicate cards
	public void create_hand_with_duplicate_cards(){
		//IF
		String expected = "One or more Cards entered is already in a player's hand!.";
		RoundManager testRM = new RoundManager();
		String userInput = "Meepo LoneDruid Jaws" + "\nMeepo AceSpades TwoHearts FourClubs JackDiamonds AceSpades";
		//WHEN
		InputStream stdIn = System.in;
		System.setIn(new ByteArrayInputStream(userInput.getBytes()));
					
		//Now Scanner.nextLine() == userInput and can be tested by RoundManager
		testRM.collectPlayerIDs();
		//AND
		try{
			testRM.collectHands();
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception for Card existing", ex.getMessage().equals(expected));
			thow ex;
		}finally{
			System.setIn(stdIn);
		}
		//THEN there is an IllegalArgumentException thrown for RoundManager
	}
	
	@Test (expected = IllegalArgumentException.class)
	//Test to prove that the RoundManager will not accept a hand that has a card owned by another player
	public void create_hand_with_a_duplicate_card(){
		//IF
		String expected = "One or more Cards entered is already in a player's hand!.";
		RoundManager testRM = new RoundManager();
		String userInput = "Meepo LoneDruid Jaws" + "\nMeepo AceSpades TwoHearts FourClubs JackDiamonds TwoClubs" + "\nJaws AceClubs TwoHearts FiveClubs SixDiamonds NineClubs" ;
		//WHEN
		InputStream stdIn = System.in;
		System.setIn(new ByteArrayInputStream(userInput.getBytes()));
					
		//Now Scanner.nextLine() == userInput and can be tested by RoundManager
		testRM.collectPlayerIDs();
		//AND
		try{
			testRM.collectHands();
		}catch(IllegalArgumentException ex){
			Assert.assertTrue("Exception for Card existing", ex.getMessage().equals(expected));
			throw ex;
		}finally{
			System.setIn(stdIn);
		}
		//THEN there is an IllegalArgumentException thrown for RoundManager		
	}
}

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
//Scanner myScanner = new Scanner(System.in);
			
			//Now myScanner.nextLine() == userInput and can be tested by RoundManager
			testRM.requestPlayerIDs();
			
		}finally{
			System.setIn(stdIn);
		}
		//THEN
		actualIDs = testRM.getPlayerIDs(); 
		Assert.assertArrayEquals("Player IDs must be.: Steve, 00519, R1-OH!-Sevem" , expectedIDs, actualIDs);		
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
//Scanner myScanner = new Scanner(System.in);
					
			//Now myScanner.nextLine() == userInput and can be tested by RoundManager
			testRM.requestPlayerIDs();
					
		}finally{
			System.setIn(stdIn);
		}				
		//THEN
		players = testRM.getPlayerIDs();
		Assert.assertTrue("The number of players should be 3.:", players.length == 3);
	}	
	
	@Test
	//Test to prove that the RoundManager will not accept a hand with an invalid player ID
	public void create_hand_with_invalid_id(){
		//IF
		//WHEN
		//THEN
	}
	
	@Test
	//Test to prove that the RoundManager will not accept two hands with the same player ID  
	public void create_hand_with_duplicate_id(){
		//IF
		//WHEN
		//THEN
	}
	
	@Test
	//Test to prove that the RoundManager will not accept a hand that contains duplicate cards
	public void create_hand_with_duplicate_cards(){
		//IF
		//WHEN
		//THEN
	}
	
	@Test
	//Test to prove that the RoundManager will not accept a hand that has a card owned by another player
	public void create_hand_with_a_duplicate_card(){
		
	}
}

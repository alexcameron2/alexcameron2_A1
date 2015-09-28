package manager;
import java.util.Scanner;
import poker.Hand;

public class RoundManager {
	
	private String[] validPlayers;
	private Hand[] hands;
	
	public RoundManager(){
		
	}
	
	//Method asks the user to enter the ID's of every player participating this round
	//PlayerIDs can be any string..for now.
		//But they are input as a single string and delimited by white space.
	public void requestPlayerIDs(){
		Scanner userInput = new Scanner(System.in);
		String playerIDs;
		
		//Get the playerIDs as one string from the user..
		System.out.print("\nEnter the playerIDs for this round, seperated by spaces: ");
		playerIDs = userInput.nextLine();
		
		//Split the string by white space..
		String[] splitString = playerIDs.split("\\s+");
		
		//Assign the input values to the validPlayers list
		validPlayers = new String[splitString.length];
		for(int i=0;i<splitString.length;i++){
			validPlayers[i] = splitString[i];
		}
		
	}
	
	//Getters
	public String[] getPlayerIDs(){
		return validPlayers;
	}
}

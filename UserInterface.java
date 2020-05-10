/**
 * Purpose: Represents the user interface that displays the game information
 * Author: Thomas Liu
 * Created On: 5 June 2019
 */

import java.util.Scanner;

public class UserInterface 
{
	//Fields used to represent names, positions, and anything required to start game
	private static String activation;
	private static String firstPlayer;
	private static String secondPlayer;
	private static int firstPos = 1;
	private static int secondPos = 1;
	private static String firstRoll;
	private static String secondRoll;
	private static int dice;
	private static long startTime;
	
	//Method that represents the interface carried out during the game process
	public static void gameInterface()
	{
		Scanner keyboard = new Scanner(System.in);
		
		//User interface used to activate the dice roll for first player
		System.out.println(firstPlayer + ", please press 'r' to roll dice:");
		firstRoll = keyboard.nextLine();
			
		while (!firstRoll.equals("r"))
		{
			System.out.println("You did not enter the expected letter! Please"
					+ " try again:");
			firstRoll = keyboard.nextLine();
		}
		if (firstRoll.equals("r"))
		{
			//Takes in the value of dice rolled and new position by calling methods
			dice = GameAction.rollingDice();
			firstPos = GameAction.playerMovement(firstPos, dice);
				
			//Prints out the information of first player's movement on the interface
			System.out.println(firstPlayer + " rolled a " + dice + "! "
					+ firstPlayer + " is now at position " + firstPos);
		}
			
		//The case in which the first player wins the game
		if (firstPos == 100)
		{
			//Calculates time taken by subtracting the start time by current time
			long totalTime = System.currentTimeMillis() - startTime;
				
			//Retrieves the final value of time taken that is converted to minutes
			String time = GameStructure.gameTiming(totalTime);
				
			//Prints out the message addressing the outcomes of the game
			System.out.println("Congratulations " + firstPlayer + ", you won"
					+ " the game in " + time + " minutes!"
					+ "\nSorry " + secondPlayer + ", you lose");
				
			//Calls scoreKeeping class that deals with the current score board
			GameStructure.scoreKeeping(1, firstPlayer, secondPlayer);
				
			return;
		}
			
		//User interface used to activate the dice roll for second player
		System.out.println(secondPlayer + ", press 'r' to roll dice:");
		secondRoll = keyboard.nextLine();
			
		while (!secondRoll.equals("r"))
		{
			System.out.println("You did not enter the expected letter! Please"
					+ " try again:");
			secondRoll = keyboard.nextLine();
		}
		if (secondRoll.equals("r"))
		{
			//Takes in the value of dice rolled and new position by calling methods
			dice = GameAction.rollingDice();
			secondPos = GameAction.playerMovement(secondPos, dice);
				
			//Prints out the information of second player's movement on the interface
			System.out.println(secondPlayer + " rolled a " + dice + "! "
					+ secondPlayer + " is now at position " + secondPos);
		}
			
		//The case in which the second player wins the game
		if (secondPos == 100)
		{
			//Calculates time taken by subtracting the start time by current time
			long totalTime = System.currentTimeMillis() - startTime;
				
			//Retrieves the final value of time taken that is converted to minutes
			String time = GameStructure.gameTiming(totalTime);
				
			//Prints out the message addressing the outcomes of the game
			System.out.println("Congratulations " + secondPlayer + ", you won"
					+ " the game in " + time + " minutes!"
					+ "\nSorry " + firstPlayer + ", you lose");
				
			//Calls scoreKeeping class that deals with the current score board
			GameStructure.scoreKeeping(2, firstPlayer, secondPlayer);
				
			return;
		}
		//Calls itself again repeatedly so the game can continue
		gameInterface();
	}
	
	//Reset both players' positions to 1 if the user chooses to play another round
	public static void resetPosition()
	{
		firstPos = 1;
		secondPos = 1;
	}
	
	//Getter method used to return the first player's name used for GameXML class
	public static String getfirstPlayer()
	{
		return firstPlayer;
	}
	
	//Getter method used to return the second player's name used for GameXML class
	public static String getSecondPlayer()
	{
		return secondPlayer;
	}
	
	//Main method that uses the user interface to retrieve necessary info for the game
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		//Gives user the option to activate the game program or exit 
		System.out.println("Press 's' to start game or 'e' to exit:");
		activation = keyboard.nextLine();
		
		//Re-run the method if the expected letter is not entered
		if (!activation.equals("s") && !activation.equals("e"))
		{
			System.out.println("You did not enter the expected letter! Please try again:");
			main(args);
		}	
		else if (activation.equals("e"))
		{
			//Exits the program if the user chooses to do so
			return;
		}
		else
		{
			//Game startup information and brief explanation of guidelines
			System.out.println("Welcome to the Snakes and Ladders Game!"
					+ "\nRULES: This game is for two players ONLY. Both players will"
					+ " start at position '1' and take turns rolling one dice. Player 1"
					+ " gets \nto start first!!!"
					+ "\nNOTE: Ladders allows players to move up faster on the game board."
					+ " Snakes will cause players to slide down on the game board."
					+ "\nThe player that makes it to position '100' first wins. Good luck!");
			
			//Takes in the names of both players which will be used in player interaction 
			System.out.println("Enter the name of Player 1:");
			firstPlayer = keyboard.nextLine();
			System.out.println("Enter the name of Player 2:");
			secondPlayer = keyboard.nextLine();
			
			//Initializes the start time of the game 
			startTime = System.currentTimeMillis();
			
			//Calls the method involving the interface during the game
			gameInterface();
		}
		keyboard.close();
	}
}

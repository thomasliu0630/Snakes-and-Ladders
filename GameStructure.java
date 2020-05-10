/**
 * Purpose: Represents the overall layout of the game including conditions and functions
 * Author: Thomas Liu
 * Created On: 5 June 2019
 */

import java.util.Scanner;

public class GameStructure 
{
	//Fields that are essential in defining the structure of the game
	private static Integer gameArray[];
	private static String input;
	private static int firstPlayerWins = 0;
	private static int secondPlayerWins = 0;
	private static int firstPlayerLosses = 0;
	private static int secondPlayerLosses = 0;
	
	//Creates an array that represents the snakes and ladders game board
	public static void gameBoard(int nums)
	{
		nums = 100;
		
		//Initializes the array and assigns it with a length of 100
		gameArray = new Integer[nums];
		
		//Local variable used to count each grid of the game board
		int count = 1;
		
		for (int i = 0; i < gameArray.length; i++)
		{
			gameArray[i] = count;
			count++;
		}
	}
	
	//Conditionals that identify external cases which involves the snakes and ladders
	public static int gameConditions(int counter, int dice)
	{
		//A temporary value used to store the initial position
		int tempCount = counter;
		
		//Adds value of dice rolled to the initial position
		counter += dice;
		
		//Assigns the new value if the player goes up a ladder or slides down a snake
		switch (counter)
		{
			case 3:
				counter = 51;
				break;
			case 6:
				counter = 27;
				break;
			case 20:
				counter = 70;
				break;
			case 25:
				counter = 5;
				break;
			case 34:
				counter = 1;
				break;
			case 36:
				counter = 55;
				break;
			case 47:
				counter = 19;
				break;
			case 63:
				counter = 95;
				break;
			case 65:
				counter = 52;
				break;
			case 68:
				counter = 98;
				break;
			case 87:
				counter = 57;
				break;
			case 91:
				counter = 61;
				break;
				
			case 99:
				counter = 69;
				break;
		}
		
		//Player remains at current position if dice rolled brings him/her to over 100
		if (counter > 100)
		{
			counter = tempCount;
		}
		
		return counter;
	}
	
	//Method that converts the calculated time from milliseconds to minutes
	public static String gameTiming(long totalTime)
	{
		double convertedTime = (double) totalTime / 60000;
		
		String time = Double.toString(convertedTime);
		
		return time;
	}
	
	//Method that calculates the scores of each player based on the number of rounds
	public static void scoreKeeping(int numPlayer, String firstPlayer, String secondPlayer)
	{
		Scanner keyboard = new Scanner(System.in);
		
		if (numPlayer == 1)
		{
			//First player wins, second player loses
			firstPlayerWins++;
			secondPlayerLosses++;
		}
		else if (numPlayer == 2)
		{
			//Second player wins, first player loses
			secondPlayerWins++;
			firstPlayerLosses++;
		}
		//Outputs the current score board 
		System.out.println(firstPlayer + ": " + firstPlayerWins
				+ "\n" + secondPlayer + ": " + secondPlayerWins);
		
		//Gives users to option to play again or exit the program
		System.out.println("Press 'p' to play again, or 'e' to exit game:");
		input = keyboard.nextLine();
		
		while (!input.equals("p") && !input.equals("e"))
		{
			System.out.println("You did not enter the expected letter! Please try again:");
			input = keyboard.nextLine();
		}
		if (input.equals("p"))
		{
			//Resets each player's position back to 1 and re-run the game
			UserInterface.resetPosition();
			UserInterface.gameInterface();
		}
		else
		{	
			return;
		}
	}
}
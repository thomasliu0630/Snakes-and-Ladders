/**
 * Purpose: Purpose: Calculates the movements of the players throughout the game
 * Author: Thomas Liu
 * Created On: 6 June 2019
 */

import java.util.Random;

public class GameAction 
{
	//Generates a random number from 1 to 6 as the dice value for each turn
	public static int rollingDice()
	{
		int diceValue = (int)(Math.random() * 6 + 1);
		
		return diceValue;
	}
	
	//returns value of the player’s new position called from gameConditions method
	public static int playerMovement(int currentPos, int dice)
	{
		return GameStructure.gameConditions(currentPos, dice);
	}
}










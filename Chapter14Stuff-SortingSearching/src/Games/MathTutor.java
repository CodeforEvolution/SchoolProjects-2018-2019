package Games;

import java.util.Random;
import java.util.Scanner;

public class MathTutor {
	public enum GameMode {ADD, SUB, MD, ALL};
	public final static int SUCCESS_TO_LEVEL_UP = 10;
	public final static int START_LIVES = 3;
	public final static int MAX_INTEGER = 20;
	
	public final static Random rEngine = new Random();
	public final static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int success = 0;
		GameMode mode = GameMode.ADD;
		int tries = START_LIVES;
		boolean again = true;
		
		System.out.println("Welcome!");
		printRules();
		
		do
		{
			boolean result = false;
			int level = (success % SUCCESS_TO_LEVEL_UP) + 1;
			
			if (success / SUCCESS_TO_LEVEL_UP == 0);
			{
				System.out.println("LEVEL UP!!!! Welcome to level " + level + "!");
			}

			System.out.println("Get ready for a question: ");
			
			if (level == 1)
			{
				result = level1Ques();
			}
			else if (level == 2)
			{
				result = level2Ques();
			}
			else if (level == 3)
			{
				result = level3Ques();
			}
			else if (level >= 4)
			{
				result = level4Ques();
			}
			else
			{
				throw new Error("How did the level fall below 1???");
			}
			
			if (result == false)
			{
				tries--;
				printFail(tries);
			}
			else
			{
				success++;
				printSuccess(success);
			}
			
			if (tries <= 0)
			{
				again = gameOverSequence();
			}	
		} while (again == true);
	}
	
	public static boolean gameOverSequence()
	{
		System.out.println("Oh no! Game over man, game over!");
		
		boolean again = false;
		boolean ok = false;
		do
		{
			System.out.println("Would you like to play...again?");
			String answer = input.next();
			
			if (answer.equalsIgnoreCase("yes") ||
				answer.equalsIgnoreCase("ok")  ||
				answer.equalsIgnoreCase("continue"))
			{
				System.out.println("Alrighty!!!");
				again = true;
				ok = true;
			}
			else if (answer.equalsIgnoreCase("no") ||
					 answer.equalsIgnoreCase("stop"))
			{
				again = false;
				ok = true;
			}
			else
			{
				System.out.println("That wasn't a (yes or no)...I'll ask again...");
				ok = false;
			}		
		} while (ok == false);
		
		return again;
	}
	
	public static void printRules()
	{
		System.out.println("/*********************************************************/");
		System.out.println("I'm Toot, your personal tutor!");
		System.out.println("For this game, simply answer math problems correctly.");
		System.out.println("Every " + SUCCESS_TO_LEVEL_UP + " correct answers the diffculty will increase.");
		System.out.println("Level 1 is addition, level 2 is subtraction,");
		System.out.println("level 3 is multiplication and division, and level 4 is completely random!");
		System.out.println("/*********************************************************/");
	}
	
	public static void printFail(int livesRemain)
	{
		System.out.println("Bzzrt!! Be careful! You have " + livesRemain + " live(s) remaining!");
	}
	
	public static void printSuccess(int correct)
	{
		System.out.println("Ding, ding, ding! You have " + correct + " answer(s) correct!");
	}
	
	public static boolean level1Ques()
	{
		int a = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
		int b = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
		int answer = a + b;
		
		System.out.println("What is " + a + " + " + b + "?");
		
		return new Integer(input.next()) == answer;
	}
	
	public static boolean level2Ques()
	{
		return true;
	}
	
	public static boolean level3Ques()
	{
		return true;
	}
	
	public static boolean level4Ques()
	{
		return true;
	}
}

package Games;

import java.util.Random;
import java.util.Scanner;

public class MathTutor {
	public final static int SUCCESS_TO_LEVEL_UP = 2;
	public final static int START_LIVES = 3;
	public final static int MAX_INTEGER = 9;
	public final static int VICTOR = MAX_INTEGER;
	
	public final static Random rEngine = new Random();
	public final static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int success = 0;
		int tries = START_LIVES;
		boolean again = true;
		
		System.out.println("Welcome!");
		printRules();
		
		do
		{
			boolean result = false;
			int level = (success / SUCCESS_TO_LEVEL_UP) + 1;

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
		System.out.println("Every " + SUCCESS_TO_LEVEL_UP + " correct answers, the diffculty will increase.");
		System.out.println("Fail " + START_LIVES + " time(s) and it's game over!");
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
		System.out.println("A level 1 addition question: ");
		
		int a = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
		int b = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
		int answer = a + b;
		
		System.out.println("What is " + a + " + " + b + "?");
		
		return new Integer(input.next()) == answer;
	}
	
	public static boolean level2Ques()
	{
		System.out.println("A level 2 subtraction question: ");
		
		int a = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
		int b = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
		int answer = a - b;
		
		System.out.println("What is " + a + " - " + b + "?");
		
		return new Integer(input.next()) == answer;
	}
	
	public static boolean level3Ques()
	{
		int a;
		int b;
		int answer;
		
		if (rEngine.nextBoolean())
		{
			System.out.println("A level 3 multiplication question: ");
			
			a = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
			b = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
			answer = a * b;
			
			System.out.println("What is " + a + " * " + b + "?");
		}
		else
		{
			System.out.println("A level 3 division question: ");
			
			a = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
			
			// Cheap way to do this, but it works
			do
			{
				b = rEngine.nextInt(MAX_INTEGER * 2) - MAX_INTEGER;
			} while (a % b != 0);
			answer = a / b;
			
			System.out.println("What is " + a + " / " + b + "?");
		}
		
		
		return new Integer(input.next()) == answer;
	}
	
	public static boolean level4Ques()
	{
		System.out.println("Level 4 Mix up! It's time for...");
		
		boolean result = false;
		
		switch (rEngine.nextInt(3))
		{
			case 0:
				result = level1Ques();
				break;
			case 1:
				result = level2Ques();
				break;
			case 2:
				result = level3Ques();
				break;
			default:
				throw new Error("What kind of question is this?!?");
		}
		
		return result;
	}
}

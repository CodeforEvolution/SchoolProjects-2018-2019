package factfibbasepow;

import java.util.Scanner;

public class Factorials {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a factorial that'd you'd like to break down: ");
		int input = in.nextInt();
		in.close();
		
		System.out.println("Decyphering !" + input + ": ");
		
		System.out.println("Recursive style: The result is: " + recursiveFactorial(input));
		System.out.println("Iterative style: The result is: " + iterativeFactorial(input));
	}
	
	private static int recursiveFactorial(int theNumber)
	{
		if (theNumber <= 1)
			return theNumber;
		
		return theNumber * recursiveFactorial(theNumber - 1);
	}
	
	private static int iterativeFactorial(int theNumber)
	{
		int factorial = 1;
		
		for (int i = theNumber; i >= 1; i--)
		{
			factorial *= i;
		}
		
		return factorial;
	}
}

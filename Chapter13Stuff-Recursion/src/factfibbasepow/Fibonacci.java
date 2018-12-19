package factfibbasepow;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args)
	{
Scanner in = new Scanner(System.in);
		
		System.out.println("How many sequences of fibonacci would you like?: ");
		int input = in.nextInt();
		in.close();
		
		System.out.println("The result is: " + fibonacci(input));
	}
	
	private static int fibonacci(int numSeq)
	{
		if (numSeq < 1)
			throw new IllegalArgumentException("A fibonacci sequence won't work with a number below 1!");
	
		if (numSeq <= 2)
			return 1;
		else
			return fibonacci(numSeq - 1) + fibonacci(numSeq - 2);
	}
}

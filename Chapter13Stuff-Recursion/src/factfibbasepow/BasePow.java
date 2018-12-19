package factfibbasepow;

import java.util.Scanner;

public class BasePow {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a base, and then a power you'd like to raise it to: ");
		int base = in.nextInt();
		int pow = in.nextInt();
		in.close();
		
		System.out.println(base + " to the " + pow + " coming right up!");
		System.out.println("The result is: " + basePow(base, pow));
	}
	
	private static int basePow(int theBase, int thePow)
	{
		if (thePow < 0)
			throw new IllegalArgumentException("We don't handle negative powers yet!");
		
		if (thePow <= 1)
			return theBase;
		else
			thePow--;
			return theBase * basePow(theBase, thePow);
	}
}

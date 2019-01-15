package Review;

import java.util.Arrays;
import java.util.Random;

public class TriDigitArray {
	public static void main(String[] args)
	{
		Random r = new Random();
		int[] theArray = new int[10];
		
		int temp = 0;
		
		// Step a
		for (int i = 0; i < theArray.length; i++)
		{
			theArray[i] = r.nextInt(1000);
		}
		
		printArray(theArray);
		
		// Step b
		System.out.println();

		double average = 0.0;
		
		for (int x : theArray)
		{
			average += x;
		}
		average /= theArray.length;
		
		System.out.println("Is it higher than the average of " + average + "?");
		for (int x : theArray)
		{
			if (x > average)
			{
				System.out.print(x + " ");
			}
		}
		System.out.println();
		
		// Step c
		System.out.println();

		int high = 0;
		int low = 0;
		temp = 0;
		
		for (int i = 0; i < theArray.length; i++)
		{
			if (theArray[i] > theArray[high])
			{
				high = i;
			}
			
			if (theArray[i] < theArray[low])
			{
				low = i;
			}
		}
		System.out.println("The highest: " + theArray[high]);
		System.out.println("The lowest: " + theArray[low]);
		
		System.out.println("\nSwap!!!");
		
		temp = theArray[high];
		theArray[high] = theArray[low];
		theArray[low] = temp;
		
		temp = high;
		high = low;
		low = temp;
		
		printArray(theArray);
		
		// Step d
		System.out.println();
		
		int twohigh = 0;
		int twolow = 0;
		
		
		for (int i = 0; i < theArray.length; i++)
		{
			if (theArray[i] < theArray[high] && theArray[i] > theArray[twohigh])
			{
				twohigh = i;
			}
			
			if (theArray[i] > theArray[low] && theArray[i] < theArray[twolow])
			{
				twolow = i;
			}
		}
		System.out.println("The 2nd highest: " + theArray[twohigh]);
		System.out.println("The 2nd lowest: " + theArray[twolow]);
		
		System.out.println("\nSWAP!");
		temp = theArray[twohigh];
		theArray[twohigh] = theArray[twolow];
		theArray[twolow] = temp;
		
		printArray(theArray);
		
		// Step e
		System.out.println();
		
		int[] partun = new int[5];
		int[] partdeux = new int[5];
		
		System.out.println("It's splitting time!");
		partun = Arrays.copyOfRange(theArray, 0, 4);
		partdeux = Arrays.copyOfRange(theArray, 5, 9);
		
		System.out.println("Your two new arrays: ");
		printArray(partun);
		printArray(partdeux);
	}
	
	private static void printArray(int[] inArray)
	{
		for (int x : inArray)
		{
			System.out.print(x + " ");
		}
		System.out.println();
	}
}

package Sorters;

import java.util.Arrays;
import java.util.Random;

public class TheSelectSorter {
	public static void main (String[] args)
	{
		Random r = new Random();
		int[] numbers = new int[10];
		
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = r.nextInt(30) + 1;
		}
		
		System.out.println("Initial Array: ");
		System.out.println(Arrays.toString(numbers));
		
		for (int l = 0; l < numbers.length; l++)
		{
			int smallestIndex = l;
			for (int i = l; i < numbers.length; i++)
			{
				if (numbers[i] < numbers[smallestIndex])
				{
					smallestIndex = i;
				}
			}
			swapToBeginning(numbers, smallestIndex);
		}
		
		System.out.println("Sorted Array: ");
		System.out.println(Arrays.toString(numbers));
	}
	
	private static void swapToBeginning(int[] inArray, int theIndex)
	{	
		int temp = inArray[theIndex];

		for (int i = theIndex; i > 0; i--)
		{
			inArray[i] = inArray[i - 1];
		}
		inArray[0] = temp;
	}
}

package Sorters;

import java.util.Arrays;
import java.util.Random;

public class TheBubbleSorter {
	public static void main (String[] args)
	{
		Random r = new Random();
		int[] numbers = new int[6];
		
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = r.nextInt(50) + 1;
		}
		
		System.out.println("\nThe initial array: ");
		System.out.println(Arrays.toString(numbers));
		
		for (int p = 0; p < numbers.length - 1; p++)
		{
			for (int i = 0; i < numbers.length - 1; i++)
			{
				if (numbers[i] > numbers[i + 1])
				{
					swapValues(numbers, i, i + 1);
				}
			}
		}
		
		System.out.println("\nThe sorted array: ");
		System.out.println(Arrays.toString(numbers));
	}
	
	private static void swapValues(int[] inArray, int first, int second)
	{
		int temp = inArray[first];
		inArray[first] = inArray[second];
		inArray[second] = temp;
	}
}

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
		
		for (int l = numbers.length - 1; l >= 0; l--)
		{

		}
	}
}

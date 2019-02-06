package MySort;

import java.util.Arrays;
import java.util.Random;

public class YoloSort {
	public static void main(String[] args)
	{
		int[] theArrayToSortA = new int[900];
		int[] theArrayToSortB = new int[900];
		int[] averageTimeA = new int[10];
		int[] averageTimeB = new int[10];
		
		for (int i = 0; i < 900; i++)
		{
			theArrayToSortA[i] = new Random().nextInt(1000);
		}
		theArrayToSortB = Arrays.copyOf(theArrayToSortA, theArrayToSortA.length);

		System.out.println("The original array: " + Arrays.toString(theArrayToSortA));
		
		for (int i = 0; i < 10; i++)
		{
			double start = System.currentTimeMillis();
			yoloSort(theArrayToSortA);
			double end = System.currentTimeMillis();
			
			System.out.println("The sort took: " + (end - start) + "ms");
			System.out.println("\nThe sorted array: " + Arrays.toString(theArrayToSortA));
		}
				
		
		
		double startA = System.currentTimeMillis();
		Arrays.sort(theArrayToSortB);
		double endA = System.currentTimeMillis();
		
		System.out.println("\nThe other sort took: " + (endA - startA) + "ms");
		System.out.println("\nThe other sorted array: " + Arrays.toString(theArrayToSortB));
	}
	
	public static void yoloSort(int[] inArray)
	{
		Random r = new Random();
		
		while (isSorted(inArray) == false)
		{
	
			int first = r.nextInt(inArray.length);
			int second = r.nextInt(inArray.length);
			
			if (first == second)
				continue;
			
			if ((first > second && inArray[first] < inArray[second]) ||
				(first < second && inArray[first] > inArray[second]))
			{
				swap(inArray, first, second);
			}
		}
	}
	
	public static boolean isSorted(int[] inArray)
	{
		boolean sorted = true;

		for (int c = 0; c < (inArray.length - 1); c++)
		{
			if (inArray[c] > inArray[c + 1])
			{
				sorted = false;
				break;
			}
		}
		
		return sorted;
	}
	
	public static void swap(int[] inArray, int first, int second)
	{
		int temp = inArray[first];
		inArray[first] = inArray[second];
		inArray[second] = temp;
	}
}

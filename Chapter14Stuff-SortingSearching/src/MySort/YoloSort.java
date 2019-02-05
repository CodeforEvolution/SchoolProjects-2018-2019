package MySort;

import java.util.Arrays;
import java.util.Random;

public class YoloSort {
	public static void main(String[] args)
	{
		int[] theArrayToSort = {3, 5, 6, 3, 5, 2, 4, 11, 40, 320, 43, 12};
		System.out.println("The original array: " + Arrays.toString(theArrayToSort));
		
		double start = System.currentTimeMillis();
		int[] sortedArray = yoloSort(theArrayToSort);
		double end = System.currentTimeMillis();
				
		System.out.println("The sort took: " + (end - start) + "ms");
		System.out.println("\nThe sorted array: " + Arrays.toString(sortedArray));
		
		double startA = System.currentTimeMillis();
		Arrays.sort(theArrayToSort);
		double endA = System.currentTimeMillis();
		
		System.out.println("\nThe other sort took: " + (endA - startA) + "ms");
		System.out.println("\nThe other sorted array: " + Arrays.toString(theArrayToSort));
	}
	
	public static int[] yoloSort(int[] inArray)
	{
		Random r = new Random();
		int[] outArray = Arrays.copyOf(inArray, inArray.length);
		
		while (isSorted(outArray) == false)
		{
	
			int first = r.nextInt(outArray.length);
			int second = r.nextInt(outArray.length);
			
			if ((first > second && outArray[first] < outArray[second]) ||
				(first < second && outArray[first] > outArray[second]))
			{
				swap(outArray, first, second);
			}
			
			System.out.println("\nCurrent array: " + Arrays.toString(outArray));
		}
		
		return outArray;
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

package MySort;

import java.util.Arrays;
import java.util.Random;

public class YoloSort {
	public static void main(String[] args)
	{
		final int TESTS = 50;
		final int ARRAY_SIZE = 1280;

		int[] originArray = new int[ARRAY_SIZE];
		int[] theArrayToSortA = new int[ARRAY_SIZE];
		int[] theArrayToSortB = new int[ARRAY_SIZE];
		double[] averageTimeA = new double[TESTS];
		double[] averageTimeB = new double[TESTS];
		
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			originArray[i] = new Random().nextInt(1000);
		}

		System.out.println("The original array: " + Arrays.toString(theArrayToSortA));
		
		for (int i = 0; i < TESTS; i++)
		{
			theArrayToSortA = Arrays.copyOf(originArray, originArray.length);
			
			double start = System.currentTimeMillis();
			yoloSort(theArrayToSortA);
			double end = System.currentTimeMillis();
			
			
			double time = end - start;
			System.out.println("\nYolo sort took: " + time + "ms");
			System.out.println("\nSorted array: " + Arrays.toString(theArrayToSortA));
			
			averageTimeA[i] = time;
		}
		
		for (int i = 0; i < TESTS; i++)
		{
			theArrayToSortB = Arrays.copyOf(originArray, originArray.length);
			
			double startB = System.currentTimeMillis();
			Arrays.sort(theArrayToSortB);
			double endB = System.currentTimeMillis();
			
			double time = endB - startB;
			System.out.println("\nBuiltin sort took: " + time + "ms");
			System.out.println("\nSorted array: " + Arrays.toString(theArrayToSortB));
			
			averageTimeB[i] = time;
		}
		
		double averageA = 0.0;
		for (int i = 0; i < averageTimeA.length; i++)
		{
			averageA += averageTimeA[i];
		}
		averageA /= averageTimeA.length;
		
		System.out.println("\nYolo sort average time: " + averageA + "ms");
		
		double averageB = 0.0;
		for (int i = 0; i < averageTimeB.length; i++)
		{
			averageB += averageTimeB[i];
		}
		averageB /= averageTimeB.length;
		
		System.out.println("Builtin sort average time: " + averageB + "ms");
	}
	
	public static void yoloSort(int[] inArray)
	{
		Random r = new Random();
		
		while (isSorted(inArray) == false)
		{
	
			int first = r.nextInt(inArray.length);
			int second = first + 1;

			if (second >= inArray.length || second < 0)
				continue;
			
			int firstI = inArray[first];
			int secondI = inArray[second];
			
			if ((first > second && firstI < secondI) ||
				(first < second && firstI > secondI))
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

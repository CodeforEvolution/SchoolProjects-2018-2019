package Searching;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchComparison {
	public static int compares = 0;
	
	public static void main(String[] args)
	{
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		int[] myArray = new int[1000];
		boolean ok;
		int search;
		int foundIndex;
		double startTime;
		double endTime;
		
		for (int i = 0; i < myArray.length; i++)
		{
			myArray[i] = r.nextInt(100) + 1;
		}
		
		System.out.println("The Original Array: " + Arrays.toString(myArray));
		
		System.out.println("Why hello there!");
		
		ok = false;
		do
		{
			System.out.println("Please enter a number from (1 to 100) to search for: ");
			search = in.nextInt();
			
			if (search > 100 || search < 1)
				System.out.println("That number wasn't in range, I'll ask again...");
			else
				ok = true;
		} while (ok == false);
		in.close();
		System.out.println();
		
		// The Linear Search with unsorted array
		System.out.println("Unsorted time!\n");
		
		startTime = System.currentTimeMillis();
		
		foundIndex = linearSearch(myArray, search);
		
		endTime = System.currentTimeMillis();
		
		if (foundIndex != -1)
		{
			System.out.println("Found " + search + " at index " + foundIndex);
			System.out.println("Search took " + (endTime - startTime) + " ms and " + compares + " comparisons!");
		}
		else
		{
			System.out.println("Could not find " + search);
		}
		
		// Sorted array with binary search
		
		System.out.println("\nSorted time!\n");
		
		Arrays.sort(myArray);
		System.out.println("The sorted array: " + Arrays.toString(myArray));
		
		System.out.println("\nLet's search again, but binary!");
		
		startTime = System.currentTimeMillis();
		
		foundIndex = binarySearch(myArray, search);
		
		endTime = System.currentTimeMillis();
		
		if (foundIndex != -1)
		{
			System.out.println("Found " + search + " at index " + foundIndex);
			System.out.println("Search took " + (endTime - startTime) + " ms and " + compares + " comparisons!");
		}
		else
		{
			System.out.println("Could not find " + search);
		}
	}
	
	public static int linearSearch(int[] arrayToSearch, int toSearchFor)
	{
		int foundIndex = -1;
		compares = 0;
		
		for (int i = 0; i < arrayToSearch.length; i++)
		{
			compares++;
			if (toSearchFor == arrayToSearch[i])
			{
				foundIndex = i;
				break;
			}
		}
		
		return foundIndex;
	}
	
	public static int binarySearch(int[] arrayToSearch, int toSearchFor)
	{
		compares = 0;
		return binarySearch(arrayToSearch, toSearchFor, arrayToSearch.length - 1, 0);
	}
	
	private static int binarySearch(int[] array, int search, int high, int low)
	{
		compares++;
		int mid = (high + low) / 2;
		
		if (low > high)
		{
			return -1;
		}
		else if (array[mid] > search)
		{
			return binarySearch(array, search, mid - 1, low);
		}
		else if (array[mid] < search)
		{

			return binarySearch(array, search, high, mid + 1);
		}
		
		return mid;
	}
}

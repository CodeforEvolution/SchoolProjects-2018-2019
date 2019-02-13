package Searching;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchComparison {
	public static void main(String[] args)
	{
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		int[] myArray = new int[100];
		boolean ok;
		int search;
		int foundIndex;
		int compares;
		BigDecimal startTime;
		BigDecimal endTime;
		
		for (int i = 0; i < myArray.length; i++)
		{
			myArray[i] = r.nextInt(100) + 1;
		}
		
		System.out.println("The Array: " + Arrays.toString(myArray));
		
		// Unsorted array
		System.out.println("\nUnsorted time!\n");
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
		System.out.println();
		
		compares = 0;
		foundIndex = -1;
		startTime = new BigDecimal(System.currentTimeMillis());
		for (int i = 0; i < myArray.length; i++)
		{
			compares++;
			if (search == myArray[i])
			{
				foundIndex = i;
				break;
			}
		}
		endTime = new BigDecimal(System.currentTimeMillis());
		
		if (foundIndex != -1)
		{
			System.out.println("Found " + search + " at index " + foundIndex);
			System.out.println("Search took " + endTime.subtract(startTime) + " ms and " + compares + " comparisons!");
		}
		else
		{
			System.out.println("Could not find " + search);
		}
		
		// Sorted array
		
		System.out.println("\nSorted time!\n");
		
		Arrays.sort(myArray);
		System.out.println("The sorted array: " + Arrays.toString(myArray));
		
		System.out.println("\nLet's search again, but binary!");
		
		compares = 0;
		foundIndex = -1;
		startTime = new BigDecimal(System.currentTimeMillis());
		for (int i = 0; i < myArray.length; i++)
		{
			compares++;
			if (search == myArray[i])
			{
				foundIndex = i;
				break;
			}
		}
		endTime = new BigDecimal(System.currentTimeMillis());
		
		if (foundIndex != -1)
		{
			System.out.println("Found " + search + " at index " + foundIndex);
			System.out.println("Search took " + endTime.subtract(startTime) + " ms and " + compares + " comparisons!");
		}
		else
		{
			System.out.println("Could not find " + search);
		}
	}
}

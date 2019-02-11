package Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortedDuplicates {
	public static void main(String[] args)
	{
		ArrayList<Integer> theArray = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++)
		{
			theArray.add(new Random().nextInt(10));
		}
		
		Collections.sort(theArray);
		
		System.out.println("Removing duplicates from: " + theArray);
		
		int removed = 0;
		for (int i = 0; i <= theArray.size() - removed; i++)
		{
			removed += removeDuplicates(theArray, i); 
		}
		
		System.out.println("\nArray without duplicates: " + theArray);
	}
	
	public static int removeDuplicates(ArrayList<Integer> inArray, int index)
	{
		if (index + 1 > inArray.size())
			return 0;
		
		int removed = 0;
		
		while (index + 1 < inArray.size() && inArray.get(index + 1) == inArray.get(index))
		{
			inArray.remove(index + 1);
			removed++;
		}
		
		return removed;
	}
}

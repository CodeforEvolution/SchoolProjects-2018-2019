package Searching;

import java.util.ArrayList;
import java.util.Random;

public class UnsortedDuplicates {
	public static void main(String[] args)
	{
		ArrayList<Integer> theArray = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++)
		{
			theArray.add(new Random().nextInt(10));
		}
		
		System.out.println("Removing duplicates from: " + theArray);
		
		for (int i = 0; i < theArray.size(); i++)
		{
			if (countDuplicates(theArray, theArray.get(i)) > 1)
			{
				theArray.remove(i);
				i--;
			}
		}
		
		System.out.println("\nArray without duplicates: " + theArray);
	}
	
	public static int countDuplicates(ArrayList<Integer> inArray, int search)
	{
		int count = 0;

		for (int i = 0; i < inArray.size(); i++)
		{
			if (inArray.get(i) == search)
				count++;
		}
		
		return count;
	}
}

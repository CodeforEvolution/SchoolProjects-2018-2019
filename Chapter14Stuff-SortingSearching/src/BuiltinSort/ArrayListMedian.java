package BuiltinSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListMedian {
	public static void main (String[] args)
	{
		Random r = new Random();
		
		ArrayList<Integer> leArray = new ArrayList<Integer>();
		
		for (int i = 0; i < (4 + r.nextInt(2)); i++)
		{
			leArray.add(r.nextInt(50) + 1);
		}
		
		if (leArray.size() % 2 == 0)
		{
			System.out.println("Even sized array inbound!!!!");
		}
		else
		{
			System.out.println("Odd sized array inbound!!!!!");
		}
		
		System.out.println("\nArray: " + "\n" + leArray);
		
		System.out.println();
		
		Collections.sort(leArray);
		
		System.out.println("Sorted Array: " + "\n" + leArray);
		
		double median = 0.0;
		
		if (leArray.size() % 2 == 0)
		{
			median = (leArray.get((leArray.size() / 2) - 1) + leArray.get(leArray.size() / 2)) / 2.0;
		}
		else
		{
			median = leArray.get(leArray.size() / 2);
		}
		
		System.out.println("\nThe array median: " + median);
	}
}

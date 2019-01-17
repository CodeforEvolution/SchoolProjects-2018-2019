package BuiltinSort;

import java.util.Arrays;
import java.util.Random;

public class ArrayMedian {
	public static void main (String[] args)
	{
		Random r = new Random();
		
		int[] leArray = new int[4 + r.nextInt(2)];
		
		if (leArray.length % 2 == 0)
		{
			System.out.println("Even sized array inbound!!!!");
		}
		else
		{
			System.out.println("Odd sized array inbound!!!!!");
		}
		
		for (int i = 0; i < leArray.length; i++)
		{
			leArray[i] = r.nextInt(50) + 1;
		}
		
		System.out.println("\nArray: " + "\n" + Arrays.toString(leArray));
		
		System.out.println();
		
		Arrays.sort(leArray);
		
		System.out.println("Sorted Array: " + "\n" + Arrays.toString(leArray));
		
		double median = 0.0;
		
		if (leArray.length % 2 == 0)
		{
			median = (leArray[(leArray.length / 2) - 1] + leArray[leArray.length / 2]) / 2.0;
		}
		else
		{
			median = leArray[leArray.length / 2];
		}
		
		System.out.println("\nThe array median: " + median);
	}
}

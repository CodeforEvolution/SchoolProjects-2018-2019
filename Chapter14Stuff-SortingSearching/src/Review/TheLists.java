package Review;

import java.util.ArrayList;
import java.util.Scanner;

public class TheLists {
	public static void main(String[] args)
	{
		ArrayList<String> goodFood = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		
		goodFood.add("apple");
		goodFood.add("orange");
		goodFood.add("brocoli");
		goodFood.add("mango");
		goodFood.add("cauliflower");
		goodFood.add("celery");
		
		// Step a
		System.out.println("The foods: ");
		printArray(goodFood);
		
		// Step b
		System.out.println("\nChoose two foods to swap please!");
		
		boolean ok = false;
		String inputA = "";
		String inputB = "";
		do
		{
			inputA = in.next();
			inputB = in.next();
			
			if (goodFood.contains(inputA) == false || goodFood.contains(inputB) == false)
			{
				ok = false;
			}
			
			ok = true;
			
			System.out.println("\nFound them! Now swapping them...");
			
			int dexA = goodFood.indexOf(inputA);
			int dexB = goodFood.indexOf(inputB);
			
			String temp = goodFood.get(dexA);
			goodFood.set(dexA, goodFood.get(dexB));
			goodFood.set(dexB, temp);
			
			if (ok == false)
			{
				System.out.println("I can't find one of those foods in the list, please try again: ");
			}
		} while (ok == false);
		
		printArray(goodFood);
	}
	
	private static void printArray(ArrayList<String> inArray)
	{
		for (String x : inArray)
		{
			System.out.print(x + " ");
		}
		System.out.println();
	}
}

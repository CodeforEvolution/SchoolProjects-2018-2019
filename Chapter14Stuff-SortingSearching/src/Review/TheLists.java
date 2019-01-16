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
			
			swapValues(goodFood, inputA, inputB);
			
			if (ok == false)
			{
				System.out.println("I can't find one of those foods in the list, please try again: ");
			}
		} while (ok == false);
		
		printArray(goodFood);
		
		// Step c
		System.out.println();
		int alphaF = 0;
		int alphaL = 0;
		
		for (int i = 0; i < goodFood.size(); i++)
		{
			if (goodFood.get(i).compareTo(goodFood.get(alphaF)) < 0)
			{
				alphaF = i;
			}
			
			if (goodFood.get(i).compareTo(goodFood.get(alphaL)) > 0)
			{
				alphaL = i;
			}
		}
		
		System.out.println("First Alpha: " + goodFood.get(alphaF));
		System.out.println("Last Alpha: " + goodFood.get(alphaL));
		
		swapValues(goodFood, goodFood.get(alphaF), goodFood.get(alphaL));
		
		System.out.println("\nSWAP!!!");
		printArray(goodFood);
		
		// Step d
		System.out.println();
		int longS = 0;
		int shortS = 0;
		
		for (int i = 0; i < goodFood.size(); i++)
		{
			if (goodFood.get(longS).length() < goodFood.get(i).length())
			{
				longS = i;
			}
			
			if (goodFood.get(shortS).length() > goodFood.get(i).length())
			{
				shortS = i;
			}
		}
		
		System.out.println("Longest food name: " + goodFood.get(longS));
		System.out.println("Shortest food name: " + goodFood.get(shortS));
		
		swapValues(goodFood, goodFood.get(longS), goodFood.get(shortS));
		
		System.out.println("\nSWAP!!!");
		printArray(goodFood);
		
		// Step e
		System.out.println("\nArray Spliting time!!!");
		
		ArrayList<String> thing1 = new ArrayList<String>();
		ArrayList<String> thing2 = new ArrayList<String>();
		
		for (int i = 0; i < goodFood.size(); i++)
		{
			if (i < goodFood.size() / 2)
			{
				thing1.add(goodFood.get(i));
			}
			else
			{
				thing2.add(goodFood.get(i));
			}
		}
		
		System.out.println("\nHere we go: ");
		printArray(thing1);
		printArray(thing2);
	}
	
	private static void swapValues(ArrayList<String> inArray, String first, String second)
	{
		int dexA = inArray.indexOf(first);
		int dexB = inArray.indexOf(second);
		
		String temp = inArray.get(dexA);
		inArray.set(dexA, inArray.get(dexB));
		inArray.set(dexB, temp);
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

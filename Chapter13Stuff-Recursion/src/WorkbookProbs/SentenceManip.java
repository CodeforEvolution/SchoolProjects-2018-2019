package WorkbookProbs;

import java.util.Scanner;

public class SentenceManip {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a string to reverse: ");
		String input = in.next();

		
		System.out.println("\nYour reversed string: " + reverse(input));
		System.out.println("Your iterative reversed string: " + iterateReverse(input));
		

		System.out.println("\nFind something: ");
		String search = in.next();
		
		System.out.println("In what?: ");
		String inWhat = in.next();
		
		System.out.println("\nHas " + search + " been found in " + inWhat + "? " + find(inWhat, search));
		System.out.println("The index of " + search + " in "  + inWhat + " is: " + indexOf(inWhat, search, 0));
		
		in.close();
	}
	
	//Prob 1
	public static String reverse(String in)
	{
		return reverse(in, in.length(), 0);
	}
	
	//Prob 2
	public static String reverse(String toReverse, int upTo, int start)
	{
		if (start > upTo)
			return toReverse;
		else if (toReverse.length() <= 1)
			return toReverse;
		else
			return toReverse.charAt(toReverse.length() - 1) + reverse(toReverse.substring(0, toReverse.length() - 1), upTo, start + 1);
	}
	
	//Prob 3
	public static String iterateReverse(String in)
	{
		String out = "";
		
		for (int i = in.length() - 1; i > -1 ; i--)
		{
			out += in.charAt(i);
		}
			
		return out;
	}
	
	//Prob 4
	public static boolean find(String data, String whatToFind)
	{
		if (data.length() < whatToFind.length())
			return false;
		
		if (data.equals(whatToFind))
			return true;
		
		if (data.substring(0, whatToFind.length()).equals(whatToFind))
			return true;
		
		return find(data.substring(1), whatToFind);
	}
	
	//Prob 5
	public static int indexOf(String data, String whatToFind, int index)
	{
		if (data.length() < whatToFind.length())
			return -1;
		
		if (data.equals(whatToFind))
			return index;
		
		if (data.substring(0, whatToFind.length()).equals(whatToFind))
			return index;
		
		return indexOf(data.substring(1), whatToFind, index + 1);
	}
}

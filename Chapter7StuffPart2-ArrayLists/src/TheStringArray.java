import java.util.Arrays;
import java.util.Scanner;

public class TheStringArray {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String[] theArray = new String[5];
		theArray[0] = "Heya";
		theArray[1] = "Yo";
		theArray[2] = "Computer";
		
		System.out.println("It's time to search! : ");
		String search = in.next();
		in.close();
		
		System.out.println();
		
		int result = search(theArray, search);
		if (result != -1)
		{
			System.out.println(search + " found at index " + result);
		}
		else
		{
			theArray = addAndResize(theArray, search);
		}
		
		System.out.println("Your array: ");
		System.out.println(Arrays.toString(theArray));
	}
	
	public static int search(String[] searchArray, String search)
	{
		int index = 0;

		while (index < searchArray.length)
		{
			if (search.equals(searchArray[index]))
			{
				return index;
			}
			index++;
		}
		
		return -1;
	}
	
	public static String[] addAndResize(String[] theArray, String theString)
	{
		int nOpen = -1;
		int pos = 0;
		while (pos < theArray.length && nOpen == -1)
		{
			if (theArray[pos] == null || theArray[pos].isEmpty())
			{
				nOpen = pos;
				break;
			}
			pos++;
		}
		
		if (nOpen != -1)
		{
			theArray[nOpen] = theString;
		}
		else
		{
			theArray = Arrays.copyOf(theArray, theArray.length + 1);
			theArray[theArray.length - 1] = theString;
		}
		
		return theArray;
	}
}

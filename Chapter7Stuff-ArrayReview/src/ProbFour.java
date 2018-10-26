import java.util.Arrays;
import java.util.Scanner;


public class ProbFour {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String[] words = new String[8];
		
		System.out.println("Enter 8 words please, and why not capatalize the first letter of some? : ");
		for (int i = 0; i < words.length; i++)
		{
			words[i] = in.next();
		}
		
		System.out.println("\nYour scrumptious array: ");
		System.out.println(Arrays.toString(words));
		
		System.out.println("\nNow for the ones that 4+ in length: ");
		for (int i = 0; i < words.length; i++)
		{
			if (words[i].length() >= 4)
			{
				System.out.println(words[i]);
			}
		}
		System.out.println();
		
		System.out.println("Now, words starting with vowels!");
		for (int i = 0; i < words.length; i++)
		{
			if (isVowel(words[i].charAt(0)) == true)
			{
				System.out.println(words[i]);
			}
		}
		System.out.println();
		
		for (int i = 0; i < words.length; i++)
		{
			if (Character.isUpperCase(words[i].charAt(0)) == true)
			{
				System.out.println(words[i]);
			}
		}
		System.out.println();
		
		boolean ok = false;
		char input = ' ';
		do
		{
			System.out.println("Would you like to search the array for a string? (Yes or No) : ");
			input = Character.toLowerCase(in.next().charAt(0));
			
			if (input == 'n')
			{
				System.out.println("Ok, well goodbye! Have a great day!");
				return;
			}
			else if (input == 'y')
			{
				ok = true;
			}
			else
			{
				ok = false;
				System.out.println("That's not a yes or no...I'll ask again...\n");
			}
		} while (ok == false);
		System.out.println();
		
		System.out.println("It's time to search for some childhood tra...I mean search in your array!");
		System.out.println("Enter a word to search for : ");
		String search = in.next();
		in.close();
		
		System.out.println("\nLet's see...");
		int result = stringInArray(words, search);
		
		if (result == -1)
		{
			System.out.println("noooooo.....couldn't find it sorry.");
		}
		else
		{
			System.out.println("Yeaaaaahhhhhh! Found '" + search + "' at index " + result);
		}
		
		System.out.println("Well, thanks for searching! G-Bye!");
	}
	
	public static int stringInArray(String[] theArray, String theSearch)
	{
		for (int i = 0; i < theArray.length; i++)
		{
			if (theArray[i].equals(theSearch) == true)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static boolean isVowel(char in)
	{
		switch (Character.toLowerCase(in))
		{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			{
				return true;
			}
			default:
			{
				return false;
			}
		}
	}
}

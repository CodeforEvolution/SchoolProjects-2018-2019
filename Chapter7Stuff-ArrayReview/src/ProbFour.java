import java.util.ArrayList;
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
				System.out.println(words[i]);
		}
		System.out.println();
	}
}

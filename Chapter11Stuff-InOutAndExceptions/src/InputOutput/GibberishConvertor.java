package InputOutput;

import java.io.File;
import java.net.URI;
import java.util.Scanner;

public class GibberishConvertor {
	public static void main(String[] args)
	{
		/* File opening and setup */
		Scanner in = new Scanner(System.in);


		String filePath = "";
		Scanner fileReader = null;

		System.out.println("Welcome!");

		boolean ok = false;
		do
		{
			ok = true;
			System.out.println("Enter the path to a file you'd like to read: ");
			filePath = "file://" + in.next();

			System.out.println("\nChecking path and attempting to open the file...");

			try {
				fileReader = new Scanner(new File(new URI(filePath)));
			} catch (Exception e) {
				System.out.println("\nWe couldn't open that file...try again please.\n");
				ok = false;
			}
		} while (ok == false);
		in.close();

		System.out.println("Success!");


		/* Convert to Gibberish! */
		String output = "";

		// We go line by line, avoids having to detect newline character
		while (fileReader.hasNextLine())
		{
			String line = fileReader.nextLine();
			String[] words = line.split(" ");

			for (int count = 0; count < words.length; count++)
			{
				output += wordToGibberish(words[count]) + " ";
			}

			output += "\n";
		}

		System.out.println("\nThe Converted File: ");
		System.out.println(output);
	}

	private static String wordToGibberish(String inWord)
	{
		char[] splitWord = inWord.toCharArray();
		String out = "";

		// We split the word chunk into the word and possible punctuation
		int wordEnd = 0;
		for (int count = 0; count < splitWord.length; count++)
		{
			if (Character.isAlphabetic(splitWord[count]) == false)
				break;

			wordEnd++;
		}

		String word = inWord.substring(0, wordEnd) + "a";
		String punctuation = inWord.substring(wordEnd, inWord.length());

		out += word;
		out += punctuation;

		return out;
	}
}

package InputOutput;

import java.io.File;
import java.net.URI;
import java.util.Scanner;

public class FileStatsReader {
	public static void main(String[] args)
	{
		/* File opening and setup */
		Scanner in = new Scanner(System.in);

		Scanner fileReader = null;
		File inputFile = null;
		String filePath = "";
		URI path = null;

		System.out.println("Welcome!");

		boolean ok = false;
		do
		{
			ok = true;
			System.out.println("Enter the path to a file you'd like to read: ");
			filePath = "file://" + in.next();

			System.out.println("\nChecking path and attempting to open the file...");

			try {
				path = new URI(filePath);
				inputFile = new File(path);
				fileReader = new Scanner(inputFile);
			} catch (Exception e) {
				System.out.println("\nWe couldn't open that file...try again please.\n");
				ok = false;
			}
		} while (ok == false);

		System.out.println("Success!");

		/* Statistic counting!!! */
		int characters = characterCount(fileReader);
		int words = wordCount(fileReader);
		int lines = lineCount(fileReader);

		System.out.println("\nLines in file: " + lines);
		System.out.println("\nWords in file: " + words);
		System.out.println("\nChars in file: " + characters);
	}

	public static int characterCount(Scanner input)
	{
		int count = 0;

		return count;
	}

	public static int wordCount(Scanner input)
	{
		int count = 0;

		return count;
	}

	public static int lineCount(Scanner input)
	{
		int count = 0;

		return count;
	}
}

package InputOutput;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Scanner;

public class FileStatsReader {
	public static void main(String[] args)
	{
		/* File opening and setup */
		Scanner in = new Scanner(System.in);

		URI fileLocation = null;
		String filePath = "";

		System.out.println("Welcome!");

		boolean ok = false;
		do
		{
			ok = true;
			System.out.println("Enter the path to a file you'd like to read: ");
			filePath = "file://" + in.next();

			System.out.println("\nChecking path and attempting to open the file...");

			try {
				fileLocation = new URI(filePath);
			} catch (Exception e) {
				System.out.println("\nWe couldn't open that file...try again please.\n");
				ok = false;
			}
		} while (ok == false);
		in.close();

		System.out.println("Success!");

		/* Statistic counting!!! */
		int characters = -1;
		int words = -1;
		int lines = -1;

		try
		{
			characters = characterCount(fileLocation);
			words = wordCount(fileLocation);
			lines = lineCount(fileLocation);
		}
		catch (Exception e)
		{
			System.out.println("Couldn't read statistics of file!!");
			e.printStackTrace();
		}

		System.out.println("\nChars in file: " + characters);
		System.out.println("\nWords in file: " + words);
		System.out.println("\nLines in file: " + lines);
	}

	private static int characterCount(URI input) throws Exception
	{
		int count = 0;
		FileReader reader = new FileReader(new File(input));

		while (reader.read() != -1)
		{
			count++;
		}

		reader.close();

		return count;
	}

	private static int wordCount(URI input) throws Exception
	{
		int count = 0;
		Scanner reader = new Scanner(new File(input));

		while (reader.hasNext())
		{
			count++;
			reader.next();
		}

		reader.close();

		return count;
	}

	private static int lineCount(URI input) throws Exception
	{
		int count = 0;
		Scanner reader = new Scanner(new File(input));

		while (reader.hasNextLine())
		{
			count++;
			reader.nextLine();
		}

		reader.close();

		return count;
	}
}

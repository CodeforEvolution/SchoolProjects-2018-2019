package InputOutput;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Scanner;

public class FileStatsReaderDeluxe {
	public static void main(String[] args)
	{
		/* Overall Stats */
		int totalCharacters = 0;
		int totalWords = 0;
		int totalLines = 0;
		
		/* File opening and setup */
		Scanner in = new Scanner(System.in);

		URI fileLocation = null;
		String filePath = "";

		System.out.println("Welcome!");
		System.out.println("Enter different file names to get overall statistics for them!");
		System.out.println("Type a non-existant file when you are done giving files to read.");
		
		boolean nextFile = true;
		do
		{
			System.out.println("\nAn incoming file...");
			System.out.println("Enter the path to a file you'd like to read: ");
			filePath = "file://" + in.next();

			System.out.println("\nChecking path and attempting to open the file...");

			try {
				fileLocation = new URI(filePath);
				File temp = new File(fileLocation);
				if (temp.exists() == false)
					nextFile = false;
			} catch (Exception e) {
				System.out.println("\nThat file wouldn't open, so it's time for the final stats!");
				nextFile = false;
			}
			
			if (nextFile == false)
				break;
	
			System.out.println("Success!");
	
			/* Statistic counting!!! */
			int characters = 0;
			int words = 0;
			int lines = 0;
	
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
				System.out.println("\nLet's continue anyway...");
			}
			
			System.out.println("\nChars in file: " + characters);
			System.out.println("\nWords in file: " + words);
			System.out.println("\nLines in file: " + lines);
			
			totalCharacters += characters;
			totalWords += words;
			totalLines += lines;
		} while (nextFile == true);
		in.close();
		
		System.out.println("\nIt's time for the overall stats!!!");
		System.out.println("\nChars overall: " + totalCharacters);
		System.out.println("\nWords overall: " + totalWords);
		System.out.println("\nLines overall: " + totalLines);
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

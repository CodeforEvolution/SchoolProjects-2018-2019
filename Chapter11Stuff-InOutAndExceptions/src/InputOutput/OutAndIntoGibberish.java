package InputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class OutAndIntoGibberish {
	public static void main(String[] args)
	{
		ArrayList<String> lines = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		File fileHandle = null;
		FileOutputStream writer = null;

		System.out.println("Welcome! Please enter some sentences.");
		System.out.println("When done, type a line with just a space and press enter:");

		boolean more = true;
		do
		{
			String temp = in.nextLine();
			if (temp.equals(" "))
			{
				more = false;
			}
			else
			{
				lines.add(temp);
			}

		} while (more == true);
		in.close();

		boolean ok = false;
		do
		{
			ok = true;
			System.out.println("Create a file to store these sentences in... ");

			JFileChooser chooser = new JFileChooser();
			int result = chooser.showDialog(null, "Create file");
			System.out.println("Let's see...\n");

			if (result == JFileChooser.APPROVE_OPTION)
			{
				try
				{
					fileHandle = chooser.getSelectedFile();
					if (fileHandle.createNewFile())
					{
						System.out.println("Your file was created!");
					}
					else
					{
						System.out.println("That file already exists...please try a different file name!");
						ok = false;
					}
				}
				catch (Exception e)
				{
					System.out.println("You can't create a file there! Try a different directory please!");
					ok = false;
				}
			}
			else
			{
				System.out.println("You didn't choose a file? Well, goodbye!");
				return;
			}
		} while (ok == false);

		/* Writer stuff */

		System.out.println("\nSaving your sentences to file at: " + fileHandle.getAbsolutePath());

		try
		{
			writer = new FileOutputStream(fileHandle);
		}
		catch (IOException e)
		{
			System.out.println("Couldn't open the file to write to...sorry...");
			return;
		}

		for (int count = 0; count < lines.size(); count++)
		{
			byte[] raw = lines.get(count).getBytes();
			try {
				writer.write(raw);
				writer.write("\n".getBytes());
			} catch (IOException e) {
				System.out.println("Couldn't write a line to the file, quitting...");
				return;
			}
		}

		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* Reading back from the file */
		Scanner reader = null;

		try {
			reader = new Scanner(fileHandle);
		} catch (FileNotFoundException e) {
			System.out.println("You sly dog, did you delete the file before I tried to read it again? :)");
			return;
		}

		System.out.println("Reading the file back and translating it to Gibberish...");
		while (reader.hasNext())
		{
			System.out.print(reader.next());
		}

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

		/* The actual word, translate it into gibberish! */
		String word = inWord.substring(0, wordEnd);
		char[] temp = word.toCharArray();

		for (int count = 0; count < temp.length; count++)
		{
			/* All gibberish rules */
			switch (temp[count])
			{
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					word = word.substring(0, count) + "b" + temp[count] + "g" + word.substring(count, word.length());
					break;
				default:
					word += "yes" + word;
					break;
			}
		}

		/* The punctuation */
		String punctuation = inWord.substring(wordEnd, inWord.length());

		out += word;
		out += punctuation;

		return out;
	}
}

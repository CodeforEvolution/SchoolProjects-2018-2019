package InputOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class FloatInputer {
	public static void main(String[] args)
	{
		ArrayList<Float> userInput = new ArrayList<Float>();
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\n");

		System.out.println("Hey my dude! Enter 5 floats please:");

		for (int count = 0; count < 5; count++)
		{
			boolean ok = false;
			do
			{
				ok = true;
				System.out.print("\nEnter float #" + (count + 1) + " please: ");

				String input = "";
				float temp = 0;
				try
				{
					input = in.next();

					if (input.equals(" "))
					{
						System.out.println("Goodbye!");
						return;
					}

					temp = new Float(input);
				}
				catch (NumberFormatException e)
				{
					System.out.println("Yeah...that isn't a float, try again please!");
					ok = false;
				}

				if (ok == true)
					userInput.add(temp);

			} while (ok == false);
		}
		in.close();

		System.out.println("\nThanks!!! Let's find the sum of these floats...");
		float sum = 0;

		for (int count = 0; count < userInput.size(); count++)
		{
			sum += userInput.get(count);
		}

		System.out.println("Here we go! The sum is: " + sum);
	}
}

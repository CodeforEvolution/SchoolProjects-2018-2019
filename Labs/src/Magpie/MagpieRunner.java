package Magpie;

import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner (System.in);

		System.out.println("Good day, who is this?");
		User you = new User(in.nextLine());

		Magpie maggie = new Magpie(you);
		maggie.setUp();
		maggie.giveWelcome();

		String statement = "";
		while (!statement.equalsIgnoreCase("bye"));
		{
			statement = in.nextLine();
			System.out.println (maggie.getResponse(statement));
		}
		//maggie.sayBye();
	}
}

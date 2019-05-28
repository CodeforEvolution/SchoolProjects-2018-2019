package CircularLinkedList;

import java.util.Scanner;

public class MakeSpeechFriendCommunicator {
	static Scanner in;
	static TheFriendLoop roster;

	public static void main(String[] args)
	{
		in = new Scanner(System.in);
		roster = new TheFriendLoop();

		System.out.println("\\--------------------------------\\");
		System.out.println("Welcome to \"In The Friend Zone!\"");
		System.out.println("\\--------------------------------\\\n");

		while (true)
		{
			System.out.println("\nWhat would you like todo now?");
			System.out.println("A) Add a friend,\n"
							 + "N) Nickname a person,\n"
							 + "RF) Reduce the friend count for a person,\n"
							 + "IF) Increase the friend count for a person,\n"
							 + "D) Remove a friend,\n"
							 + "P1) Print out all your friends,\n"
							 + "P2) Print all friends,\n"
							 + "F) Print out friends that are older than a certain age\n"
							 + "Q) Quit this program");
			System.out.print("---> ");

			boolean going = false;
			do
			{
				going = doAction(in.next());
				if (going == false)
					System.out.println("\nYikes, that's not a command...please try again!\n");
			} while (going == false);
		}
	}

	public static boolean doAction(String input)
	{
		switch (input.toUpperCase())
		{
			case "A":
				doAdd();
				break;
			case "N":
				doReNickName();
				break;
			case "RF":
				doLessFriends();
				break;
			case "IF":
				doMoreFriends();
				break;
			case "D":
				doDelete();
				break;
			case "P1":
				doPrintAll();
				break;
			case "P2":
				doPrintPos();
				break;
			case "F":
				doPrintOlder();
				break;
			case "Q":
				doQuit();
				break;
			default:
				return false;
		}

		return true;
	}

	public static void doAdd()
	{
		String name = "";
		String nickName = "";
		int age = 0;

		System.out.println("Time to add a friend!");
		System.out.println("What is their name?");
		name = in.next();
		System.out.println("What is their nick name?");
		nickName = in.next();
		System.out.println("What is their age?");
		age = in.nextInt();

		FriendsNode toAdd = new FriendsNode(name, nickName, age);
		roster.add(toAdd);

		System.out.println("\nAlright, " + toAdd.getName() + " has been added!");
	}

	public static void doReNickName()
	{
		String name = "";

		boolean again = true;
		do
		{
			System.out.println("Please enter a name to change their nick name:");
			name = in.next();

			if (roster.exists(name))
				again = false;
			else
				System.out.println("That isn't a name on the list, please try again!");

		} while (again == true);

		System.out.println("What should " + name + "'s new nick be:");
		roster.changeNickName(name, in.next());

		System.out.println("Success!");
	}

	public static void doLessFriends()
	{
		String name = "";

		boolean again = true;
		do
		{
			System.out.println("Please enter a name to remove a friend from their friend count:");
			name = in.next();

			if (roster.exists(name))
				again = false;
			else
				System.out.println("That isn't a name on the list, please try again!");

		} while (again == true);

		roster.decreaseFriends(name, 1);
		System.out.println("Awesome! " + name + " now has 1 less friend!");
	}

	public static void doMoreFriends()
	{
		String name = "";

		boolean again = true;
		do
		{
			System.out.println("Please enter a name to add a friend to their friend count:");
			name = in.next();

			if (roster.exists(name))
				again = false;
			else
				System.out.println("That isn't a name on the list, please try again!");

		} while (again == true);

		roster.increaseFriends(name, 1);
		System.out.println("Awesome! " + name + " now has 1 more friend!");
	}

	public static void doDelete()
	{
		String nickName = "";

		boolean again = true;
		do
		{
			System.out.println("Please enter a nickname of a person to remove from the friend list:");
			nickName = in.next();

			if (roster.exists(nickName))
				again = false;
			else
				System.out.println("This isn't a nick name on the list, please try again!");
		} while (again == true);

		roster.delete(nickName);
		System.out.println(nickName + " is no longer a friend!");
	}

	public static void doPrintAll()
	{
		System.out.println("\nHere are your friends: " + roster.printListAt(null));
	}

	public static void doPrintPos()
	{
		String name = "";

		boolean again = true;
		do
		{
			System.out.println("Please enter a name to print your friend list from:");
			name = in.next();

			if (roster.exists(name))
				again = false;
			else
				System.out.println("That isn't a name on the list, please try again!");

		} while (again == true);

		System.out.println("Awesome! Here you go: " + roster.printListAt(name));
	}

	public static void doPrintOlder()
	{
		int age = 0;

		boolean again = true;
		do
		{
			again = false;
			System.out.println("Please enter an age that all friends older than will be printed out:");

			try
			{
				age = in.nextInt();
			} catch (Exception e) {
				System.out.println("That isn't an age...please try again!");
				again = true;
			}

		} while(again == true);

		System.out.println("Here's everyone older than " + age + ": " + roster.printOlderThan(age));
	}

	public static void doQuit()
	{
		in.close();
		System.out.println("\nThank you for visiting, \"In the Friend Zone!\"");
		System.exit(0);
	}
}

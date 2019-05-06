package MoreLinkedList2;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedContacts {
	public LinkedContacts()
	{

	}

	public static void main(String[] args)
	{
		LinkedList<Contacts> logbook = new LinkedList<Contacts>();

		Contacts excellentMan = new Contacts("Excellent", "6666666666", 666);

		logbook.addFirst(new Contacts("Joe", "2627894567", 15));
		logbook.add(new Contacts("Bob", "4142920000", 99));
		logbook.add(1, new Contacts("Bro", "5555555555", 150));
		logbook.addLast(new Contacts("Marsty", "1234567890", 30));
		logbook.add(2, excellentMan);
		logbook.addLast(excellentMan);
		logbook.addFirst(excellentMan);

		System.out.println(logbook);

		logbook.remove(1);
		logbook.removeFirst();
		logbook.removeLast();
		logbook.removeFirstOccurrence(excellentMan);

		System.out.println(logbook);

		ListIterator<Contacts> it = logbook.listIterator();

		while (it.hasNext())
		{
			if (it.next().getName().equals("Bob"))
			{
				System.out.println("\nBob was here!");
				System.out.println("Not Bob!!!!");
				it.set(new Contacts("Bye Bob", "!", -1));
			}
		}

		System.out.println("\n" + logbook);
	}
}

package CircularLinkedList;

public class TheFriendLoop {
	private FriendsNode theLoop;
	private int countInTheLoop;

	public TheFriendLoop()
	{
		theLoop = null;
		countInTheLoop = 0;
	}

	public void add(FriendsNode friend)
	{
		// Make the main list the node
		if (theLoop == null)
		{
			theLoop = friend;
			theLoop.setNextFriend(theLoop);
		}
		// Append to the list's end, sortLoop() will take care of the order
		else
		{
			FriendsNode whereNow = theLoop;

			for (int count = 0; count < countInTheLoop; count++)
			{
				whereNow = whereNow.getNextFriend();
			}

			whereNow.setNextFriend(friend);
			friend.setNextFriend(theLoop);
		}

		sortLoop();

		countInTheLoop++;
	}

	public int size()
	{
		return countInTheLoop;
	}

	public String toString()
	{
		String result = "";
		FriendsNode current = theLoop;

		while (current != null)
		{
			result += current.toString() + "\n";
			current = current.getNextFriend();
		}

		return result;
	}

	private void sortLoop()
	{
		FriendsNode current = null;

		for (int loops = 0; loops < countInTheLoop; loops++)
		{
			current = theLoop;

			for (int index = 0; index < countInTheLoop - 1; index++)
			{
				if (current.compareTo(current.getNextFriend()) > 0)
					swapFriends(current, index, index + 1);

				current = current.getNextFriend();
			}
		}
	}

	private void swapFriends(FriendsNode people, int first, int second)
	{

	}
}

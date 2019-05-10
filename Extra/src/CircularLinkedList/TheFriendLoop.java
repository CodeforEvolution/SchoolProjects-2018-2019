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

			int count = 0;
			for (count = 0; count < countInTheLoop; count++)
			{
				whereNow = whereNow.getNextFriend();

				if (whereNow.compareTo(friend) <= 0)
				{
					if (count > 0 && count < countInTheLoop)
					{
						FriendsNode temp = whereNow.getNextFriend();

						whereNow.setNextFriend(friend);
						friend.setNextFriend(temp);

						break;
					}
					else if (count == 0 || count == countInTheLoop - 1)
					{
						whereNow.setNextFriend(friend);
						friend.setNextFriend(theLoop);

						break;
					}
				}
			}
		}

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

		for (int count = 0; count < countInTheLoop; count++)
		{
			result += current.toString() + "\n";
			current = current.getNextFriend();
		}

		return result;
	}
}

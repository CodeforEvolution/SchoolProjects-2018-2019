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
		addAtIndex(friend, determineNodePlacement(friend));
		countInTheLoop++;
		updateFriendCount();
	}

	private int determineNodePlacement(FriendsNode friend)
	{
		if (theLoop == null)
			return 0;

		FriendsNode curr = theLoop;

		for (int count = 0; count <= countInTheLoop; count++)
		{
			if (friend.compareTo(curr) <= 0)
				return count;
		}

		return countInTheLoop;
	}

	private void addAtIndex(FriendsNode node, int index)
	{
		if (index < 0 || index > countInTheLoop)
			throw new IndexOutOfBoundsException();

		if (index == 0)
		{
			addEdge(node, true);
			return;
		}
		if (index == countInTheLoop)
		{
			addEdge(node, false);
			return;
		}


		//Something wrong VVVVV
		FriendsNode curr = theLoop;
		for (int place = 0; place < index - 1; place++)
		{
			curr = curr.getNextFriend();
		}

		FriendsNode grip = curr.getNextFriend().getNextFriend();

		curr.setNextFriend(node);
		node.setNextFriend(grip);
	}

	private void addEdge(FriendsNode friend, boolean first)
	{
		if (theLoop == null)
		{
			theLoop = friend;
			theLoop.setNextFriend(theLoop);
			return;
		}

		FriendsNode last = theLoop;

		for (int count = 0; count < countInTheLoop - 1; count++)
		{
			last = last.getNextFriend();
		}

		last.setNextFriend(friend);
		friend.setNextFriend(theLoop);

		if (first)
			theLoop = friend;
	}

	private void updateFriendCount()
	{
		FriendsNode loop = theLoop;

		for (int count = 0; count < countInTheLoop; count++)
		{
			loop.setFriendCount(countInTheLoop - 1);
			loop = loop.getNextFriend();
		}
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

	private void addOld(FriendsNode friend)
	{
		// Make the main list the node
		if (theLoop == null)
		{
			theLoop = friend;
			theLoop.setNextFriend(theLoop);
		}
		else
		{
			FriendsNode whereNow = theLoop;

			for (int count = 0; count <= countInTheLoop; count++)
			{
				if (friend.compareTo(whereNow) <= 0)
				{
					if (count > 0 && count < countInTheLoop - 1)
					{
						FriendsNode before = theLoop;
						for (int beforeC = 0; beforeC < count - 2; beforeC++)
						{
							before = before.getNextFriend();
						}

						before.setNextFriend(friend);
						friend.setNextFriend(whereNow);

						break;
					}
					else if (count == 0)
					{
						addEdge(friend, true);
						break;
					}
					else if (count == countInTheLoop)
					{
						addEdge(friend, false);
						break;
					}
				}

				whereNow = whereNow.getNextFriend();
			}
		}

		countInTheLoop++;
	}
}

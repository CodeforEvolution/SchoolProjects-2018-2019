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
		else
		{
			FriendsNode whereNow = theLoop;

			for (int count = 0; count < countInTheLoop; count++)
			{
				if (friend.compareTo(whereNow) <= 0)
				{
					if (count > 0 && count < countInTheLoop)
					{
						FriendsNode before = theLoop;
						for (int beforeC = 0; beforeC < count + 1; beforeC++)
						{
							before = before.getNextFriend();
						}

						before.setNextFriend(friend);
						friend.setNextFriend(whereNow);

//						FriendsNode temp = whereNow.getNextFriend();
//
//						friend.setNextFriend(whereNow);
//						whereNow.setNextFriend(temp);

						break;
					}
					else if (count == 0)
					{
						addEdge(friend, true);
						break;
					}
				}
				else if (count == countInTheLoop)
				{
					addEdge(friend, false);
					break;
				}

				whereNow = whereNow.getNextFriend();
			}
		}

		countInTheLoop++;
	}

	private void addEdge(FriendsNode node, boolean first)
	{
		FriendsNode curr = theLoop;

		for (int count = 0; count < countInTheLoop; count++)
		{
			curr = curr.getNextFriend();
		}

		curr.setNextFriend(node);
		node.setNextFriend(theLoop);

		if (first)
			theLoop = node;
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

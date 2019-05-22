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
		//updateFriendCount(); // Auto Friend add
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

			curr = curr.getNextFriend();
		}

		return -1;
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

		FriendsNode curr = theLoop;
		for (int place = 0; place < index; place++)
		{
			curr = curr.getNextFriend();
		}

		FriendsNode grip = curr.getNextFriend();

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

	public void changeNickName(String oldName, String newName)
	{
		FriendsNode loop = theLoop;

		for (int index = 0; index < countInTheLoop; index++)
		{
			if (loop.getNickName().equals(oldName))
			{
				loop.setNickName(newName);
				break;
			}

			loop = loop.getNextFriend();
		}
	}

	public void increaseFriends(String who, int howManySlavIMeanFriends)
	{
		FriendsNode loop = theLoop;

		for (int index = 0; index < countInTheLoop; index++)
		{
			if (loop.getName().equals(who))
			{
				loop.setFriendCount(loop.getFriendCount() + howManySlavIMeanFriends);
			}
		}
	}

	public void decreaseFriends(String who, int howMuchLonelier)
	{
		FriendsNode loop = theLoop;

		for (int index = 0; index < countInTheLoop; index++)
		{
			if (loop.getName().equals(who))
			{
				loop.setFriendCount(loop.getFriendCount() - howMuchLonelier);
			}
		}
	}

	public int size()
	{
		return countInTheLoop;
	}

	public String printListAt(String who)
	{
		String result = "";
		int count = 0;

		if (who == null)
			count = 0;
		else
		{

		}

		// WIP
		FriendsNode current = theLoop;
		for (count = 0; count < countInTheLoop; count++)
		{
			result += current.toString() + "\n";
			current = current.getNextFriend();
		}

		return result;
	}

	public String toString()
	{
		return printListAt(null);
	}
}

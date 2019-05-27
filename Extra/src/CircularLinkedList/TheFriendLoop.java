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

	public void delete(String nickName)
	{
		FriendsNode current = theLoop;
		int count = 0;

		for (count = 0; count < countInTheLoop; count++)
		{
			if (current.getNextFriend().getNickName().equals(nickName))
				break;

			current = current.getNextFriend();
		}

		if (count > 0 || count < countInTheLoop - 1)
		{
			FriendsNode before = theLoop;
			for (int index = 0; index < count - 1; index++)
				before = before.getNextFriend();

			before.setNextFriend(before.getNextFriend().getNextFriend());
		}
		else
		{
			FriendsNode almostLast = theLoop;
			for (int where = 0; where < countInTheLoop - 1; where++)
				almostLast = almostLast.getNextFriend();

			if (count == 0)
			{
				almostLast = almostLast.getNextFriend();
				theLoop = theLoop.getNextFriend();
				almostLast.setNextFriend(theLoop);
			}
			else
				almostLast.setNextFriend(theLoop);
		}

		countInTheLoop--;
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

	public boolean exists(String who)
	{
		FriendsNode current = theLoop;
		for (int count = 0; count < countInTheLoop; count++)
		{
			if (current.getName().equals(who) || current.getNickName().equals(who))
				return true;
			current = current.getNextFriend();
		}

		return false;
	}

	public int size()
	{
		return countInTheLoop;
	}

	public String printOlderThan(int ageOrOlder)
	{
		String out = "";

		FriendsNode current = theLoop;
		for (int count = 0; count < countInTheLoop; count++)
		{
			if (current.getAge() > ageOrOlder)
				out += current.toString() + "\n";

			current = current.getNextFriend();
		}

		return out;
	}

	public String printListAt(String who)
	{
		String result = "";
		FriendsNode current = theLoop;

		if (who != null)
		{
			int place = 0;
			while (!current.getName().equals(who) && place < countInTheLoop)
			{
				current = current.getNextFriend();
				place++;
			}
		}

		for (int count = 0; count < countInTheLoop; count++)
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
}

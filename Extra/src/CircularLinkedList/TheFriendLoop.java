package CircularLinkedList;

public class TheFriendLoop {
	private FriendsNode theLoop;
	private int countInTheLoop;

	public TheFriendLoop()
	{
		theLoop = null;
		countInTheLoop = 0;
	}

	public void add(FriendsNode friend, int where)
	{
		if (where < 0 || where > countInTheLoop)
		{
			throw new IndexOutOfBoundsException("This friend has gone where no friend has gone before.");
		}
		else if (theLoop == null)
		{
			theLoop = friend;
			theLoop.setNextFriend(theLoop);
		}
		else if (where == 0)
		{
			//addFirst(friend);
		}
		else if (where == countInTheLoop - 1)
		{
			//addLast(friend);
		}
		else
		{
			for (int c = 1; c < index )
		}

		sortLoop();

		countInTheLoop++;
	}

	private void addFirst(FriendsNode vip)
	{

	}

	private void addLast(FriendsNode lastButNotLeast)
	{

	}

	private void sortLoop()
	{
		FriendsNode current;

		for (int loops = 0; loops < countInTheLoop; loops++)
		{
			current = theLoop;

			for (int index = 0; index < countInTheLoop - 1; index++)
			{
				if (current > current.getNextFriend())
					swapFriends(index, index + 1);

				current = current.getNextFriend();
			}
		}
	}

	private void swapFriends(int first, int second)
	{

	}
}

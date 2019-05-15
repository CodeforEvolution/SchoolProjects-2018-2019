package CircularLinkedList;

public class MakeSpeechFriendCommunicator {
	public static void main(String[] args)
	{
		TheFriendLoop roster = new TheFriendLoop();
		roster.add(new FriendsNode("Mitchell", "Plant", 17));
		roster.add(new FriendsNode("Jake", "Jakey", 17));
		roster.add(new FriendsNode("Leighton", "Lays", 17));
		roster.add(new FriendsNode("Nhut", "Yes", 18));

		System.out.println(roster);
	}
}

package CircularLinkedList;

public class MakeSpeechFriendCommunicator {
	public static void main(String[] args)
	{
		TheFriendLoop roster = new TheFriendLoop();
		roster.add(new FriendsNode("Jake", "Jakey", 17, null));

		System.out.println(roster);
	}
}

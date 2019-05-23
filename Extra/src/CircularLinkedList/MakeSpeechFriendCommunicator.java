package CircularLinkedList;

public class MakeSpeechFriendCommunicator {
	public static void main(String[] args)
	{
		TheFriendLoop roster = new TheFriendLoop();
		roster.add(new FriendsNode("Savir", "Severe", 17));
		roster.add(new FriendsNode("Nhut", "Yes", 17));
		roster.add(new FriendsNode("Mitchell", "Plant", 17));
		roster.add(new FriendsNode("Leighton", "Lays", 17));
		roster.add(new FriendsNode("Jake", "Jakey", 17));
		roster.add(new FriendsNode("Gabe", "Babe", 17));
		roster.add(new FriendsNode("Ay", "Jakey", 17));
		roster.add(new FriendsNode("Zeybra", "Jakey", 17));
		roster.add(new FriendsNode("Jake", "Jakey", 17));

		System.out.println(roster);

		System.out.println("\n\n\n------\n\n\n");

		roster.delete("Babe");
		roster.delete("Lays");
		roster.delete("Yes");

		System.out.println(roster);
	}
}

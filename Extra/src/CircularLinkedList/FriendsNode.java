package CircularLinkedList;

public class FriendsNode implements Comparable<FriendsNode> {
	private String name;
	private String nickName;
	private int age;
	private int friendCount;
	private FriendsNode nextFriend;

	public FriendsNode(String theName, String theNickName, int theAge, int theFriendCount, FriendsNode myNextFriend)
	{
		setName(theName);
		setNickName(theNickName);
		setAge(theAge);
		setFriendCount(theFriendCount);
		setNextFriend(myNextFriend);
	}

	public String getName() {
		return name;
	}

	public void setName(String who) {
		name = who;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String theyCallMe) {
		nickName = theyCallMe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int byeYouth) {
		age = byeYouth;
	}

	public int getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(int amILonely) {
		friendCount = amILonely;
	}

	public FriendsNode getNextFriend() {
		return nextFriend;
	}

	public void setNextFriend(FriendsNode next) {
		nextFriend = next;
	}

	@Override
	public int compareTo(FriendsNode judge)
	{
		return this.getName().compareTo(judge.getName());
	}

}

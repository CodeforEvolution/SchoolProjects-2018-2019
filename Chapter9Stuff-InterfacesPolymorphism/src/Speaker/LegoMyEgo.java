package Speaker;

public class LegoMyEgo implements Speaker {
	private String theName;
	
	public LegoMyEgo(String name)
	{
		theName = name;
	}
	
	public void speak()
	{
		System.out.println("YEEEAAAAHHH BOI (says " + theName + ")" );
	}
}

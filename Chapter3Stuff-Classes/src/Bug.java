public class Bug {
	private String myName;
	private boolean left;
	private int distance;

	public Bug(String bugName, int howFar)
	{
		myName = bugName;
		left = false;
		distance = howFar;
	}
	
	public void move()
	{
		if (left == false)
			distance++;
		else
			distance--;
	}
	
	public void move(int amount)
	{
		if (left == false)
			distance += amount;
		else
			distance -= amount;
	}
	
	public void turn()
	{
		left = !left;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public int getPosition()
	{
		return distance;
	}
	
	public String toString()
	{
		String out = "\n";
		out += myName + ":\n";
		out += "\tDistance: " + distance + "\n";
		out += "\tDirection: ";
		if (left == true)
			out += "left";
		else
			out += "right";
		out += "\n";
		
		return out;
	}
}

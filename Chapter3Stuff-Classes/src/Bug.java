public class Bug {
	private String myName;
	private boolean left;
	private int distance;

	public Bug(int howFar)
	{
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
	
	public void turn()
	{
		left = !left;
	}
	
	public int getPosition()
	{
		return distance;
	}
	
	public String toString()
	{
		String out = "\n";
		out += myName + ":";
	}
}

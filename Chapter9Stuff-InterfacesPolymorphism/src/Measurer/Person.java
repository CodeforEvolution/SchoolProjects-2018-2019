package Measurer;

public class Person {
	private String myName;
	private double myHeight;
	
	public Person(String theirName, double heightInches)
	{
		myName = theirName;
		myHeight = heightInches;
	}
	
	public String getName()
	{
		return myName;
	}

	public double getHeight()
	{
		return myHeight;
	}
	
	public String toString()
	{
		return myName + " is " + myHeight + " inches tall.";
	}
}

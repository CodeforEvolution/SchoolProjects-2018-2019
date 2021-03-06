package Measurer;

public class PersonMeasurer implements Measurer {
	@Override
	public double measure(Object theObject)
	{
		if (theObject instanceof Person)
		{
			Person life = (Person)theObject;
			return life.getHeight();
		}
		return -1.0;
	}
	
	public static void main(String[] args)
	{
		Person yay = new Person("Jimmy", 18.0);
		Person hurray = new Person("L", 49.0);
		Person yippee = new Person("Whoa", 27.9);
		
		DataInASet newAndImproved = new DataInASet(new PersonMeasurer());
		newAndImproved.add(yay);
		newAndImproved.add(hurray);
		newAndImproved.add(yippee);
		
		Person max = (Person)newAndImproved.getMaximum();
		Person min = (Person)newAndImproved.getMinimum();
		
		System.out.println("Average height of my people: " + newAndImproved.getAverage());
		System.out.println("The tallest person is " + max.getName() + " with a height of " + max.getHeight());
		System.out.println("The shortest person is " + min.getName() + " with a height of " + min.getHeight());
	}
}

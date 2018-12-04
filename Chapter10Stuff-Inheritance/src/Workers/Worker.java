package Workers;

public abstract class Worker {
	private String myName;
	protected double myWage;
	
	public Worker(String theName, double theWage)
	{
		myName = theName;
		myWage = theWage;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public double getSalary()
	{
		return myWage;
	}
	
	public abstract double computePay(int theHours);
}

package Workers;

public abstract class Worker {
	private String myName;
	protected double mySalary;
	
	public Worker(String theName, double theRateOSalary)
	{
		myName = theName;
		mySalary = theRateOSalary;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public double getSalary()
	{
		return mySalary;
	}
	
	public abstract double computePay(int theHours);
}

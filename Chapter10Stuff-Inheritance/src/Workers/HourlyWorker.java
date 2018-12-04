package Workers;

public class HourlyWorker extends Worker {

	public HourlyWorker(String theName, double theRateOSalary) {
		super(theName, theRateOSalary);
	}
	
	public double computePay(int theHours)
	{
		if (theHours < 0)
			throw new IllegalArgumentException("Hours can't be less than 0!");
		
		if (theHours <= 40)
			return theHours * myWage;
		else
			return (40 * myWage) + ((theHours - 40) * (myWage * 1.5));
	}
}

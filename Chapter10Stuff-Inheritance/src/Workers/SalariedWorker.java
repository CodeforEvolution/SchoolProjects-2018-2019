package Workers;

public class SalariedWorker extends Worker {

	public SalariedWorker(String theName, double theRateOSalary) {
		super(theName, theRateOSalary);
	}

	public double computePay(int theHours)
	{
		if (theHours < 0)
			throw new IllegalArgumentException("Hours can't be less than 0!");
		
		if (theHours <= 40)
			return theHours * mySalary;
		else
			return (40 * mySalary) + ((theHours - 40) * mySalary);
	}

}

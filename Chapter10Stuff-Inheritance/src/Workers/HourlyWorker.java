package Workers;

public class HourlyWorker extends Worker {

	public HourlyWorker(String theName, double theRateOSalary) {
		super(theName, theRateOSalary);
	}
	
	public double computePay(int theHours)
	{
		return mySalary * 40;
	}
}

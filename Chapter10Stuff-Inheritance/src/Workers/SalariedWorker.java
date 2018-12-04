package Workers;

public class SalariedWorker extends Worker {

	public SalariedWorker(String theName, double theWage) {
		super(theName, theWage);
	}

	public double computePay(int theHours)
	{
		return myWage * 40;
	}
}

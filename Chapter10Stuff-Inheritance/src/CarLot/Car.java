package CarLot;

public class Car {
	private String myCreator;
	private int dateOBirth;
	private double myMileage;
	private double howManyBills;
	
	public Car (String make, int year, double mileage)
	{
		myCreator = make;
		dateOBirth = year;
		myMileage = mileage;
		howManyBills = 0;
	}
	
	public String getName()
	{
		return myCreator;
	}
	
	public int getModelYear()
	{
		return dateOBirth;
	}
	
	public double getMiles()
	{
		return myMileage;
	}
	
	public void setPrice(double thePrice)
	{
		howManyBills = thePrice;
	}
	
	public double getPrice()
	{
		return howManyBills;
	}
	
	public void takeTestRide(double miles)
	{
		myMileage += miles;
	}
	
	public String toString()
	{
		String out = "";
		
		out += "Make: " + myCreator + "\n";
		out += "\tYear: " + dateOBirth + "\n";
		out += "\tMileage: " + myMileage + "\n";
		out += "\tCost: $" + howManyBills + "\n";
		
		return out;
	}
}

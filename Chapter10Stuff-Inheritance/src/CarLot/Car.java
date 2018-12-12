package CarLot;

public class Car {
	private String myCreator;
	private int dateOBirth;
	private double myMileage;
	private double howManyBills;
	
	public Car(String make, int year, double mileage, double cost)
	{
		myCreator = make;
		dateOBirth = year;
		myMileage = mileage;
		howManyBills = cost;
	}
	
	public String getName()
	{
		return myCreator;
	}
	
	public int modelYear()
	{
		return dateOBirth;
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

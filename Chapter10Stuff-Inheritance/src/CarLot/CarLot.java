package CarLot;

import java.util.ArrayList;

public class CarLot {
	private static final int MAX_CARS = 500;
	private static int numberOfCars = 0;
	private Car[] theLot;
	
	public CarLot()
	{
		theLot = new Car[MAX_CARS];
	}
	
	public void addCar(Car aNewCar)
	{
		if (numberOfCars > MAX_CARS)
		{
			throw new IllegalStateException("The lot is completely full!");
		}
		
		theLot[numberOfCars] = aNewCar;
		numberOfCars++;
	}
	
	public void printCarsInLot()
	{
		for (int i = 0; i < numberOfCars; i++)
		{
			System.out.println(theLot[i] + "\n");
		}
	}
	
	private ArrayList<Car> findMatchingCars(int year, String make)
	{
		ArrayList<Car> matches = new ArrayList<Car>();
		
		for (int i = 0; i < numberOfCars; i++)
		{
			if (theLot[i].getModelYear() == year && theLot[i].getName().equals(make))
			{
				matches.add(theLot[i]);
			}
		}
		
		if (matches.isEmpty() == true)
			System.out.println("No matches found!");
		
		return matches;
	}
	
	public void printMatchingCars(int year, String make)
	{
		ArrayList<Car> toPrint = findMatchingCars(year, make);
		
		for (Car c : toPrint)
		{
			System.out.println(c + "\n");
		}
	}
}

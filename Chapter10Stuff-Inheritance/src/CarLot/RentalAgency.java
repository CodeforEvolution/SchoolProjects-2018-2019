package CarLot;

public class RentalAgency {
	public static void main(String[] args)
	{
		CarLot oily = new CarLot();
		
		Car subie = new Car("Subaru", 2010, 1000);
		subie.setPrice(8000);
		Car subie2 = new Car("Subaru", 2010, 0);
		subie2.setPrice(10000);
		
		Car vw = new Car("Volkswagen", 2014, 0);
		vw.setPrice(10000);
		
		Car electric = new Car("Tesla", 2018, 0);
		electric.setPrice(35000);
		
		oily.addCar(subie);
		oily.addCar(subie2);
		oily.addCar(vw);
		oily.addCar(electric);
		
		System.out.println("All of the cars: ");
		oily.printCarsInLot();
		
		
		System.out.println("\nTime to search for a subaru!");
		oily.printMatchingCars(2010, "Subaru");
		
		System.out.println("Back to the future!");
		oily.printMatchingCars(2050, "Deloreon");
	}
}


public class HereInMyCarTester {
	public static void main(String[] args)
	{
		Car shiny = new Car(24);
		Car theFuture = new Car(100);
		
		theFuture.addGas(5);
		shiny.addGas(20);
		
		theFuture.drive(350);
		shiny.drive(350);
		
		System.out.println("The future is here now with this car: ");
		System.out.println("With 5 gallons of gas and traveling 350 miles, the car still has!!!")
	}
}

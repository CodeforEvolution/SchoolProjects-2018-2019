
public class RoachSimulation {
	public static void main(String[] args)
	{
		RoachPopulation myRoach = new RoachPopulation(1);
		
		System.out.println("Just my roach");
		
		myRoach.breed();
		
		printAmount(myRoach);
		
		for (int i = 0; i < 5; i++)
		{
			myRoach.breed();
		}
		
		printAmount(myRoach);
		
		System.out.println("Oh no...I need some help here!!!");
		
		for (int i = 0; i < 7; i++)
		{
			myRoach.spray();
		}
		
		printAmount(myRoach);
		
		System.out.println("That's better! :)");
	}
	
	public static void printAmount(RoachPopulation popObj)
	{
		System.out.println("My roach colony now has " + popObj.getRoaches() + " roaches.");
	}
}


public class ChairTester {
	public static void main(String[] args) {
		Chair theChair = new Chair();
		Chair myChair = new Chair(20);
		
		System.out.println("Default Chair: " + theChair + "\n");
		System.out.println("My Chair: " + myChair + "\n");
		
		myChair.sawLegs();
		
		System.out.println("My sawed Chair: " + myChair + "\n");
		
		theChair.addLifter();
		
		System.out.println("The other chair is getting taller?!? : " + theChair + "\n");
		
		myChair.sawLegs();
		myChair.ripTheChair(5);
		
		System.out.println("My chair is ruined! : " + myChair);
	}
}

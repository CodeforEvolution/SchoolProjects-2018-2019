
public class DieTester {
	public static void main(String[] args)
	{
		Die basicDie = new Die();
		Die myDie = new Die(30);
		
		basicDie.roll();
		myDie.roll();
		
		System.out.println("Default Die: " + basicDie.getValue());
		System.out.println("My Die: " + myDie.getValue());
		
		System.out.println("\nLets add them both!");
		
		System.out.println ("Default and My Die adds up to: " + basicDie.addTwoDie(myDie));
		
		System.out.println("\nIt seems this die arrived late!");
		Die lateDie = new Die(13);

		lateDie.roll();
		
		System.out.println("\nCurrent values of dice: ");
		System.out.println("\tDefault: " + basicDie.getValue());
		System.out.println("\tMy Die: " + myDie.getValue());
		System.out.println("\tThe late one :D : " + lateDie.getValue());
		
		System.out.println("\nThey all add up to: " + basicDie.addThreeDie(myDie, lateDie));
		
		System.out.println("It seems we have used " + Die.getNumberDice() + " dice!");
		
		System.out.println("Two more dice?!? How rude...");
		Die loneDie = new Die(56);
		Die boiDie = new Die(300);
		
		loneDie.roll();
		boiDie.roll();
		
		System.out.println("These dice add up to: " + loneDie.addTwoDie(boiDie));
		System.out.println("With my die??? How profane: " + myDie.addThreeDie(loneDie, boiDie));
	}
}

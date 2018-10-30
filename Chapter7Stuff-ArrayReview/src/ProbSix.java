
public class ProbSix {
	public static void main(String[] args)
	{
		Phish[] salmon = new Phish[3];
		
		salmon[0] = new Phish("Carl");
		salmon[1] = new Phish("Jared", 100);
		salmon[2] = new Phish("Jerome");
		
		System.out.println("Our phishes: ");
		System.out.println(salmon[0]);
		System.out.println(salmon[1]);
		System.out.println(salmon[2]);
		System.out.println();
		
		System.out.println(salmon[0].getFishieName() + " eats " + salmon[1].getFishieName() + "!");
		System.out.println("That has to leave a mark!");
		salmon[0].setNumberOfScales(salmon[0].getNumberOfScales() + 5);
		salmon[1].setNumberOfScales(salmon[1].getNumberOfScales() - 5);
		
		System.out.println(salmon[0].getFishieName() + " now has " + salmon[0].getNumberOfScales() + " scales!");
		
		System.out.println(salmon[2].getFishieName() + " is attacked by a shark!");
		salmon[2].sharkAttack();
		
		System.out.println("He must be feeling slimmer with only " + salmon[2].getFishieWeight() + " pounds. :L");
		
		System.out.println("Goodnight fishes....AAAHHHH shark attack!");
		salmon[0].sharkAttack();
		salmon[1].sharkAttack();
		salmon[2].sharkAttack();
		
		System.out.println("OOOOF, serious damage done to the phishes!");
		
		System.out.println("\nOur slimmer phishes: ");
		System.out.println(salmon[0]);
		System.out.println(salmon[1]);
		System.out.println(salmon[2]);
		System.out.println();
	}
}

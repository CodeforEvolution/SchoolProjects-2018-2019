import javax.swing.*;

public class ChairTester {
	public static void main(String[] args) {
		String myName = JOptionPane.showInputDialog("Enter a name for your chair :)");
		String myHeight = JOptionPane.showInputDialog("It's time to define a height for your chair :D");
		
		Chair theChair = new Chair();
		Chair myChair = new Chair(myName, Double.parseDouble(myHeight));
		
		System.out.println("Default Chair: " + theChair + "\n");
		System.out.println("My Chair: " + myChair + "\n");
		
		myChair.sawLegs();
		
		System.out.println("My sawed Chair: " + myChair + "\n");
		
		theChair.addLifter();
		
		System.out.println("The other chair is getting taller?!? : " + theChair + "\n");
		
		myChair.sawLegs();
		myChair.ripTheChair(5);
		
		JOptionPane.showMessageDialog(null, "My chair is ruined! : \n" + myChair, "Get a load of this!", JOptionPane.ERROR_MESSAGE, null);
	}
}

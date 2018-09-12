import javax.swing.JOptionPane;


public class FishExperimentation {
	public static void main(String[] args) {
		String fishName = JOptionPane.showInputDialog("Your fish is ready to be named! :)");
		String fishHeight = JOptionPane.showInputDialog("It's time to say how thick your fish is! :D");
		
		Fish theLittleFishThatCould = new Fish(fishName, Double.parseDouble(fishHeight));
		Fish thiccFishie = new Fish("Big Daddy", 1000);
		
		System.out.println("Just a fish: " + theLittleFishThatCould);
		System.out.println("Big daddy fish: " + thiccFishie);
		
		theLittleFishThatCould.setNumberOfScales(100);
		thiccFishie.sharkAttack();
		
		System.out.println("That's a lot of scales fish! : " + theLittleFishThatCould);
		System.out.println("Big daddy was attacked! :D : " + thiccFishie);
		
		thiccFishie.setNumberOfScales(5);
		
		JOptionPane.showMessageDialog(null, "Big daddy is having a crisis! : " + thiccFishie, "Mid Life Crissis!", JOptionPane.ERROR_MESSAGE, null);
	}
}

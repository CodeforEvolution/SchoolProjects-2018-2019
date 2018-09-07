
public class FishExperimentation {
	public static void main(String[] args) {
		Fish theLittleFishThatCould = new Fish();
		Fish thiccFishie = new Fish(1000);
		
		System.out.println("Just a fish: " + theLittleFishThatCould);
		System.out.println("Big daddy fish: " + thiccFishie);
		
		theLittleFishThatCould.setNumberOfScales(100);
		thiccFishie.sharkAttack();
		
		System.out.println("That's a lot of scales fish! : " + theLittleFishThatCould);
		System.out.println("Big daddy was attacked! :D : " + thiccFishie);
		
		thiccFishie.setNumberOfScales(5);
		
		System.out.println("Big daddy is having a crisis! : " + thiccFishie);
	}
}

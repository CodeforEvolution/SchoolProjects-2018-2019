import java.util.ArrayList;
import java.util.Random;


public class TheFishes {
	public static void main(String[] args)
	{
		Random r = new Random();
		
		ArrayList<Fish> fishNet = new ArrayList<Fish>();
		fishNet.add(new Fish("Fred", 30));
		fishNet.add(new Fish("Boi"));
		fishNet.add(new Fish());
		fishNet.add(new Fish("Clyde", 50));
		
		System.out.println("Our fishes: ");
		System.out.println(fishNet + "\n");
		
		for (int i = 0; i < r.nextInt(10); i++)
		{
			System.out.println(fishNet.get(r.nextInt(4)).getFishieName() + " is going to get attacked by a shark, that's brutal.");
			fishNet.get(r.nextInt(4)).sharkAttack();
			
			System.out.println(fishNet.get(r.nextInt(4)).getFishieName() + "'s scales are going wild!!!");
			fishNet.get(r.nextInt(4)).setNumberOfScales(r.nextInt(100));
		}
		
		System.out.println("\nHow traumatic: \n" + fishNet);
	}
}


public class BuggerTester {
	public static void main(String[] args)
	{
		Bug youreToSlow = new Bug("You're To Slow!", 100);
		Bug wrongWay = new Bug("Hello darkness", -43);
		
		System.out.println("Bug time!");
		
		youreToSlow.move(50);
		
		wrongWay.turn();
		
		wrongWay.move(35);
		
		System.out.println("Well, the other has given up...");
		
		System.out.println(youreToSlow);
		System.out.println(wrongWay);
		
		System.out.println("Oh my gosh! " + wrongWay.getName() + " caught up and is winning!");
		
		youreToSlow.move(40);
		
		wrongWay.turn();
		wrongWay.move(350);
		
		System.out.println(youreToSlow);
		System.out.println(wrongWay);
	}
}

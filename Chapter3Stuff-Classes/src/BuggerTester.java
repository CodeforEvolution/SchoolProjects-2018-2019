
public class BuggerTester {
	public static void main(String[] args)
	{
		Bug youreToSlow = new Bug(100);
		Bug wrongWay = new Bug(-43);
		
		System.out.println("Bug time!");
		
		for (int i = 0; i < 50; i++)
		{
			youreToSlow.move();
		}
	}
}

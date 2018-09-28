import java.awt.Point;
import java.util.Scanner;


public class TriangleTester {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("First triangle x,y, separated by a space");

		Point first = new Point(in.nextInt(), in.nextInt());
		
		System.out.println("Second triangle x,y, separated by a space");
		Point second = new Point(in.nextInt(), in.nextInt());
		
		System.out.println("Third triangle x,y, separated by a space");
		Point third = new Point(in.nextInt(), in.nextInt());
		
		Triangle bob = new Triangle(first, second, third);

		System.out.println(bob);
	}
}

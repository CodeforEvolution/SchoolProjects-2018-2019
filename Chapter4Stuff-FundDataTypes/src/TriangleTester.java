import java.awt.geom.Point2D;
import java.util.Scanner;


public class TriangleTester {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("First triangle x,y, separated by a space");

		Point2D.Double first = new Point2D.Double(in.nextDouble(), in.nextDouble());
		
		System.out.println("Second triangle x,y, separated by a space");
		Point2D.Double second = new Point2D.Double(in.nextDouble(), in.nextDouble());
		
		System.out.println("Third triangle x,y, separated by a space");
		Point2D.Double third = new Point2D.Double(in.nextDouble(), in.nextDouble());
		
		Triangle bob = new Triangle(first, second, third);

		System.out.println(bob);
		
		in.close();
	}
}

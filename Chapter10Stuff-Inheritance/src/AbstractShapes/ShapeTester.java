package AbstractShapes;

import java.util.Scanner;

public class ShapeTester {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Shape c;
		Shape re;
		Shape rh;
		Shape t;
		
		System.out.println("Please enter a radius for a circle: ");
		c = new Circle(in.nextDouble());
		
		System.out.println("Enter a length and width for a rectangle: ");
		re = new Rectangle(in.nextDouble(), in.nextDouble());
		
		System.out.println("Enter a side and an angle please to make a rhombus: ");
		rh = new Rhombus(in.nextDouble(), in.nextDouble());
		
		System.out.println("Enter 2 sides, and an angle to be between them to make a triangle: ");
		t = new Triangle(in.nextDouble(), in.nextDouble(), in.nextDouble());
		
		in.close();
		System.out.println("\nYour shapes: ");
		System.out.println(c);
		System.out.println(re);
		System.out.println(rh);
		System.out.println(t);
		
		if (c.compareTo(re) > 0)
		{
			System.out.println(c.getClass().getSimpleName() + " is greater than " + re.getClass().getSimpleName() + ".");
		}
		else if (c.compareTo(re) < 0)
		{
			System.out.println(c.getClass().getSimpleName() + " is less than " + re.getClass().getSimpleName() + ".");
		}
		else
		{
			System.out.println(c.getClass().getSimpleName() + " and " + re.getClass().getSimpleName() + " are equal.");
		}
	}
}

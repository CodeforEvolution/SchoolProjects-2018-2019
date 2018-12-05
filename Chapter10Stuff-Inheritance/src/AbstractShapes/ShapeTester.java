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
	}
}

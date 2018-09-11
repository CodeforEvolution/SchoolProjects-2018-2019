import java.awt.Rectangle;


public class RectangleTester {
	public static void main(String[] args)
	{
		Rectangle tangle = new Rectangle(100, 50, 89, 100);
		System.out.println("Our rectangle: " + tangle);

		double area = tangle.getWidth() * tangle.getHeight();
		System.out.println("Its area: " + area);
		
		double perimeter = (2 * tangle.getWidth()) + (2 * tangle.getHeight());
		System.out.println("Its perimeter: " + perimeter);
	}
}

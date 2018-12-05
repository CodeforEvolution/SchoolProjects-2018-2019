package AbstractShapes;

public class Rectangle extends Shape {
	private double myLength;
	private double myWidth;
	
	public Rectangle(double length, double width)
	{
		myLength = length;
		myWidth = width;
	}
	
	@Override
	public double area()
	{
		return myLength * myWidth;
	}

	@Override
	public double perimeter()
	{
		return (2 * myLength) + (2 * myWidth);
	}
}

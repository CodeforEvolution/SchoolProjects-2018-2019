package AbstractShapes;

public class Rhombus extends Shape {
	private double mySide;
	private double myAngle;
	
	public Rhombus(double theSide, double theAngle)
	{
		mySide = theSide;
		myAngle = theAngle;
	}

	@Override
	public double area()
	{
		return 4 * (0.5 * (Math.sin(myAngle / 2) * mySide) * (Math.cos(myAngle / 2) * mySide));
	}

	@Override
	public double perimeter()
	{
		return mySide * 4;
	}
}

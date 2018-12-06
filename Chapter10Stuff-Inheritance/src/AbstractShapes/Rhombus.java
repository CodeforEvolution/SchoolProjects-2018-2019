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
		return 4 * (0.5 * (Math.sin((Math.PI / 180.0) * myAngle / 2.0) * mySide) * (Math.cos((Math.PI / 180.0) * myAngle / 2.0) * mySide));
	}

	@Override
	public double perimeter()
	{
		return mySide * 4;
	}
}

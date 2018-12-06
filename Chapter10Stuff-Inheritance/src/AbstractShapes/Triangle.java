package AbstractShapes;

public class Triangle extends Shape {
	private double myA;
	private double myB;
	private double myAngle;
	private double myC;

	public Triangle(double sideA, double sideB, double angleAB)
	{
		if (angleAB > 180)
		{
			throw new IllegalArgumentException("An angle of a triangle can't be greater than 180 degrees!");
		}
		
		myA = sideA;
		myB = sideB;
		myAngle = (Math.PI / 180.0) * angleAB;
		myC = Math.sqrt(Math.pow(myA, 2) + Math.pow(myB, 2) - (2.0 * (myA * myB * Math.cos(myAngle))));
		System.out.println(myC);
	}
	
	@Override
	public double area()
	{
		return 0.5 * myB * (Math.sin(myAngle) * (myA));
	}

	@Override
	public double perimeter()
	{
		return myA + myB + myC;
	}

}

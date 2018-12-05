package AbstractShapes;

public class Circle extends Shape {
	private double myRadius;
	
	public Circle(double radius)
	{
		myRadius = radius;
	}
	
	@Override
	public double area() {
		return Math.PI * Math.pow(myRadius, 2);
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * myRadius;
	}

}

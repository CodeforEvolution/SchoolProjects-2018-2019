package AbstractShapes;

public abstract class Shape implements Comparable<Shape>
{
	public abstract double area();
	public abstract double perimeter();
	
	public int compareTo(Shape whatToCompare)
	{	
		if (this.area() < whatToCompare.area())
			return -1;
		else if (this.area() > whatToCompare.area())
			return 1;
		else
			return 0;
	}
}

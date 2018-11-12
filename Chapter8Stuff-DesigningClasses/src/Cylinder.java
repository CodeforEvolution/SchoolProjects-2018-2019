
public class Cylinder {
	private double radius;
	private double height;
	
	public Cylinder(double theRadius, double theHeight)
	{
		radius = theRadius;
		height = theHeight;
	}
	
	public double getVolume()
	{
		return (Math.PI * Math.pow(radius, 2)) * height;
	}
	
	public double getSurfaceArea()
	{
		return (2 * (Math.PI * Math.pow(radius, 2))) + (2 * Math.PI * radius * height);
	}
}

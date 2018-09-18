
public class SodaCan {
	private double canHeight;
	private double canDiameter;
	
	public SodaCan(double inHeight, double inDiameter)
	{
		canHeight = inHeight;
		canDiameter = inDiameter;
	}
	
	public double getHeight()
	{
		return canHeight;
	}
	
	public double getDiameter()
	{
		return canDiameter;
	}
	
	public double getVolume()
	{
		return canHeight * Math.pow(Math.PI * (canDiameter / 2), 2);
	}
	
	public double getSurfaceArea()
	{
		return (canHeight * 2 * Math.PI * (canDiameter / 2)) + 2 * (Math.PI * (canDiameter / 2));
	}
}

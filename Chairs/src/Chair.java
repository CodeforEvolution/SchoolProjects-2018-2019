
public class Chair {
	private int rips;
	private double height;
	
	public Chair()
	{
		height = 10.0;
		rips = 0;
	}
	
	public Chair(double inHeight)
	{
		height = inHeight;
		rips = 0;
	}
	
	public void sawLegs()
	{
		height -= 3.25;
		rips++;
	}
	
	public void addLifter()
	{
		height += 2.5;
	}
	
	public void ripTheChair(int inRips)
	{
		rips += inRips;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double getRips()
	{
		return rips;
	}
	
	public String toString()
	{
		String out = "\n";
		out += "Height: " + String.valueOf(height) + "\n";
		out += "Rips in Wood: " + String.valueOf(rips);
		
		return out;
	}
}

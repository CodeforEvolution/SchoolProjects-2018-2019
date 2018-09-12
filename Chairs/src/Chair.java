
public class Chair {
	private int rips;
	private double height;
	private String name;
	
	public Chair()
	{
		name = "oaks";
		height = 10.0;
		rips = 0;
	}
	
	public Chair(String chairName)
	{
		name = chairName;
		height = 10.0;
		rips = 0;
	}
	
	public Chair(String chairName, double chairHeight)
	{
		name = chairName;
		height = chairHeight;
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
	
	public String getName()
	{
		return name;
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
		String out = "\nChair: " + name + "\n";
		out += "\tHeight: " + String.valueOf(height) + "\n";
		out += "\tRips in Wood: " + String.valueOf(rips);
		
		return out;
	}
}

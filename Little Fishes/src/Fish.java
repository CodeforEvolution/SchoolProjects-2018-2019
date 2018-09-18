import java.util.Random;


public class Fish {
	private int numberScales;
	private double fishieWeight;
	private String fishName;
	
	private Random randomatic = new Random();

	public Fish()
	{
		fishName = "fishy";
		fishieWeight = 100;
		numberScales = 40;
	}
	
	public Fish(String fishieName)
	{
		fishName = fishieName;
		fishieWeight = 100;
		numberScales = 40;
	}
	
	public Fish(String fishieName, double theWeight)
	{
		fishName = fishieName;
		fishieWeight = theWeight;
		numberScales = 40;
	}
	
	public void sharkAttack()
	{
		fishieWeight -= randomatic.nextInt(25);
		numberScales /= randomatic.nextInt(4);
	}
	
	public String getFishieName()
	{
		return fishName;
	}
	
	public double getFishieWeight()
	{
		return fishieWeight;
	}
	
	public void setNumberOfScales(int theNumber)
	{
		numberScales = theNumber;
	}
	
	public int getNumberOfScales()
	{
		return numberScales;
	}
	
	public String toString()
	{
		return "\nWeight: " + fishieWeight + "\nScales: " + numberScales + "\n";
	}
}

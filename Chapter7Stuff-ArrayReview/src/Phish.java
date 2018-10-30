import java.util.Random;


public class Phish {
	private int numberScales;
	private double fishieWeight;
	private String fishName;
	
	private Random randomatic = new Random();

	public Phish()
	{
		fishName = "fishy";
		fishieWeight = 100;
		numberScales = 40;
	}
	
	public Phish(String fishieName)
	{
		fishName = fishieName;
		fishieWeight = 100;
		numberScales = 40;
	}
	
	public Phish(String fishieName, double theWeight)
	{
		fishName = fishieName;
		fishieWeight = theWeight;
		numberScales = 40;
	}
	
	public void sharkAttack()
	{
		fishieWeight -= randomatic.nextInt(25);
		numberScales /= randomatic.nextInt(5) + 1;
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
		return "\nName: " + fishName + "\n" + "\tWeight: " + fishieWeight + "\n\tScales: " + numberScales + "\n";
	}
}

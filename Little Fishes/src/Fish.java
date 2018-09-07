import java.util.Random;


public class Fish {
	private int numberScales;
	private double fishieWeight;
	private Random randomatic = new Random();

	public Fish()
	{
		fishieWeight = 100;
		numberScales = 40;
	}
	
	public Fish(int theWeight)
	{
		fishieWeight = theWeight;
		numberScales = 40;
	}
	
	public void sharkAttack()
	{
		fishieWeight -= randomatic.nextInt(25);
		numberScales /= randomatic.nextInt(4);
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

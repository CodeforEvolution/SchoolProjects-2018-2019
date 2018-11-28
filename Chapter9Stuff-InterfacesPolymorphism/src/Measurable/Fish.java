package Measurable;
import java.util.Random;


public class Fish implements Measurable {
	private int numberScales;
	private double fishieWeight;
	private String fishName;
	
	private Random randomatic = new Random();
	
	private final double EPSILON = 0.00001; 

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
		numberScales /= randomatic.nextInt(4) + 1;
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
		String out = "";

		out += "Name: " + fishName + "\n";
		out += "\tWeight: " + fishieWeight + "\n";
		out += "\tScales: " + numberScales + "\n";
		
		return out;
	}
	
	public boolean equals(Fish other)
	{
		if ((other.getFishieName().equals(this.getFishieName())) && 
			(other.getNumberOfScales() == this.getNumberOfScales()) &&
			(other.getFishieWeight() == this.getFishieWeight() ? true : Math.abs(other.getFishieWeight() - this.getFishieWeight()) < EPSILON))
		{
			return true;
		}
		return false;
	}

	@Override
	public double getMeasure() {
		return fishieWeight;
	}
}

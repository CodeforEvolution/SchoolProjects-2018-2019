import java.util.Random;


public class Die {
	public static final int NUMBER_SIDES = 6;
	public static int numDiceInPlay = 0;
	
	private int numberFaces;
	private int valueOnTop;
	private Random r;
	
	public Die()
	{
		numberFaces = NUMBER_SIDES;
		numDiceInPlay++;
		r = new Random();
	}
	
	public Die(int faces)
	{
		numberFaces = faces;
		numDiceInPlay++;
		r = new Random();
	}
	
	public void roll()
	{
		valueOnTop = r.nextInt(numberFaces) + 1;
	}
	
	public int getValue()
	{
		return valueOnTop;
	}
	
	public static int getNumberDice()
	{
		return numDiceInPlay;
	}
	
	public int addTwoDie(Die otherDie)
	{
		return this.valueOnTop + otherDie.valueOnTop;
	}
	
	public int addThreeDie(Die firstDie, Die secondDie)
	{
		return addTwoDie(firstDie) + secondDie.valueOnTop;
	}
}

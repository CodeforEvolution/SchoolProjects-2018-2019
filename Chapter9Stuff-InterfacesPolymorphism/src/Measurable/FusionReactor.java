package Measurable;

import java.util.Random;

public class FusionReactor implements Measurable {
	private double thePower;
	private String theName;
	private double crazyAtoms;
	
	public FusionReactor(String reactorName, double power)
	{
		theName = reactorName;
		thePower = power;
		boom();
	}
	
	public void boom()
	{
		crazyAtoms = thePower * new Random().nextDouble();
	}

	public String getName()
	{
		return theName;
	}
	
	@Override
	public double getMeasure() {
		return crazyAtoms;
	}
}

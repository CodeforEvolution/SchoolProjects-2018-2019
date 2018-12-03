package CreativeClass;

import java.awt.Color;

public abstract class OperatingSystem {
	private int yearsOld;
	private int easeOfUse;
	private Color backgroundColor;
	
	public OperatingSystem(int theYearsOld, int theEaseOfUse, Color theBackgroundColor)
	{
		yearsOld = theYearsOld;
		easeOfUse = theEaseOfUse;
		backgroundColor = theBackgroundColor;
	}
	
	public abstract String getName();
	
	public abstract String getType();
	
	public int getYearsUsed()
	{
		return yearsOld;
	}
	
	public int howEasyToUse()
	{
		return easeOfUse;
	}
	
	public Color getDesktopBackground()
	{
		return backgroundColor;
	}
}

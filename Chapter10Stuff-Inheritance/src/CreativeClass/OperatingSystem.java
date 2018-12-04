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
	
	public abstract String getLatestVersion();
	
	public abstract int getAmountHardwareSupport();
	
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
	
	public String toString()
	{
		String out = "";
		
		out += this.getName() + ": \n";
		out += "\tType: " + this.getType() + "\n";
		out += "\tLatest Version: " + this.getLatestVersion() + "\n";
		out += "\tHardware Supported: " + this.getAmountHardwareSupport() + "\n";
		out += "\tEase of Use: " + this.howEasyToUse() + "\n";
		out += "\tDesktop Background: " + this.getDesktopBackground() + "\n";
		out += "\tYears Used by User: " + this.getYearsUsed() + "\n";
		
				
		return out;
	}
}

package CreativeClass;

import java.awt.Color;

public class FreeBSD extends OperatingSystem {

	public FreeBSD(int theYearsOld, int theEaseOfUse, Color theBackgroundColor)
	{
		super(theYearsOld, theEaseOfUse, theBackgroundColor);
	}

	@Override
	public String getName()
	{
		return "FreeBSD";
	}

	@Override
	public String getType()
	{
		return "BSD";
	}
	

	@Override
	public String getLatestVersion()
	{
		return "11";
	}

	@Override
	public int getAmountHardwareSupport()
	{
		return 2932;
	}	
}

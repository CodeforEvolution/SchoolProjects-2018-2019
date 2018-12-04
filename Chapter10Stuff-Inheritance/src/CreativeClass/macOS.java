package CreativeClass;

import java.awt.Color;

public class macOS extends OperatingSystem {

	public macOS(int theYearsOld, int theEaseOfUse, Color theBackgroundColor)
	{
		super(theYearsOld, theEaseOfUse, theBackgroundColor);
	}

	@Override
	public String getName()
	{
		return "macOS";
	}

	@Override
	public String getType()
	{
		return "Darwin";
	}
	

	@Override
	public String getLatestVersion()
	{
		return "Mojave";
	}

	@Override
	public int getAmountHardwareSupport()
	{
		return 23353;
	}
}

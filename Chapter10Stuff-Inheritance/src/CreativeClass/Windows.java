package CreativeClass;

import java.awt.Color;

public class Windows extends OperatingSystem {

	public Windows(int theYearsOld, int theEaseOfUse, Color theBackgroundColor) {
		super(theYearsOld, theEaseOfUse, theBackgroundColor);
	}
	
	@Override
	public String getName()
	{
		return "Windows";
	}

	@Override
	public String getType()
	{
		return "Windows NT";
	}
	
	@Override
	public String getLatestVersion()
	{
		return "10";
	}

	@Override
	public int getAmountHardwareSupport()
	{
		return 890293;
	}
}

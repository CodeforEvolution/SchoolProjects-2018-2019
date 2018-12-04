package CreativeClass;

import java.awt.Color;

public class Haiku extends OperatingSystem {

	public Haiku(int theYearsOld, int theEaseOfUse, Color theBackgroundColor)
	{
		super(theYearsOld, theEaseOfUse, theBackgroundColor);
	}

	@Override
	public String getName()
	{
		return "Haiku";
	}

	@Override
	public String getType() {
		return "BeOS";
	}

	@Override
	public String getLatestVersion() {
		return "Beta R1";
	}

	@Override
	public int getAmountHardwareSupport() {
		return 154;
	}
	
}

package CreativeClass;

import java.awt.Color;

public class WindowsXP extends OperatingSystem {

	public WindowsXP(int theYearsOld, int theEaseOfUse, Color theBackgroundColor) {
		super(theYearsOld, theEaseOfUse, theBackgroundColor);
	}
	
	public String getName()
	{
		return "Windows XP";
	}

	@Override
	public String getType() {
		return "Windows NT";
	}
}

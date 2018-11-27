package Speaker;

public class TheScream implements Speaker {
	private String theName;
	private byte theVolume;
	
	public TheScream(String name, byte volume)
	{
		theName = name;
		theVolume = volume;
	}
	
	public String getName()
	{
		return theName;
	}
	
	public byte getVolume()
	{
		return theVolume;
	}

	@Override
	public void speak()
	{
		String speech = "";
		for (int i = 0; i < theVolume; i++)
		{
			speech += "AH";
		}
		speech += "!";
			
		System.out.println(theName + " says " + speech);
	}
}


public class TimeInterval {
	private int diffMins;
	private int diffHours;
	
	public TimeInterval(int startTime, int endTime)
	{
		int overallDiff = 0;
		
		if (startTime > endTime)
			overallDiff = startTime - endTime;
		else
			overallDiff = endTime - startTime;
		
		String diff = Integer.toString(overallDiff);
	}
	
	public int getHours()
	{
		return diffHours;
	}
	
	public int getMinutes()
	{
		return diffMins;
	}
}

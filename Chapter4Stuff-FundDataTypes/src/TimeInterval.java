
public class TimeInterval {
	private int diffMins;
	private int diffHours;
	
	public TimeInterval(int startTime, int endTime)
	{
		int overallDiff = 0;
		
		String start = Integer.toString(startTime);
		String end = Integer.toString(endTime);
		
		int hours = 0;
		int minutes = 0;
		
		if (startTime > endTime)
		{
			hours = (24 - Integer.parseInt(start.substring(0,1))) + Integer.parseInt(end.substring(0,1));
			minutes = (60 - Integer.parseInt(start.substring(2,3)) + (60 - Integer.parseInt(end.substring(2,3))));
			overallDiff = hours + minutes;
		}
		else
		{
			hours = Integer.parseInt(start.substring(0, 1)) - Integer.parseInt(end.substring(0, 1));
			minutes = Integer.parseInt(start.substring(2, 3)) - Integer.parseInt(end.substring(2, 3));
			overallDiff = hours + minutes;
		}
		
		String temp = Integer.toString(overallDiff);
		int trail = Integer.numberOfTrailingZeros(overallDiff);
		System.out.println(temp);
		
		if (temp.length() == 4)
		{
			diffHours = Integer.parseInt(temp.substring(0, 1));
			diffMins = Integer.parseInt(temp.substring(2, 3));
		}
		else
		{
			diffHours = Integer.parseInt(Character.toString(temp.charAt(0)));
			diffMins = Integer.parseInt(temp.substring(1,2));
		}
		diffMins *= 10 * trail;
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

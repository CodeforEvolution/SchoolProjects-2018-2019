
public class TimeInterval {
	private int diffMins;
	private int diffHours;
	
	public TimeInterval(String startTime, String endTime)
	{
		int overallDiff = 0;
		
		String start = startTime;
		String end = endTime;
		
		int s = Integer.parseInt(startTime);
		int e = Integer.parseInt(endTime);
		
		int sPre = Integer.numberOfLeadingZeros(s);
		int sEnd = Integer.numberOfLeadingZeros(s);
		int ePre = Integer.numberOfTrailingZeros(e);
		int eEnd = Integer.numberOfTrailingZeros(e);
		
		if (s > e)
		{
			overallDiff = s - e;
		}
		else
		{
			overallDiff = e - s;
		}
		
		/*
		if (s > e)
		{
			hours = (24 - Integer.parseInt(start.substring(0,1))) + Integer.parseInt(end.substring(0,1));
			minutes = (60 - Integer.parseInt(start.substring(2,3)) + (60 - Integer.parseInt(end.substring(2,3))));
			overallDiff = hours + minutes;
		}
		else
		{
			hours = Integer.parseInt(end.substring(0, 1)) - Integer.parseInt(start.substring(0, 1));
			minutes = Integer.parseInt(end.substring(2, 3)) - Integer.parseInt(start.substring(2, 3));
			overallDiff = hours + minutes;
		}
		*/
		
		String temp = Integer.toString(overallDiff);
		int trail = Integer.numberOfTrailingZeros(overallDiff);
		System.out.println(temp);
		
		
		if (temp.length() == 3)
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

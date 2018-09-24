import java.util.Arrays;


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
		
		char temp[] = Integer.toString(overallDiff).toCharArray();
		System.out.println(Arrays.toString(temp));
		
		int diff[] = new int[temp.length];
		for (int i = 0; i < temp.length; i++)
		{
			diff[i] = Integer.parseInt(Character.toString(temp[i]));
		}
		
		if (diff.length == 4)
		{
			diffHours += diff[0] * 10;
			diffHours += diff[1];
			diffMins += diff[2] * 10;
			diffMins += diff[3];
		}
		else
		{
			diffHours += diff[0];
			diffMins += diff[1];
			diffMins += diff[2];
		}
		
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

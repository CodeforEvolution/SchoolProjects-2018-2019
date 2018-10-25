package utils;

import java.io.PrintStream;
import java.util.ArrayList;

public class printUtils {
	public static PrintStream sysOut = System.out;
	
	public static void printArray(Object[] input)
	{
		for (int i = 0; i < input.length; i++)
		{
			sysOut.print(input[i] + " ");
		}
		sysOut.println();
	}
	
	public static String[] stringToStrings(String in, char separator)
	{
		ArrayList<String> out = new ArrayList<String>();
		char[] temp = in.toCharArray();
		
		String current = "";
		for (int i = 0; i < temp.length; i++)
		{
			if (temp[i] == separator && current.isEmpty() == false)
			{
				out.add(current);
				current = "";
			}
			else
			{
				current += temp[i];
			}
		}
		
		return out.toArray(null);
	}
}

package utils;

import java.io.PrintStream;

public class printUtils {
	public static PrintStream sysOut = System.out;
	
	public static void printArray(Object[] input)
	{
		for (int i = 0; i < input.length; i++)
		{
			sysOut.print(input[i]);
		}
		sysOut.println();
		sysOut.println();
	}
}

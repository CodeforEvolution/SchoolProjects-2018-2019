package utils;

import java.io.PrintStream;

public class printUtils {
	static PrintStream sysOut = System.out;
	
	public static void printArray(Object[] input)
	{
		for (int i = 0; i < input.length; i++)
		{
			System.out.print(input[i]);
		}
		System.out.println();
		sysOut.println();
	}
}

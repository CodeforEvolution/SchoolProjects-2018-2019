

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Part1Jake {

	// NOTE: Code assumes array size of 25

	public static final int ROWS = 5;
	public static final int COLS = 5;

	public static void main(String[] args)
	{
		int[][] theArray = randomArray();

		System.out.println("Unsorted:\n" + printArray(theArray));

		theArray = sort(theArray);

		System.out.println("Sorted:\n" + printArray(theArray));

		HashMap<Integer, Integer> distribs = freqDistrib(theArray);
		System.out.println("Freq Distrib:\n" + distribs);



		System.out.println("Average: " + average(theArray));

		System.out.println("Median: " + median(theArray));

		System.out.println("1st Quartile: " + firstQuartile(theArray));

		System.out.println("3rd Quartile: " + thirdQuartile(theArray));
	}


	/**
	 * Generate and return a randomized array
	 * @return A randomly generated 2d array with numbers from 5 to 25
	 */
	public static int[][] randomArray()
	{
		int[][] outArray = new int[ROWS][COLS];

		for (int row = 0; row < outArray.length; row++)
		{
			for (int col = 0; col < outArray[row].length; col++)
			{
				outArray[row][col] = (int)(Math.random() * 21) + 5;
			}
		}

		return outArray;
	}

	// Returns string representation of "theArray"
	public static String printArray(int[][] theArray)
	{
		String out = "";

		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				out += theArray[row][col] + " ";
			}
			out += "\n";
		}

		return out;
	}

	// Returns average of "theArray"
	public static int average(int[][] theArray)
	{
		int outAverage = 0;

		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				outAverage += theArray[row][col];
			}
		}

		outAverage /= ROWS * COLS;

		return outAverage;
	}

	// Returns median of "theArray"
	public static double median(int[][] theArray)
	{
		int mid = ROWS * COLS;

		mid /= 2;

		int pos = 0;
		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				if (pos == mid)
					return theArray[row][col];
				pos++;
			}
		}

		return -1;
	}

	// Returns first quartile of "theArray"
	public static double firstQuartile(int[][] theArray)
	{
		double quart = ((ROWS * COLS) / 4) + 1;

		int pos = 0;
		int last = 0;
		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				if (pos == quart)
					return (theArray[row][col] + last) / 2.0;
				last = theArray[row][col];
				pos++;
			}
		}

		return -1;
	}

	// Returns third quartile of "theArray"
	public static double thirdQuartile(int[][] theArray)
	{
		double third = (((ROWS * COLS) / 4) * 3) + 1;

		int pos = 0;
		int last = 0;
		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				if (pos == third)
					return (theArray[row][col] + last) / 2.0;
				last = theArray[row][col];
				pos++;
			}
		}

		return -1;
	}

	// Returns sorted "theArray"
	// Small to large is left to right, top to bottom
	public static int[][] sort(int[][] theArray)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int[][] sortedOut = new int[ROWS][COLS];

		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				temp.add(theArray[row][col]);
			}
		}

		Collections.sort(temp);

		int pos = 0;
		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				sortedOut[row][col] = temp.get(pos);
				pos++;
			}
		}

		return sortedOut;
	}

	public static HashMap<Integer, Integer> freqDistrib(int[][] theArray)
	{
		HashMap<Integer, Integer> outDistribs = new HashMap<Integer, Integer>();

		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				if (outDistribs.containsKey(theArray[row][col]))
					outDistribs.put(theArray[row][col], outDistribs.get(theArray[row][col]) + 1);
				else
					outDistribs.put(theArray[row][col], 1);
			}
		}

		return outDistribs;
	}
}

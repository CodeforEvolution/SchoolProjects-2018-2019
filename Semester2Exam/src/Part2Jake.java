import java.util.Arrays;

public class Part2Jake {
	// NOTE: Code assumes array size of 25

	public static final int ROWS = 5;
	public static final int COLS = 5;

	public static void main(String[] args)
	{
		int[][] theArray = randomArray();

		System.out.println("Our Array:\n" +  printArray(theArray));

		theArray = shuffle(theArray);

		System.out.println("Shuffled Array:\n" + printArray(theArray));

		System.out.println("Three in a rows:\n" + identThreeHorizontal(theArray));

		System.out.println("Five in a rows:\n" + identFiveHorizontal(theArray));

		// DNF vertical + diagonal "3 in a row" checks
		// DNF "X" + "+" shape check
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
				switch ((int)(Math.random() * 3))
				{
					case 0:
						outArray[row][col] = 5;
						break;
					case 1:
						outArray[row][col] = 15;
						break;
					case 2:
					default:
						outArray[row][col] = 25;
						break;
				}
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

	// Randomly swap multiple elements by array size times
	public static int[][] shuffle(int[][] theArray)
	{
		int[][] outArray = Arrays.copyOf(theArray, theArray.length);

		for (int count = 0; count < theArray.length; count++)
		{
			int rowA = (int)(Math.random() * ROWS);
			int colA = (int)(Math.random() * COLS);
			int rowB = (int)(Math.random() * ROWS);
			int colB = (int)(Math.random() * COLS);

			int temp = theArray[rowA][colA];

			theArray[rowA][colA] = theArray[rowB][colB];
			theArray[rowB][colB] = temp;
		}

		return outArray;
	}

	public static String identThreeHorizontal(int[][] theArray)
	{
		String out = "";

		for (int row = 0; row < ROWS; row++)
		{
			int place = 0;
			while (place + 2 < theArray[row].length)
			{
				if (theArray[row][place] == theArray[row][place + 1] &&
					theArray[row][place + 1] == theArray[row][place + 2])
				{
					out += "\nThree in a row: ";
					out += "\tRow: " + row + " Col: " + place;
					out += "\tRow: " + row + " Col: " + (place + 1);
					out += "\tRow: " + row + " Col: " + (place + 2);
					out += "\n";
				}
				place++;
			}
		}

		return out;
	}

	public static String identFiveHorizontal(int[][] theArray)
	{
		String out = "";

		for (int row = 0; row < ROWS; row++)
		{
			int place = 0;
			while (place + 4 < theArray[row].length)
			{
				if (theArray[row][place] == theArray[row][place + 1] &&
					theArray[row][place + 1] == theArray[row][place + 2])
				{
					out += "\nFive in a row: ";
					out += "\tRow: " + row + " Col: " + place;
					out += "\tRow: " + row + " Col: " + (place + 1);
					out += "\tRow: " + row + " Col: " + (place + 2);
					out += "\tRow: " + row + " Col: " + (place + 3);
					out += "\tRow: " + row + " Col: " + (place + 4);
					out += "\n";
				}
				place++;
			}
		}

		return out;
	}

}

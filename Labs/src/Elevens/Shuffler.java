package Elevens;

import java.util.Arrays;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call to each
	 * sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 10;

	/**
	 * The number of values to hold within the deck, values are automatically filled.
	 * Example: 0, 1, 2, 3, ...
	 */
	private static final int VALUE_COUNT = 10;

	/**
	 * Tests shuffling methods.
	 *
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		int[] values = new int[VALUE_COUNT];
		for (int count = 0; count < VALUE_COUNT; count++)
		{
			values[count] = count;
		}

		System.out.println("Original Array:");
		for (int index = 0; index < values.length; index++)
		{
			System.out.print(values[index] + " ");
		}
		System.out.println("\n");

		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
		//int[] values1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] values1 = Arrays.copyOf(values, values.length);
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive efficient selection shuffles:");
		//int[] values2 = { 0, 1, 2, 3 };
		int[] values2 = Arrays.copyOf(values, values.length);
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Apply a "perfect shuffle" to the argument. The perfect shuffle algorithm
	 * splits the deck in half, then interleaves the cards in one half with the
	 * cards in the other.
	 *
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		/* *** COMPLETED IN ACTIVITY 3 *** */

		int[] shuffled = new int[values.length];

		int k = 0;
		for (int j = 0; j < (values.length + 1) / 2; j++) {
			shuffled[k] = values[j];
			k += 2;
		}

		k = 1;
		for (int j = (values.length + 1) / 2; j < values.length; j++) {
			shuffled[k] = values[j];
			k += 2;
		}

		for (int count = 0; count < values.length; count++) {
			values[count] = shuffled[count];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument. The selection shuffle
	 * algorithm conceptually maintains two sequences of cards: the selected cards
	 * (initially empty) and the not-yet-selected cards (initially the entire deck).
	 * It repeatedly does the following until all cards have been selected: randomly
	 * remove a card from those not yet selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid searching
	 * for an as-yet-unselected card.
	 *
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values)
	{
		for (int k = values.length - 1; k >= 0; k--)
		{
			int r = (int)(values.length * Math.random());

			int temp = values[r];
			values[r] = values[k];
			values[k] = temp;
		}
	}

	public static void oldSelectionShuffle(int[] values) {
		/* *** COMPLETED IN ACTIVITY 3 *** */

		int[] shuffled = new int[values.length];

		for (int k = 0; k < values.length; k++)
		{
			boolean next = false;
			while (next == false)
			{
				int j = (int)(values.length * Math.random());

				if (values[j] != -1)
				{
					next = true;
					shuffled[k] = values[j];
					values[j] = -1;
				}
			}
		}

		for (int count = 0; count < values.length; count++)
		{
			values[count] = shuffled[count];
		}
	}
}

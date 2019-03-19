package Elevens;

/**
 * This is a class that tests the Deck class.
 */
public class MyDeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** COMPLETED IN ACTIVITY 2 *** */

		String[] testR = {"Egg", "Bacon", "Cheese"};
		String[] testS = {"Yes!", "No!", "Maybe :D"};
		int[] testPA = {100, 4, 2, 3};
		int[] testPB = {50, -3, 2, 40};

		System.out.println(new Deck(testR, testS, testPA));
		System.out.println(new Deck(testS, testR, testPA));
		System.out.println(new Deck(testR, testS, testPB));
	}
}

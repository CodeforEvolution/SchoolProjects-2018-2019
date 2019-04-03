package Elevens;

import java.util.ArrayList;
import java.util.List;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensSimulationBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensSimulationBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** COMPLETED IN ACTIVITY 9 *** */
		/* *** MODIFIED IN ACTIVITY 11 *** */

		if (selectedCards.size() == 2)
			return !findPairSum11(selectedCards).isEmpty();

		if (selectedCards.size() == 3)
			return !findJQK(selectedCards).isEmpty();

		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** COMPLETED IN ACTIVITY 9 *** */
		/* *** MODIFIED IN ACTIVITY 11 *** */

		return !findPairSum11(cardIndexes()).isEmpty() || !findJQK(cardIndexes()).isEmpty();
	}

	/**
	 * Look for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return a list of the indexes of an 11-pair, if an 11-pair was found;
	 *         an empty list, if an 11-pair was not found.
	 */
	private ArrayList<Integer> findPairSum11(List<Integer> selectedCards) {
		/* *** COMPLETED IN ACTIVITY 9 *** */
		/* *** MODIFIED IN ACTIVITY 11 *** */

		for (int cardA = 0; cardA < selectedCards.size(); cardA++)
		{
			for (int cardB = 0; cardB < selectedCards.size(); cardB++)
			{
				Card oneCard = cardAt(selectedCards.get(cardA));
				Card twoCard = cardAt(selectedCards.get(cardB));

				if (oneCard.pointValue() + twoCard.pointValue() == 11)
				{
					ArrayList<Integer> out = new ArrayList<Integer>();
					out.add(cardA);
					out.add(cardB);
					return out;
				}
			}
		}

		return new ArrayList<Integer>();
	}

	/**
	 * Look for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK.
	 * @return a list of the index of a JQK, if a JQK was found;
	 *         an empty list, if a JQK was not found.
	 */
	private ArrayList<Integer> findJQK(List<Integer> selectedCards) {
		/* *** COMPLETED IN ACTIVITY 9 *** */
		/* *** MODIFIED IN ACTIVITY 11 *** */

		for (int cardA = 0; cardA < selectedCards.size(); cardA++)
		{
			for (int cardB = 0; cardB < selectedCards.size(); cardB++)
			{
				for (int cardC = 0; cardC < selectedCards.size(); cardC++)
				{
					Card oneCard = cardAt(selectedCards.get(cardA));
					Card twoCard = cardAt(selectedCards.get(cardB));
					Card threeCard = cardAt(selectedCards.get(cardC));

					if (oneCard.rank().equals("jack") &&
						twoCard.rank().equals("queen") &&
						threeCard.rank().equals("king"))
					{
						ArrayList<Integer> out = new ArrayList<Integer>();
						out.add(cardA);
						out.add(cardB);
						out.add(cardC);
						return out;
					}
				}
			}
		}

		return new ArrayList<Integer>();
	}


	/**
	 * Looks for a legal play on the board.  If one is found, it plays it.
	 * @return true if a legal play was found (and made); false otherwise.
	 */
	public boolean playIfPossible() {
		/* *** COMPLETED IN ACTIVITY 11 *** */

		if (playPairSum11IfPossible())
			return true;

		if (playJQKIfPossible())
			return true;

		return false;
	}

	/**
	 * Looks for a pair of non-face cards whose values sum to 11.
	 * If found, replace them with the next two cards in the deck.
	 * The simulation of this game uses this method.
	 * @return true if an 11-pair play was found (and made); false otherwise.
	 */
	private boolean playPairSum11IfPossible() {
		/* *** COMPLETED IN ACTIVITY 11 *** */

		List<Integer> replacableCards = findPairSum11(cardIndexes());

		if (replacableCards.isEmpty())
			return false;

		replaceSelectedCards(replacableCards);

		return true;
	}

	/**
	 * Looks for a Jack, Queen, and King.
	 * If found, replace it with the next card in the deck.
	 * The simulation of this game uses this method.
	 * @return true if a jack, queen, king play was found (and made); false otherwise.
	 */
	private boolean playJQKIfPossible() {
		/* *** COMPLETED IN ACTIVITY 11 *** */

		List<Integer> replacableCards = findJQK(cardIndexes());

		if (replacableCards.isEmpty())
			return false;

		replaceSelectedCards(replacableCards);

		return true;
	}
}

package com.datanumia;

import java.util.List;

/***
 * 
 * @author Ameni JELALI
 *
 */

/**
 * The YatzyScores class provides static methods to calculate scores for various
 * Yatzy categories based on a DiceRoll. It contains methods for scoring ones,
 * twos, threes, fours, fives, sixes, chance, yatzy, pair, two pair, three of a
 * kind, four of a kind, small straight, large straight, and full house.
 */
public class YatzyScores {

	/**
	 * Private constructor to prevent instantiation of the YatzyScores class.
	 */
	private YatzyScores() {
		super();
	}

	/**
	 * Calculates and returns the score for ones category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for ones category
	 */
	public static int ones(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(1, diceRoll);
	}

	/**
	 * Calculates and returns the score for twos category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for twos category
	 */
	public static int twos(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(2, diceRoll);
	}

	/**
	 * Calculates and returns the score for threes category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for threes category
	 */
	public static int threes(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(3, diceRoll);
	}

	/**
	 * Calculates and returns the score for fours category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for fours category
	 */
	public static int fours(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(4, diceRoll);
	}

	/**
	 * Calculates and returns the score for fives category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for fives category
	 */
	public static int fives(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(5, diceRoll);
	}

	/**
	 * Calculates and returns the score for sixes category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for sixes category
	 */
	public static int sixes(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(6, diceRoll);
	}

	/**
	 * Calculates and returns the score for chance category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for chance category
	 */
	public static int chance(DiceRoll diceRoll) {
		return diceRoll.sum();
	}

	/**
	 * Calculates and returns the score for yatzy category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return 50 if the dice values represent a yatzy, 0 otherwise
	 */
	public static int yatzy(DiceRoll diceRoll) {
		if (diceRoll.isYatzy()) {
			return 50;
		}
		return 0;
	}

	/**
	 * Calculates and returns the score for pair category based on the dice values
	 * in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for pair category
	 */
	static int pair(DiceRoll diceRoll) {
		List<Integer> pairs = diceRoll.findPairs();
		if (pairs.isEmpty()) {
			return 0;
		} else {
			return pairs.get(0) * 2;
		}
	}

	/**
	 * Calculates and returns the score for two pair category based on the dice
	 * values in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for two pair category
	 */
	static int twoPair(DiceRoll diceRoll) {
		List<Integer> pairs = diceRoll.findPairs();
		if (pairs.size() >= 2) {
			return pairs.stream().mapToInt(pair -> pair * 2).sum();
		}
		return 0;
	}

	/**
	 * Calculates and returns the score for three of a kind category based on the
	 * dice values in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for three of a kind category
	 */
	static int threeOfAKind(DiceRoll diceRoll) {
		return diceRoll.getDiceWithCountGreaterThan(3) * 3;
	}

	/**
	 * Calculates and returns the score for four of a kind category based on the
	 * dice values in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for four of a kind category
	 */
	static int fourOfAKind(DiceRoll diceRoll) {
		return diceRoll.getDiceWithCountGreaterThan(4) * 4;
	}

	/**
	 * Calculates and returns the score for small straight category based on the
	 * dice values in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return 15 if the dice values represent a small straight, 0 otherwise
	 */
	static int smallStraight(DiceRoll diceRoll) {
		if (diceRoll.isSmallStraight()) {
			return 15;
		}
		return 0;
	}

	/**
	 * Calculates and returns the score for large straight category based on the
	 * dice values in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return 20 if the dice values represent a large straight, 0 otherwise
	 */
	static int largeStraight(DiceRoll diceRoll) {
		if (diceRoll.isLargeStraight()) {
			return 20;
		}
		return 0;
	}

	/**
	 * Calculates and returns the score for full house category based on the dice
	 * values in the DiceRoll.
	 *
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the score for full house category
	 */
	static int fullHouse(DiceRoll diceRoll) {
		if (diceRoll.isFullHouse()) {
			return diceRoll.sum();
		}
		return 0;
	}
}
package com.datanumia;

import java.util.List;

/***
 * 
 * @author Ameni JELALI
 *
 */

public class YatzyScores {

	private YatzyScores() {
		super();
	}

	/**
	 * Calculates the sum of dice that have a value of 1.
	 * 
	 * @param diceRoll The DiceRoll object containing the values of each die.
	 * @return The sum of dice values that equal 1.
	 */
	static int ones(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(1, diceRoll);
	}

	/**
	 * Calculates the sum of dice that have a value of 2.
	 * 
	 * @param diceRoll The DiceRoll object containing the values of each die.
	 * @return The sum of dice values that equal 2.
	 */
	static int twos(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(2, diceRoll);
	}

	/**
	 * Calculates the sum of dice that have a value of 3.
	 * 
	 * @param diceRoll The DiceRoll object containing the values of each die.
	 * @return The sum of dice values that equal 3.
	 */
	static int threes(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(3, diceRoll);
	}

	/**
	 * Calculates the sum of dice that have a value of 4.
	 * 
	 * @param diceRoll The DiceRoll object containing the values of each die.
	 * @return The sum of dice values that equal 4.
	 */
	static int fours(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(4, diceRoll);
	}

	/**
	 * Calculates the sum of dice that have a value of 5.
	 * 
	 * @param diceRoll The DiceRoll object containing the values of each die.
	 * @return The sum of dice values that equal 5.
	 */
	static int fives(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(5, diceRoll);
	}

	/**
	 * Calculates the sum of dice that have a value of 6.
	 * 
	 * @param diceRoll The DiceRoll object containing the values of each die.
	 * @return The sum of dice values that equal 6.
	 */
	static int sixes(DiceRoll diceRoll) {
		return diceRoll.sumDiceByNumber(6, diceRoll);
	}

	/**
	 * Calculates the score for the "Chance" category in a game of Yatzy. This
	 * category's score is the sum of all dice in the DiceRoll object.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Chance" category which is the sum of all dice
	 *         values
	 */

	public static int chance(DiceRoll diceRoll) {
		return diceRoll.sum();
	}

	/**
	 * Calculates the score for the "Yatzy" category in a game of Yatzy. If all dice
	 * have the same number (5 dice with the same value), the score is 50.
	 * Otherwise, the score is 0.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Yatzy" category, either 50 if all dice have the
	 *         same value, or 0 otherwise
	 */

	public static int yatzy(DiceRoll diceRoll) {
		if (diceRoll.isYatzy(diceRoll)) {
			return 50;
		}
		return 0;
	}

	/**
	 * Calculates the score for the "Pair" category in a game of Yatzy. The score is
	 * twice the value of the highest pair (the pair with the highest value). If
	 * there are no pairs, the score is 0.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Pair" category, which is twice the value of the
	 *         highest pair, or 0 if there are no pairs
	 */
	static int pair(DiceRoll diceRoll) {

		return diceRoll.getDiceWithCountGreaterThan(diceRoll, 2);
	}

	/**
	 * Calculates the score for the "Two Pair" category in a game of Yatzy. The
	 * score is the sum of the values of the two highest pairs, multiplied by 2. If
	 * there are not at least two pairs, the score is 0.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Two Pair" category, which is the sum of the values
	 *         of the two highest pairs multiplied by 2, or 0 if there are less than
	 *         two pairs
	 */
	static int twoPair(DiceRoll diceRoll) {
		List<Integer> pairs = diceRoll.findPairs(diceRoll);

		if (pairs.size() >= 2) {
			return pairs.stream().mapToInt(pair -> pair * 2).sum();
		}
		return 0;
	}

	/**
	 * Calculates the score for the "Three of a Kind" category in a game of Yatzy.
	 * The score is three times the value of the dice that appear three times. If
	 * there are no such dice, the score is 0.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Three of a Kind" category, which is three times
	 *         the value of the dice that appear three times, or 0 if there are no
	 *         such dice
	 */
	static int threeOfAKind(DiceRoll diceRoll) {

		return diceRoll.getDiceWithCountGreaterThan(diceRoll, 3);
	}

	/**
	 * Calculates the score for the "Four of a Kind" category in a game of Yatzy.
	 * The score is four times the value of the dice that appear four times. If
	 * there are no such dice, the score is 0.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Four of a Kind" category, which is four times the
	 *         value of the dice that appear four times, or 0 if there are no such
	 *         dice
	 */
	static int fourOfAKind(DiceRoll diceRoll) {

		return diceRoll.getDiceWithCountGreaterThan(diceRoll, 4);

	}

	/**
	 * Calculates the score for the "Small Straight" category in a game of Yatzy. A
	 * small straight is a sequence of numbers from 1 to 5. The score is 15 for a
	 * small straight. If the dice do not form a small straight, the score is 0.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Small Straight" category, which is 15 if the dice
	 *         form a small straight, or 0 if they do not
	 */
	static int smallStraight(DiceRoll diceRoll) {

		if (diceRoll.isSmallStraight()) {
			return 15;
		}
		return 0;
	}

	/**
	 * Calculates the score for the "Large Straight" category in a game of Yatzy. A
	 * large straight is a sequence of numbers from 2 to 6. The score is 20 for a
	 * large straight. If the dice do not form a large straight, the score is 0.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Large Straight" category, which is 20 if the dice
	 *         form a large straight, or 0 if they do not
	 */
	static int largeStraight(DiceRoll diceRoll) {

		if (diceRoll.isLargeStraight()) {
			return 20;
		}
		return 0;

	}

	/**
	 * Calculates the score for the "Full House" category in a game of Yatzy. A full
	 * house is a roll where there are three of one number and two of another. The
	 * score is the total of all the dice. If the dice do not form a full house, the
	 * score is 0.
	 *
	 * @param diceRoll The DiceRoll object that contains the values of the dice roll
	 * @return The score for the "Full House" category, which is the sum of all the
	 *         dice if they form a full house, or 0 if they do not
	 */
	static int fullHouse(DiceRoll diceRoll) {

		if (diceRoll.isFullHouse(diceRoll)) {
			return diceRoll.sum();
		}
		return 0;
	}
}

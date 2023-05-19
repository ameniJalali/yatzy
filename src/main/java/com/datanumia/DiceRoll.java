package com.datanumia;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

/***
 * 
 * @author Ameni JELALI
 *
 */

/**
 * The DiceRoll class represents a roll of five dice in the game of Yatzy.
 * It provides methods for calculating scores and performing various operations on the dice values.
 */
public class DiceRoll {
    private List<Integer> diceValues;

    /**
     * Constructs a DiceRoll object with the given dice values.
     *
     * @param d1 the value of the first die
     * @param d2 the value of the second die
     * @param d3 the value of the third die
     * @param d4 the value of the fourth die
     * @param d5 the value of the fifth die
     */
    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        diceValues = List.of(d1, d2, d3, d4, d5);
    }

    /**
     * Returns the list of dice values in the DiceRoll.
     *
     * @return the list of dice values
     */
    public List<Integer> getDiceValues() {
        return diceValues;
    }
	
	/**
	 * Calculates and returns the sum of all dice values in the diceRoll that match the specified number.
	 *
	 * @param number   the number to match and sum the dice values for
	 * @param diceRoll the DiceRoll object containing the dice values
	 * @return the sum of all dice values in the diceRoll that match the specified number
	 */

	public int sumDiceByNumber(int number, DiceRoll diceRoll) {
		return diceRoll.getDiceValues()
				.stream()
				.filter(die -> die == number)
				.mapToInt(Integer::intValue)
				.sum();
	}

	/**
	 * Calculates and returns the sum of all elements in the diceValues list.
	 *
	 * @return the sum of all elements in the diceValues list
	 */
	public int sum() {
		return diceValues.stream()
				.mapToInt(Integer::intValue)
				.sum();
	}

	/**
	 * Returns a map that contains the counts of each unique element in the diceValues list.
	 * The keys of the map represent the unique elements (dice values), and the values represent
	 * the count of each element.
	 *
	 * @return a map containing the counts of each unique element in the diceValues list
	 */
	public Map<Integer, Long> counts() {
		return diceValues.stream()
				.collect(Collectors.groupingBy(die -> die, Collectors.counting()));

	}

	/**
	 * Checks if the dice values represent a Yatzy, which means all dice have the same value.
	 *
	 * @return true if the dice values represent a Yatzy, false otherwise
	 */
	public boolean isYatzy() {
		return counts().values().stream()
				.anyMatch(count -> count == 5);
	}

	/**
	 * Filters the counts of dice values and returns a stream of dice values that have a count greater than or equal to the specified value.
	 *
	 * @param n the threshold value for filtering the counts of dice values
	 * @return a stream of dice values with a count greater than or equal to the specified value
	 */
	private Stream<Integer> filterNumberOfDiceGreaterThan(int n) {
		return counts().entrySet().stream()
				.filter(entry -> entry.getValue() >= n).map(Entry::getKey);

	}

	/**
	 * Finds and returns a list of dice values that appear as pairs, sorted in descending order.
	 *
	 * @return a list of dice values that appear as pairs, sorted in descending order
	 */
	public List<Integer> findPairs() {

		return filterNumberOfDiceGreaterThan(2)
				.sorted(reverseOrder())
				.toList();
	}

	/**
	 * Retrieves the first dice value with a count greater than the specified value.
	 *
	 * @param n the threshold value for filtering the counts of dice values
	 * @return the first dice value with a count greater than the specified value, or 0 if no such value is found
	 */
	public int getDiceWithCountGreaterThan(int n) {
	    return filterNumberOfDiceGreaterThan(n)
	            .findFirst()
	            .orElse(0);
	}

	/**
	 * Sorts the dice values in ascending order and returns a new list with the sorted values.
	 *
	 * @return a new list containing the dice values sorted in ascending order
	 */
	private List<Integer> sort() {
	    return diceValues.stream()
	            .sorted()
	            .toList();
	}

	/**
	 * Checks if the dice values represent a small straight (1, 2, 3, 4, 5) when sorted in ascending order.
	 *
	 * @return true if the dice values represent a small straight, false otherwise
	 */
	public boolean isSmallStraight() {
	    return sort().equals(asList(1, 2, 3, 4, 5));
	}

	/**
	 * Checks if the dice values represent a large straight (2, 3, 4, 5, 6) when sorted in ascending order.
	 *
	 * @return true if the dice values represent a large straight, false otherwise
	 */
	public boolean isLargeStraight() {
	    return sort().equals(asList(2, 3, 4, 5, 6));
	}

	/**
	 * Checks if the dice values represent a full house. A full house consists of three of a kind and a pair,
	 * but it should not be a Yatzy (all dice values are the same).
	 *
	 * @return true if the dice values represent a full house, false otherwise
	 */
	public boolean isFullHouse() {
	    boolean hasThreeOfAKind = getDiceWithCountGreaterThan(3) != 0;
	    boolean hasPair = !findPairs().isEmpty();
	    boolean isYatzy = isYatzy();
	    return hasThreeOfAKind && hasPair && !isYatzy;
	}

}

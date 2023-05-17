package com.datanumia;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/***
 * 
 * @author Ameni JELALI
 *
 */

public class DiceRoll {
	private List<Integer> diceValues;

	public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
		diceValues = List.of(d1, d2, d3, d4, d5);
	}

	public List<Integer> getDiceValues() {
		return diceValues;
	}

	
	public int sumDiceByNumber(int number, DiceRoll diceRoll) {
		return diceRoll.getDiceValues().stream().filter(die -> die == number).mapToInt(Integer::intValue).sum();
	}

	public int sum() {
		return diceValues.stream().mapToInt(Integer::intValue).sum();
	}

	public boolean isYatzy(DiceRoll diceRoll) {
		return YatzyCollectors.diceCountMap(diceRoll).values().stream().anyMatch(count -> count == 5);
	}

	public List<Integer> findPairs(DiceRoll diceRoll) {
		return YatzyCollectors.diceCountMap(diceRoll).entrySet().stream().filter(entry -> entry.getValue() >= 2)
				.flatMap(entry -> IntStream.range(0, (int) (entry.getValue() / 2)).map(i -> entry.getKey()).boxed())
				.sorted(Collections.reverseOrder()).collect(Collectors.toList());
	}

	public int getDiceWithCountGreaterThan(DiceRoll diceRoll, int n) {

		return YatzyCollectors.diceCountMap(diceRoll).entrySet().stream().filter(entry -> entry.getValue() >= n)
				.mapToInt(Map.Entry::getKey).max().orElse(0) * n;
	}

	private List<Integer> sort() {
        return diceValues.stream().sorted().collect(toList());
    }
	
	public boolean isSmallStraight() {
        return sort().equals(asList(1, 2, 3, 4, 5));
    }
	
	public boolean isLargeStraight() {
        return sort().equals(asList(2, 3, 4, 5, 6));
    }
	
	 public boolean isFullHouse(DiceRoll diceRoll) {
	        boolean hasThreeOfAKind = getDiceWithCountGreaterThan(diceRoll, 3) != 0;
	        boolean hasPair = !findPairs(diceRoll).isEmpty();
	        boolean isYatzy = isYatzy(diceRoll);
	        return hasThreeOfAKind && hasPair && !isYatzy;
	    }

}

package com.datanumia;

import java.util.Map;
import java.util.stream.Collectors;

/***
 * 
 * @author Ameni JELALI
 *
 */

public class YatzyCollectors {

	private YatzyCollectors() {
		super();
	}

	public static Map<Integer, Long> createDiceCountMap(DiceRoll diceRoll) {

		return diceRoll.getDiceValues().stream().collect(Collectors.groupingBy(die -> die, Collectors.counting()));
	}

	public static Map<Integer, Long> diceCountMap(DiceRoll diceRoll) {

		return YatzyCollectors.createDiceCountMap(diceRoll);
	}

}

package com.datanumia;

import java.util.function.Function;

/**
 * @author Ameni JELALI
 * 
 * The Category enum represents the categories of Yatzy scores.
 * Each category has a corresponding score function that calculates the score based on a DiceRoll.
 */
public enum Category {
    CHANCE(YatzyScores::chance),
    YATZY(YatzyScores::yatzy),
    ONES(YatzyScores::ones),
    TWOS(YatzyScores::twos),
    THREES(YatzyScores::threes),
    FOURS(YatzyScores::fours),
    FIVES(YatzyScores::fives),
    SIXES(YatzyScores::sixes),
    PAIR(YatzyScores::pair),
    TWOPAIR(YatzyScores::twoPair),
    THREEOFKIND(YatzyScores::threeOfAKind),
    FOUROFKIND(YatzyScores::fourOfAKind),
    SMALLSTRAIGHT(YatzyScores::smallStraight),
    LARGESTRAIGHT(YatzyScores::largeStraight),
    FULLHOUSE(YatzyScores::fullHouse);

    private final Function<DiceRoll, Integer> scoreFunction;

    /**
     * Constructs a Category enum constant with the corresponding score function.
     *
     * @param scoreFunction the score function for the category
     */
    Category(Function<DiceRoll, Integer> scoreFunction) {
        this.scoreFunction = scoreFunction;
    }

    /**
     * Calculates and returns the score for the category based on the given DiceRoll.
     *
     * @param roll the DiceRoll object containing the dice values
     * @return the score for the category based on the DiceRoll
     */
    public int score(DiceRoll roll) {
        return this.scoreFunction.apply(roll);
    }
}
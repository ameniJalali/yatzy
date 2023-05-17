package com.datanumia;

import java.util.function.Function;

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

    Category(Function<DiceRoll, Integer> scoreFunction) {
        this.scoreFunction = scoreFunction;
    }

    public int score(DiceRoll roll) {
        return this.scoreFunction.apply(roll);
    }
}

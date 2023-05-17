package com.datanumia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import static com.datanumia.Category.*;


/***
 * 
 * @author Ameni JELALI
 *
 */

public class YatzyTests {
	
	private static Stream<Arguments> chanceData() {
        return Stream.of(
                Arguments.of(15, new DiceRoll(2, 3, 4, 5, 1)),
                Arguments.of(16, new DiceRoll(3, 3, 4, 5, 1)),
                Arguments.of(14, new DiceRoll(1, 1, 3, 3, 6)),
                Arguments.of(21, new DiceRoll(4, 5, 5, 6, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("chanceData")
     void chance(int expected, DiceRoll diceRoll) {
        assertEquals(expected, CHANCE.score(diceRoll));
    }
    
   
    private static Stream<Arguments> yatzyData() {
        return Stream.of(
                Arguments.of(50, new DiceRoll(4, 4, 4, 4, 4)),
                Arguments.of(50, new DiceRoll(6, 6, 6, 6, 6)),
                Arguments.of(0, new DiceRoll(6, 6, 6, 6, 3)),
                Arguments.of(50, new DiceRoll(1, 1, 1, 1, 1)),
                Arguments.of(0, new DiceRoll(1, 1, 1, 2, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("yatzyData")
    void yatzy(int expected, DiceRoll diceRoll) {
        assertEquals(expected, YATZY.score(diceRoll));
    }
    
	

    private static Stream<Arguments> onesData() {
        return Stream.of(
                Arguments.of(1, new DiceRoll(1, 2, 3, 4, 5)),
                Arguments.of(2, new DiceRoll(1, 2, 1, 4, 5)),
                Arguments.of(0, new DiceRoll(6, 2, 2, 4, 5)),
                Arguments.of(4, new DiceRoll(1, 2, 1, 1, 1)),
                Arguments.of(0, new DiceRoll(3, 3, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("onesData")
     void ones(int expected, DiceRoll diceRoll) {
        assertEquals(expected, ONES.score(diceRoll));
    }


    private static Stream<Arguments> twosData() {
        return Stream.of(
                Arguments.of(4, new DiceRoll(1, 2, 3, 2, 6)),
                Arguments.of(10, new DiceRoll(2, 2, 2, 2, 2)),
                Arguments.of(4, new DiceRoll(2, 3, 2, 5, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("twosData")
     void twos(int expected, DiceRoll diceRoll) {
        assertEquals(expected, TWOS.score(diceRoll));
    }
	
    private static Stream<Arguments> threesData() {
        return Stream.of(
                Arguments.of(6, new DiceRoll(1, 2, 3, 2, 3)),
                Arguments.of(12, new DiceRoll(2, 3, 3, 3, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("threesData")
     void threes(int expected, DiceRoll diceRoll) {
        assertEquals(expected, THREES.score(diceRoll));
    }


    private static Stream<Arguments> foursData() {
        return Stream.of(
                Arguments.of(12, new DiceRoll(4, 4, 4, 5, 5)),
                Arguments.of(8, new DiceRoll(4, 4, 5, 5, 5)),
                Arguments.of(4, new DiceRoll(4, 5, 5, 5, 5)),
                Arguments.of(8, new DiceRoll(1, 1, 2, 4, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("foursData")
     void fours(int expected, DiceRoll diceRoll) {
        assertEquals(expected, FOURS.score(diceRoll));
    }

	
    private static Stream<Arguments> fivesData() {
        return Stream.of(
                Arguments.of(10, new DiceRoll(4, 4, 4, 5, 5)),
                Arguments.of(15, new DiceRoll(4, 4, 5, 5, 5)),
                Arguments.of(20, new DiceRoll(4, 5, 5, 5, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("fivesData")
     void fives(int expected, DiceRoll diceRoll) {
        assertEquals(expected, FIVES.score(diceRoll));
    }

	
    
    private static Stream<Arguments> sixesData() {
        return Stream.of(
                Arguments.of(0, new DiceRoll(4, 4, 4, 5, 5)),
                Arguments.of(6, new DiceRoll(4, 4, 6, 5, 5)),
                Arguments.of(18, new DiceRoll(6, 5, 6, 6, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("sixesData")
     void sixes(int expected, DiceRoll diceRoll) {
        assertEquals(expected, SIXES.score(diceRoll));
    }
    
    private static Stream<Arguments> pairData() {
        return Stream.of(
                Arguments.of(6, new DiceRoll(3, 4, 3, 5, 6)),
                Arguments.of(10, new DiceRoll(5, 3, 3, 3, 5)),
                Arguments.of(12, new DiceRoll(5, 3, 6, 6, 5)),
                Arguments.of(8, new DiceRoll(3, 3, 3, 4, 4)),
                Arguments.of(12, new DiceRoll(1, 1, 6, 2, 6)),
                Arguments.of(6, new DiceRoll(3, 3, 3, 4, 1)),
                Arguments.of(6, new DiceRoll(3, 3, 3, 3, 1)),
                Arguments.of(0, new DiceRoll(1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("pairData")
     void pair(int expected, DiceRoll diceRoll) {
        assertEquals(expected, PAIR.score(diceRoll));
    }
    
    
 

    private static Stream<Arguments> twoPairData() {
        return Stream.of(
                Arguments.of(16, new DiceRoll(3, 3, 5, 4, 5)),
                Arguments.of(16, new DiceRoll(3, 3, 5, 5, 5)),
                Arguments.of(8, new DiceRoll(1, 1, 2, 3, 3)),
                Arguments.of(0, new DiceRoll(1, 1, 2, 3, 4)),
                Arguments.of(6, new DiceRoll(1, 1, 2, 2, 2))
                // Arguments.of(0, new DiceRoll(1, 1, 1, 1, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("twoPairData")
     void twoPair(int expected, DiceRoll diceRoll) {
        assertEquals(expected, TWOPAIR.score(diceRoll));
    }

    private static Stream<Arguments> threeOfAKindData() {
        return Stream.of(
                Arguments.of(9, new DiceRoll(3, 3, 3, 4, 5)),
                Arguments.of(15, new DiceRoll(5, 3, 5, 4, 5)),
                Arguments.of(9, new DiceRoll(3, 3, 3, 3, 5)),
                Arguments.of(9, new DiceRoll(3, 3, 3, 3, 3)),
                Arguments.of(0, new DiceRoll(3, 3, 4, 5, 6)),
                Arguments.of(9, new DiceRoll(3, 3, 3, 3, 1))
           
        );
    }

    @ParameterizedTest
    @MethodSource("threeOfAKindData")
     void threeOfAKind(int expected, DiceRoll diceRoll) {
        assertEquals(expected, THREEOFKIND.score(diceRoll));
    }

    private static Stream<Arguments> fourOfAKindData() {
        return Stream.of(
                Arguments.of(12, new DiceRoll(3, 3, 3, 3, 5)),
                Arguments.of(20, new DiceRoll(5, 5, 5, 4, 5)),
                Arguments.of(8, new DiceRoll(2, 2, 2, 2, 5)),
                Arguments.of(0, new DiceRoll(2, 2, 2, 5, 5)),
                Arguments.of(8, new DiceRoll(2, 2, 2, 2, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("fourOfAKindData")
     void fourOfAKind(int expected, DiceRoll diceRoll) {
        assertEquals(expected, FOUROFKIND.score(diceRoll));
    }

    private static Stream<Arguments> smallStraightData() {
        return Stream.of(
                Arguments.of(15, new DiceRoll(1, 2, 3, 4, 5)),
                Arguments.of(15, new DiceRoll(2, 3, 4, 5, 1)),
                Arguments.of(0, new DiceRoll(1, 2, 2, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("smallStraightData")
     void smallStraight(int expected, DiceRoll diceRoll) {
        assertEquals(expected, SMALLSTRAIGHT.score(diceRoll));
    }
    
    private static Stream<Arguments> largeStraightData() {
        return Stream.of(
                Arguments.of(20, new DiceRoll(6, 2, 3, 4, 5)),
                Arguments.of(20, new DiceRoll(2, 3, 4, 5, 6)),
                Arguments.of(0, new DiceRoll(1, 2, 2, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("largeStraightData")
     void largeStraight(int expected, DiceRoll diceRoll) {
        assertEquals(expected, LARGESTRAIGHT.score(diceRoll));
    }

    @Test
     void fullHouse() {
        assertEquals(18, FULLHOUSE.score(new DiceRoll(6, 2, 2, 2, 6)));
        assertEquals(0, FULLHOUSE.score(new DiceRoll(2, 3, 4, 5, 6)));
        assertEquals(8, FULLHOUSE.score(new DiceRoll(1, 1, 2, 2, 2)));
        assertEquals(0, FULLHOUSE.score(new DiceRoll(2, 2, 3, 3, 4)));
        assertEquals(0, FULLHOUSE.score(new DiceRoll(4, 4, 4, 4, 4)));
    }
}


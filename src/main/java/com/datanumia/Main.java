package com.datanumia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.datanumia.Category.CHANCE;
import static com.datanumia.Category.FIVES;
import static com.datanumia.Category.FOUROFKIND;
import static com.datanumia.Category.FOURS;
import static com.datanumia.Category.FULLHOUSE;
import static com.datanumia.Category.LARGESTRAIGHT;
import static com.datanumia.Category.ONES;
import static com.datanumia.Category.PAIR;
import static com.datanumia.Category.SIXES;
import static com.datanumia.Category.SMALLSTRAIGHT;
import static com.datanumia.Category.THREEOFKIND;
import static com.datanumia.Category.THREES;
import static com.datanumia.Category.TWOPAIR;
import static com.datanumia.Category.TWOS;
import static com.datanumia.Category.YATZY;

public class Main {
	 private static final Logger logger = LogManager.getLogger(Main.class);
	public static void main(String[] args) {
		// Création d'un DiceRoll avec les valeurs des dés
		DiceRoll diceRoll = new DiceRoll(1, 2, 3, 4, 5);

		// Test des différentes catégories de score
		    logger.info("Score for Ones: " + ONES.score(diceRoll));
	        logger.info("Score for Twos: " + TWOS.score(diceRoll));
	        logger.info("Score for Threes: " + THREES.score(diceRoll));
	        logger.info("Score for Fours: " + FOURS.score(diceRoll));
	        logger.info("Score for Fives: " + FIVES.score(diceRoll));
	        logger.info("Score for Sixes: " + SIXES.score(diceRoll));
	        logger.info("Score for Chance: " + CHANCE.score(diceRoll));
	        logger.info("Score for Yatzy: " + YATZY.score(diceRoll));
	        logger.info("Score for Pair: " + PAIR.score(diceRoll));
	        logger.info("Score for Two Pair: " + TWOPAIR.score(diceRoll));
	        logger.info("Score for Three of a Kind: " + THREEOFKIND.score(diceRoll));
	        logger.info("Score for Four of a Kind: " + FOUROFKIND.score(diceRoll));
	        logger.info("Score for Small Straight: " + SMALLSTRAIGHT.score(diceRoll));
	        logger.info("Score for Large Straight: " + LARGESTRAIGHT.score(diceRoll));
	        logger.info("Score for Full House: " + FULLHOUSE.score(diceRoll));
	}
}

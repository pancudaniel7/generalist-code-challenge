package com.challenge.utils;

import java.util.Random;

/**
 * Utility class used for generating numbers
 */
public class NumberUtils {
	private static Random random = new Random();

	/**
	 * Generates a number between 1 and 5 used mostly in game rating context
	 * @return generated rating
	 */
	public static double generateRating() {
		final int MIN_VALUE = 10;
		final int MAX_VALUE = 50;

		double number = random.nextInt(MAX_VALUE);

		return (number < MIN_VALUE) ? (number + MIN_VALUE) / 10 : number / 10;
	}

	/**
	 * Generates a random ID(between 1-5, for now) used in the context of  updating automatically game rating
	 * @return generated game ID
	 */
	public static int generateRandomId() {
		final int MAX_VALUE = 5;
		int number = random.nextInt(MAX_VALUE);

		return Math.max(number, 1);
	}
}

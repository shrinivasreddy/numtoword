/**
 * 
 */
package com.lbg.numtoword.services;

/**
 * @author Shrini
 *
 */
public class NumToWordConverterServicesImpl implements
		NumToWordConverterServices {
	private final static String[] DIGITS = { "", "one", "two", "three", "four",
			"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen" };

	private final static String[] MULTIPLE_OF_TENS = { "", "", "twenty",
			"thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	private final static String[] MILESTONES = { "", " thousand", " million" };

	private final static String HUNDERD_CONSTANT = "hundred";

	private final static String ZERO = "zero";

	public String toWord(long num) {

		// Validate input
		if (num < -999_999_999 || num > 999_999_999) {
			throw new IllegalArgumentException(
					"Invalid input! Give input between -999999999 to 999999999 inclusive.");
		}

		// handle zero
		if (num == 0) {
			return ZERO;
		}

		final boolean isNegative = (num < 0) ? true : false;

		final int positiveNum = (int) (isNegative ? -(num) : num);

		// Divide the numbe into parts of three digits
		int part = positiveNum % 1000;
		int tempNum = positiveNum;
		String words = "";
		int index = 0;

		do {
			if (part > 0) {
				words = toWordsFromThreeDigits(part) + MILESTONES[index]
						+ words;
			}
			tempNum = tempNum / 1000;
			part = tempNum % 1000;
			index++;
			// Add extra space if next part is not zero
			if (part > 0 && !words.equals("")) {
				words = " " + words;
			}
		} while (tempNum > 0);

		if (isNegative) {
			words = "(" + words + ")";
		}
		return words;
	}

	private static String toWordsFromThreeDigits(final int input) {

		if (input < 100) {
			return toWordsFromTwoDigit(input);
		}

		int hunderds_place = input / 100;
		int reminder = input % 100;
		final String space = (reminder > 0) ? " " : "";
		return DIGITS[hunderds_place] + " " + HUNDERD_CONSTANT + space
				+ toWordsFromTwoDigit(reminder);
	}

	private static String toWordsFromTwoDigit(final int input) {

		if (input < 20) {
			return DIGITS[input];
		}

		final int ones_place = input % 10;
		final int tens_place = input / 10;
		final String space = (ones_place > 0) ? " " : "";
		final String words = MULTIPLE_OF_TENS[tens_place] + space
				+ DIGITS[ones_place];

		return words;
	}

}

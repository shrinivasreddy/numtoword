/**
 * 
 */
package com.lbg.numtoword.services;

import com.lbg.numtoword.constants.NumToWordConstants;

/**
 * @author Shrini
 *
 */
public class NumToWordConverterServicesImpl implements
		NumToWordConverterServices {
	public String toWord(long num) {

		// Validate input
		if (num < -999_999_999 || num > 999_999_999) {
			throw new IllegalArgumentException(
					"Invalid input! Give input between -999999999 to 999999999 inclusive.");
		}

		// handle zero
		if (num == 0) {
			return NumToWordConstants.ZERO;
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
				words = toWordsFromThreeDigits(part) + NumToWordConstants.MILESTONES[index]
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
		return NumToWordConstants.DIGITS[hunderds_place] + " " + NumToWordConstants.HUNDERD_CONSTANT + space
				+ toWordsFromTwoDigit(reminder);
	}

	private static String toWordsFromTwoDigit(final int input) {

		if (input < 20) {
			return NumToWordConstants.DIGITS[input];
		}

		final int ones_place = input % 10;
		final int tens_place = input / 10;
		final String space = (ones_place > 0) ? " " : "";
		final String words = NumToWordConstants.MULTIPLE_OF_TENS[tens_place] + space
				+ NumToWordConstants.DIGITS[ones_place];

		return words;
	}

}

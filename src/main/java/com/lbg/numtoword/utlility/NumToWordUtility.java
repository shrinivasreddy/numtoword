/**
 * 
 */
package com.lbg.numtoword.utlility;

import com.lbg.numtoword.constants.NumToWordConstants;

/**
 * @author Shrini
 *
 */
public class NumToWordUtility {
	
	public static String toWordsFromThreeDigits(final int input) {

		if (input < 100) {
			return toWordsFromTwoDigit(input);
		}

		int hunderds_place = input / 100;
		int reminder = input % 100;
		final String space = (reminder > 0) ? " " : "";
		return NumToWordConstants.DIGITS[hunderds_place] + " " + NumToWordConstants.HUNDERD_CONSTANT + space
				+ toWordsFromTwoDigit(reminder);
	}

	public static String toWordsFromTwoDigit(final int input) {

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

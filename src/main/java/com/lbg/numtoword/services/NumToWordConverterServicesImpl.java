/**
 * 
 */
package com.lbg.numtoword.services;

import com.lbg.numtoword.constants.NumToWordConstants;
import com.lbg.numtoword.exception.ExceedRangeException;
import com.lbg.numtoword.utlility.NumToWordUtility;

/**
 * @author Shrini
 *
 */
public class NumToWordConverterServicesImpl implements
		NumToWordConverterServices {
	public String toWord(long num) throws ExceedRangeException {

		// Validate input
		if (num < -999_999_999 || num > 999_999_999) {
			throw new ExceedRangeException(
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
				words = NumToWordUtility.toWordsFromThreeDigits(part) + NumToWordConstants.MILESTONES[index]
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
}

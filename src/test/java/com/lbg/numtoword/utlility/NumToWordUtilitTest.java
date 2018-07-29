package com.lbg.numtoword.utlility;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumToWordUtilitTest {
	
	private static NumToWordUtility numToWordUtil;

	@BeforeClass
	public static void setUp() {
		numToWordUtil = new NumToWordUtility();
	}

	@Test
	public void toWordsFromThreeDigitsTest() {
      Assert.assertEquals("six hundred fifty six", NumToWordUtility.toWordsFromThreeDigits(656));
	}
	
	@Test
	public void toWordsFromTwoDigitTest() {
		Assert.assertEquals("sixty five", NumToWordUtility.toWordsFromTwoDigit(65));
		Assert.assertEquals("eighteen", NumToWordUtility.toWordsFromTwoDigit(18));
	}

}

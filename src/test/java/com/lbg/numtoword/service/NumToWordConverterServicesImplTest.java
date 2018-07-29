/**
 * 
 */
package com.lbg.numtoword.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lbg.numtoword.exception.ExceedRangeException;
import com.lbg.numtoword.services.NumToWordConverterServicesImpl;

/**
 * @author Shrini
 *
 */
public class NumToWordConverterServicesImplTest {
	private static NumToWordConverterServicesImpl numToWord;

	@BeforeClass
	public static void setUp() {
		numToWord = new NumToWordConverterServicesImpl();
	}

	@Test
	public void toWordTest() throws ExceedRangeException {
		Assert.assertEquals("ten", numToWord.toWord(10));
		Assert.assertEquals("(ten)", numToWord.toWord(-10));
		Assert.assertEquals("ten thousand five", numToWord.toWord(10005));
		Assert.assertEquals("(ten thousand five)", numToWord.toWord(-10005));
		Assert.assertEquals("zero", numToWord.toWord(0));
	}
	
	@Test(expected = ExceedRangeException.class)
	public void boundaryConditionTest() throws ExceedRangeException{
		numToWord.toWord(9999999999L);
	}

}

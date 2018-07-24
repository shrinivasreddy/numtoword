/**
 * 
 */
package com.lbg.numtoword.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lbg.numtoword.services.NumToWordConverterServicesImpl;

/**
 * @author Shrini
 *
 */
public class NumToWordConverterServicesImplTest {
	private static NumToWordConverterServicesImpl numToWord;
	
	@BeforeClass
	public static void setUp(){
		numToWord = new NumToWordConverterServicesImpl();
	}
	
	@Test
	public void toWordPositiveNumberTest(){
		Assert.assertEquals("ten", numToWord.toWord(10L));
		Assert.assertEquals("ten thousand five", numToWord.toWord(10005));
	}
 
}

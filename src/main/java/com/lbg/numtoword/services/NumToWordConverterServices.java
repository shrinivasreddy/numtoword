/**
 * 
 */
package com.lbg.numtoword.services;

import com.lbg.numtoword.exception.ExceedRangeException;

/**
 * @author Balu
 *
 */
public interface NumToWordConverterServices{
	
	public String toWord(final long num) throws ExceedRangeException;

}

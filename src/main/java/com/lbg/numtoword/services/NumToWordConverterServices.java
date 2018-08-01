/**
 * 
 */
package com.lbg.numtoword.services;

import com.lbg.numtoword.exception.ExceedRangeException;

/**
 * @author Shrini
 *
 */
public interface NumToWordConverterServices{
	
	public String toWord(final long num) throws ExceedRangeException;

}

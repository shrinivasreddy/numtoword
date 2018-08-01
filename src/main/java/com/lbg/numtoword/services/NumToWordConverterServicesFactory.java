/**
 * 
 */
package com.lbg.numtoword.services;

/**
 * @author Shrini
 *
 */
public class NumToWordConverterServicesFactory {
	/**
	 * 
	 * @return 
	 * Factory merhod return NumToWordConverterServices
	 */
	
	public static NumToWordConverterServices getNumToWordConverterServices(){
		return new NumToWordConverterServicesImpl();
	}

}

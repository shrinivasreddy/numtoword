/**
 * 
 */
package com.lbg.numtoword;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.lbg.numtoword.exception.ExceedRangeException;
import com.lbg.numtoword.services.NumToWordConverterServices;
import com.lbg.numtoword.services.NumToWordConverterServicesFactory;
import com.lbg.numtoword.services.NumToWordConverterServicesImpl;

/**
 * @author Shrini
 *
 */
public class Application {
	private static final Logger LOG = Logger.getLogger(Application.class);
	private static NumToWordConverterServices numToWordConverter;
	private static String num;
    private static Scanner sc;
    private static String word;
	/**
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		LOG.info("Enter into Number to word converter application");
		System.out.println("******************************");
		System.out.println("***Number to word converter***");
		System.out.println("******************************");
		numToWordConverter = NumToWordConverterServicesFactory.getNumToWordConverterServices();
		sc = new Scanner(System.in);
			do{
				System.out.println("Enter a number");
				//enter a number
				try {
					num = sc.next();
					if(num.equalsIgnoreCase("n"))
						break;
					word = numToWordConverter.toWord(new Long(num));
					LOG.info(num+" - "+word);
				}catch (ExceedRangeException e) {
					LOG.warn("Invalid input! Give input between -999999999 to 999999999 inclusive."+e);
				}catch(NumberFormatException e){
					LOG.warn("Need to enter numeric only");
					System.out.println("Numeric only :"+e);
				}
				System.out.println("If you want to Quit press 'N'");
			}while(true);
			System.out.println("Exit");
	}
}

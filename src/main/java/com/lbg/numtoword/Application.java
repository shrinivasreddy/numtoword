/**
 * 
 */
package com.lbg.numtoword;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.lbg.numtoword.services.NumToWordConverterServices;
import com.lbg.numtoword.services.NumToWordConverterServicesImpl;

/**
 * @author Shrini
 *
 */
public class Application {
	private static final Logger LOG = Logger.getLogger(Application.class);
	private static NumToWordConverterServices numToWordConverter;
	private static long num;
	private static String condition;
    private static Scanner sc;
    private static String word;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		LOG.info("Enter into Number to word converter application");
		System.out.println("******************************");
		System.out.println("***Number to word converter***");
		System.out.println("******************************");
		numToWordConverter = new NumToWordConverterServicesImpl();
		condition = "N";
		sc = new Scanner(System.in);
		try{
			do{
				System.out.println("Enter a number");
				num = sc.nextLong();
				//enter a number
				word = numToWordConverter.toWord(num);
				LOG.info(num+" - "+word);
				System.out.println("Do you want to continue (Y/N)");
				condition = sc.next();
				if(!(condition.equalsIgnoreCase("y")||condition.equalsIgnoreCase("n")))
					System.out.println("wrong");
			}while(condition.equalsIgnoreCase("Y"));
		}catch(InputMismatchException e){
			LOG.warn("Need to enter numeric only");
			System.out.println("Numeric only :"+e);
			
		}catch (IllegalArgumentException e) {
			LOG.warn(e);
			// TODO: handle exception
		}
	}
}

/*
 * By: John Stile
 * Assignment: Lab1 (part x)
 * 
 * REF http://en.wikipedia.org/wiki/Lychrel_number
 * Description:
 * Lychrel numbers:
 * “a natural number that cannot form a palindrome through
 * the iterative process of repeatedly reversing its digits
 * and adding the resulting numbers.”
 * e.g. 56: 56+65 = 121
 * e.g 57: 57+75 = 132, 132+231 = 363
 * e.g 59: 59+95 = 154, 154+451 = 605, 605+506 = 1111
 * For a true negative test, 196 is the smallest known Lychrel number.
 * Purpose:
 * This class determines if a number is a Lychrel number or not.
 * Has one public method: isLycherl()
 */
package Lycherl;

import java.util.ArrayList; // for my list of test numbers
import java.math.BigInteger; // for big int math
import java.lang.StringBuilder; // for reversing

public class Lychrel {
	/*
	 * class field constant holding int from constructor
	 */
	static private int _int;
	
	/*
	 * Constructor takes one integer
	 * and assigns to the class field constant
	 */
	Lychrel(int x){
		_int = x;
	}

	/*
	 * return boolean true if number is a Lychrel
	 */
	public static boolean isLychrel() {
		return isLychrelHelper();
	}

	/*
	 * After 100 iterations of
	 * reverse and add
	 * declare it Lychrel
	 * by return ! palendrome
	 */
	private static boolean isLychrelHelper() {
		/*
		 * Set my default to false
		 */
		boolean palendrome = false;
		/*
		 * Before enting loop first time, crate the string
		 * so we can test for palendrome on first loop
		 * catches 11, 99, 111, etc.
		 */
		String forward = Integer.toString( _int );
		/*
		 * Run up to 100 iterations
		 */
		for ( int i = 0; i < 100; i++ ) {
			/*
			 * get reverse
			 */
			String reverse = reverseString( forward );
			/*
			 * We have a palendrome if forward and reverse are equal
			 */
			if ( forward.equals( reverse ) ) {
				palendrome = true;
			}
			/*
			 * Condition to break out of the loop
			 */
			if ( palendrome ) {
				break;
			}
			/*
			 * If we have not broken out,
			 * Add forward and reverse
			 * and assign to thread for next iteration
			 */
			forward = addStrings( forward, reverse );
		}
		/*
		 * Little funky, Not palendrome = Lycherl
		 */
		return !palendrome;
	}

	/*
	 * Return the reverse string
	 */
	private static String reverseString( String x ) {
		/*
		 * Generate a StringBuilder,
		 * reverse the order
		 * convert to string
		 * return string
		 */
		return new StringBuilder( x ).reverse().toString();
	}

	/*
	 * Return string representation of the numeric summation of the two strings
	 */
	private static String addStrings( String x, String y ) {
		/*
		 * Convert both to numbers
		 * numeric addition
		 * convert to string
		 * return string
		 */
		BigInteger big_x = new BigInteger( x, 10 );
		BigInteger big_y = new BigInteger( y, 10 );
		BigInteger big_result = big_x.add( big_y );
		return big_result.toString();
	}
	/*
	 * will print out the first 1000 numbers
	 * report whether each is a lycherl number or not.
	 * Run this class and save its console output in a file named
	 * lychrel_output.txt
	 * Put this file in your NetBeans package, so be submitted in the same zip
	 */
	public String runner() {
		String output = "";
		return output;
	}

	/*
	 * Test my code in main
	 */
	public static void main( String[] argv ) {
		// Create list of numbers to test
		ArrayList< Integer > testers = new ArrayList<>();
		// Build the list
		testers.add( 0 );
		testers.add( 56 );
		testers.add( 57 );
		testers.add( 59 );
		testers.add( 196 );
		for ( int i : testers ) {
			// Create instance of class
			Lychrel l = new Lychrel(i);
			// Set the default
			String result = " is not Lychrel";
			// Test and fix result
			if ( isLychrel() ) {
				result = " is Lychrel";
			}
			System.out.println( "Int:" + i + result );
		}

	}

}

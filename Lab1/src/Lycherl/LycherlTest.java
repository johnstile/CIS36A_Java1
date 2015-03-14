/*
 * By: John Stile
 * Assignment: Lab1 (part x)
 * Tester class for Lychrel Class
 */
package Lycherl;

public class LycherlTest {
	public static void main( String[] argv ) {

		/*
		 * print out the first 1000 numbers
		 * That would be 0 to 999
		 */
		for ( int i = 0; i < 1000; i++ ) {
			// Create instance of class
			Lychrel l = new Lychrel( i );
			// Set the default output message
			String result = " is not Lychrel";
			// Test and fix result
			if ( l.isLychrel() ) {
				result = " is Lychrel";
			}
			// Final output
			System.out.println( "Int:" + i + result );
		}
	}
}

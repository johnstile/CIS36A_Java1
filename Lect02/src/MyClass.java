
public class MyClass {
	public static void main (String args[]){
		/*
		 * Boolean is Wrapper Class for boolean
		 */
		boolean t = false;
		Boolean objt;
		objt = true;

		/*
		 * == compares memory locations
		 */
		String one = "Monday";
		String two = "Monday";
		String day = "day";
		String three = "Mon" + day;
		/*  NOTE:
		 * evaluate ( one == two ) is true
		 * evaluate ( one == three ) is false
		 */

		if ( one == two )
		{
			System.out.println(
					"one and two match\n"
					);
		} else {
			System.out.println(
					"one and two differ\n"
					);
		}
		if ( one == three )
		{
			System.out.println(
					"one and three match\n"
					);
		} else {
			System.out.println(
					"one and theree differ\n"
					);
		}
		/*
		 * intern - will try to reuse a memory location
		 */    
		String four = two.intern();  // Optimize for space
		if ( one == four )
		{
			System.out.println(
					"one and four match\n"
					);
		} else {
			System.out.println(
					"one and four differ\n"
					);
		}	    
		///////////////////////////////////////////////////
		// Looping //
		// do-while
		// while
		// for
		boolean sentinl_quit = false;
		while ( sentinl_quit == false )
		{
			System.out.println("so stuff\n");
			sentinl_quit = true;
		}
		///////////////////////////////////////////////////
		// while ( bool_expr) { Body; Update; }
		do {
			System.out.println("so stuff\n");
			sentinl_quit = true;	    	
		}
		while ( sentinl_quit == false );

		// while loop
		int n = 5; // does not work for negetive
		int sum = sum1(n);
		System.out.println("sum:" + sum  + "\n");
		int sum2 = sum2(n);
		System.out.println("sum2:" + sum2  + "\n");
        ///////////////////////////////////////////////////
		// for ( init; bool_expr; Update){ Body }
		for( int i = 0 ; i < 5 ; i++ )
		{ 
			System.out.println("loop\n"); 
		}
		// Strange counter
		weridsum();

	}	    
	/////////////////////////////////////////////////////
	// sum up 1..n
	// n is passed by value in java
	public static int sum1( int n ) {
		// Holds result of sum.
		int total = 0;
		// loop while n is greater than 0
		while ( n !=  0 ) {
			// load total
			total += n;
			// decrement 
			n--;
		}
		return total;
	}
	public static int sum2(int n){
		// Holds result of sum.
		int total = 0;
		// counter?
		int i = 0;
		// loop dependent on 
		while (i <= n){
			// Add i to total
			total = total + i;
			// next i
			i++;
		}
		return total;
	}
	/////////////////////////////////////////////////////
	// prints: 1 0 2 2 3 1 4 3
	// wrote down the numbers each iteration
	public static void weridsum(){
		System.out.println("Enter weridsum\n");
		int x = 1;
		int y = 1;
		while( x < 5) {
		    y = x - y;
		    System.out.println(x + " " + y + " ");
		    x = x + 1;
		}
		System.out.println();
	}
	// Get source template at:  http://bit.ly/1yA50J6
	
	
	
}

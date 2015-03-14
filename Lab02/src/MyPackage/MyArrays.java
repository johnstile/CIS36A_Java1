package MyPackage;
/*
 * Lab: Lab2 PartA, Problem 1
 * By:  John Stile 
 * Write a method zip that takes 2 int arrays and returns a signle int array
 * with the two arguments zipped together. on or both arguments may be null; 
 * if both are null retutnr a zero-length array.
 */
public class MyArrays {
	
	/*
	 * Takes two ints, returns zipped array
	 */
	public int[] zip(int[] a, int[] b){
		/*
		 * First catch null
		 */
		if (a == null) {
			  System.out.println("a is null. return b");
			  return b;
		}
		if (b == null) {
			return a;
		}
		/*
		 * Determine the longest array and size of final array
		 */
		int a_size = a.length;
		int b_size = b.length;
		int largest_size = (a.length > b.length) ? a.length : b.length;
		int c_size = a.length + b.length;
		/*
		 * The array will represent all elements of both
		 */
		int[] c = new int[c_size];
		/*
		 * Iterate over longest array, append to the 
		 *  i is index in for loop
		 *  j is index in c[]
		 */
		for (int i = 0, j=0 ; i < largest_size; i++){
			if ( i < a_size ){
				c[j] = a[i];  // Add to the array
				j++;          // increment index
			}
			if ( i < b_size ){
				c[j] = b[i];
				j++;          // increment index
			}
		}
		return c;
	}
	/* 
	 * Helper to output an array
	 */
	public void print_array(int[] a){
		/*
		 * Get the length of the array
		 */
		int a_size = a.length;
		System.out.print("Length:" + a_size  + "  {");
		for(int i=0; i< a_size; i++){
			// This prints the value
			System.out.print(a[i]);
			// Determine if we print a comma
			if ( i < (a_size-1) ){
				System.out.print(",");
			}
		}
		System.out.println("}");
	}

}

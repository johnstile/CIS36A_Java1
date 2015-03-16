package MyPackage;
/*
 * Lab: Lab2 PartA, Problem 1
 * By:  John Stile 
 */
public class TestMyClass {
	public static void main(String[] argv){
		test1();
		test2();
		test3();
		test4();
	}
	// Test second array has more items than first
	public static void test1(){
		MyArrays my_array = new MyArrays();
		int[] a = {1,2,3};
		int[] b = {11,12,13};
		my_array.print_array( my_array.zip( a, b ) );
	}
	// Test frist array has more items than second
	public static void test2(){
		MyArrays my_array = new MyArrays();
		int[] a = {1,2,3,4};
		int[] b = {11,12};
		my_array.print_array( my_array.zip( a, b ) );
	}	
	// Test one null array
	public static void test3(){
		MyArrays my_array = new MyArrays();
		int[] a = {1,2,3};
		int[] b = {};
		my_array.print_array( my_array.zip( a, b ) );
	}	
	// Test both null arrays
	public static void test4(){
		MyArrays my_array = new MyArrays();
		int[] a = {};
		int[] b = {};
		my_array.print_array( my_array.zip( a, b ) );
	}
}

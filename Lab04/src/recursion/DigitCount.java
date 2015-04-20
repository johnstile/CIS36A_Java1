package recursion;

// contains a buggy version of digitCount
public class DigitCount {


    public static void main(String[] args) {

    	System.out.println(digitCount(5)    ); // returns 1
    	System.out.println(digitCount(10)   ); // returns 2
    	System.out.println(digitCount(82)   ); // returns 2
    	System.out.println(digitCount(9912) ); // returns 4

		System.out.println("Testing ReverseMethod.java");
		ReverseMethods a = new ReverseMethods();
		String s = "this is my string in the reverse direction";
		System.out.println( a.reverse16(s) );
		System.out.println( a.reverse17(s) );
		System.out.println( a.reverse(s) );
	}
    
    // Fix the bug in digitCount so that it returns correct values.
    // You should only need to change one line!
    public static int digitCount(int value) {
        if (value == 0) {
            return 0;
        } else {
            return 1 + digitCount(value / 10);
        }
    }

}

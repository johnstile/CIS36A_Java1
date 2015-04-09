package recursion;

public class ReverseMethods {

    // returns the reverse of a one-length string.  Easy!
    public String reverse1(String s) {
        return s;
    }

    //returns the reverse of a two-length string.
    public String reverse2(String s) {
        return (s.substring(1, 2) + s.substring(0, 1));
    }

    //returns the reverse of a three-length string.
    public String reverse3(String s) {
        return (s.substring(2, 3) + s.substring(1, 2) + s.substring(0, 1));
    }

    /*
     * more of the same here...
     */
    public String reverse16(String s) {
        // This is the *bad* way to write reverse!  
        // You'll do better with reverse17, right?
        return s.substring(15, 16)
                + s.substring(14, 15)
                + s.substring(13, 14)
                + s.substring(12, 13)
                + s.substring(11, 12)
                + s.substring(10, 11)
                + s.substring(9, 10)
                + s.substring(8, 9)
                + s.substring(7, 8)
                + s.substring(6, 7)
                + s.substring(5, 6)
                + s.substring(4, 5)
                + s.substring(3, 4)
                + s.substring(2, 3)
                + s.substring(1, 2)
                + s.substring(0, 1);
    }

    public String reverse17(String s) {
       
    }

    // helper methods you can use (you should use one of them)
    // returns a string containing all the characters except the first
    public static String allButFirst(String s) {
        return s.substring(1);
    }

    // returns a string  containing all the characters except the last
    public static String allButLast(String s) {
        return s.substring(0, s.length());
    }

    

    /*
     * Now, write a recursive solution to reverse without using any helper methods.
     * That is, reverse should only call reverse! (and some string manipulation methods).
     */
    public String reverse(String s) {

        if () {
			// base case

        } else {
			// the recursive case! 

        }
    }

}

package Foodles;

import java.util.Arrays; // array manipulation class

public class MyClass {
	// This is in every single class
	/*
	/opt/oracle-jdk-bin-1.8.0.25/bin/java \
	    -agentlib:jdwp=transport=dt_socket,suspend=y,address=localhost:35299 \
	    -Dfile.encoding=UTF-8 \
	    -classpath /home/jstile/2015_spring/CIS36A_Java1/JohnStile/workspace/Study0/bin \
	    Foodles.MyClass
	    
        You can get the full command executed by your configuration on the Debug tab, or more specifically the Debug view.

        Run your application
        Go to your Debug perspective
        There should be an entry in there (in the Debug View) for the app you've just executed
        Right-click the node which references java.exe or javaw.exe and select Properties In the dialog that pops up you'll see the Command Line which includes all jars, parameters, etc


	 */
	public static void main (String args[]){
		/*
		 * Virtues of Java 
         */
		 System.out.print(
		   "Languages are: \n" +
		   "\tstatic / dynamic assignment\n" +
		   "\tstrong / week  typing\n" +
		   "Python Language is:\n\tStrongly type, but Dynamicly assigned\n" +
		   "Java Language is:\n\tStrongly typed, and Static assigned\n" +
		   "=============================================================\n"
		 );
	     System.out.println(
	 	        "non-static fields: Instance variables are unique to each instance of a class.\n" +
	 	        "static fields: Class variables are shared with each instance of a class.\n" +
	 	        "method variables: temporary state variables inside a method\n" +
	 	        "parameters variables: arguments to methods encoded in parenthesis\n" +
	 		   "=============================================================\n"
	 	     );
	     System.out.print(
		     "eight primitive data types are:\n" +
			 "\tbyte, short, int, long, float, double, boolean, and char.\n" +
		     "\tAll primitives has Capitol Name that wraps th primitive type\n"
		 );
		 System.out.print("basic types:");
		 int a = 1;
		 float b = 2;
		 double c = 3;
		 long d = 4;
		 boolean e = false;
		 String f = "this is a string";
		 System.out.print("\n\ta:" + a);
		 System.out.print("\n\td:" + b);
		 System.out.print("\n\tc:" + c);
		 System.out.print("\n\td:" + d);
		 System.out.print("\n\te:" + e);
		 System.out.print("\n\tf:" + f);
		 
         System.out.print("\nDown Casting:\n");
		 a = (int) b;
		 System.out.print("\n\ta:" + a);
		 System.out.print("\nUp Casting:\n");
		 b = (float)a;
		 System.out.print("\n\tb:" + b);

		 System.out.print(
				 "\n" +
		         "\nAn array is a container object" +
				 "\nholds a fixed number of values of a homogenious type." +
				 "\nAn array has 2 components:" +
	             "\n\t\ttype and name\n"
	     );
		 // declares an array of integers
		 int[] gArray;
	     // allocates memory for 10 integers
	     gArray = new int[10];
	     gArray[0] = 100;
	     gArray[1] = 99;
	     System.out.println("Element at index 0: "
                 + gArray[0]);
	     System.out.println("Element at index 1: "
                 + gArray[1]);
	     // shortcut syntax
	     int[] hArray = {
	    		 100, 200, 300,
	    		 400, 500, 600, 
	    		 700, 800, 900, 1000
	     };
	     // multi dimentional array
	     String[][] iArray = {
	             {"Mr. ", "Mrs. ", "Ms. "},
	             {"Smith", "Jones"}
	     };
	     System.out.println(iArray[0][0] + iArray[1][0]);
	     System.out.println(iArray[0][1] + iArray[1][1]);
	     System.out.println("\nArray length property:" + iArray.length);
	     System.out.println("\nArray[0] length property:" + iArray[0].length);
	     System.out.println("\nArray[1] length property:" + iArray[1].length);
	     System.out.println("\nPrint all of iArray:" + Arrays.deepToString(iArray));
	     /*
	      * System.arraycopy(
	      *    src = source array
	      *    srcPos = source position
	      *    dest = destination array
	      *    destPos = destination pos
	      *    number = elements to copy
	      * )
	      */
	     System.out.println("Copy an array:\n");
	     int[] jArray = new int[hArray.length];
	     System.arraycopy(hArray, 0, jArray, 0, hArray.length);
	     System.out.println("\nPring array:" + Arrays.toString(hArray) );

	     System.out.println("\nJDK1.8 you can use aggregate operations and a lambda expression:\n");
	     Arrays.stream(hArray).forEach(System.out::println);
	     
	     System.out.println(
	         "\nArray manipulations  in java.util.Arrays class.\n" +
	         "\nbinarySearch - Searching an array for a specific value to get the index at which it is placed\n" +
	         "\nequals - Comparing two arrays to determine if they are equal or not\n" +
	         "\nfill - Filling an array to place a specific value at each index\n" +
	         "\nsort - sort sequentially\n" +
	         "\nparallelSort - sort concurrently\n"
	     );
	     // TODO: sample of each 
	     System.out.println(
	    	 "Operator Precidence:\n" +
	         "http://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html\n"
	     );
	     System.out.println(
		 	        "Assignment, Arithmetic, and Unary Operators\n" +
		 		   "=============================================================\n"
		 	     );        
	     int result = 1 + 2;
	        // result is now 3
	        System.out.println("1 + 2 = " + result);
	        int original_result = result;

	        result = result - 1;
	        // result is now 2
	        System.out.println(original_result + " - 1 = " + result);
	        original_result = result;

	        result = result * 2;
	        // result is now 4
	        System.out.println(original_result + " * 2 = " + result);
	        original_result = result;

	        result = result / 2;
	        // result is now 2
	        System.out.println(original_result + " / 2 = " + result);
	        original_result = result;

	        result = result + 8;
	        // result is now 10
	        System.out.println(original_result + " + 8 = " + result);
	        original_result = result;

	        result = result % 7;
	        // result is now 3
	        System.out.println(original_result + " % 7 = " + result);
	     
	        // sting concatination using + 
	        String firstString = "This is";
	        String secondString = " a concatenated string.";
	        String thirdString = firstString+secondString;
	        System.out.println(thirdString);
	        
	        //The Unary Operators
	        int result2 = +1;
	        // result is now 1
	        System.out.println(result2);

	        result2--;
	        // result is now 0
	        System.out.println(result2);

	        result2++;
	        // result is now 1
	        System.out.println(result2);

	        result2 = -result2;
	        // result is now -1
	        System.out.println(result2);

	        boolean success = false;
	        // false
	        System.out.println(success);
	        // true
	        System.out.println(!success);
	        
	        System.out.println(
	        		"\nEquality, Relational, and Conditional Operators\n"
	        );
	        int value1 = 1;
	        int value2 = 2;
	        if(value1 == value2)
	            System.out.println("value1 == value2");
	        if(value1 != value2)
	            System.out.println("value1 != value2");
	        if(value1 > value2)
	            System.out.println("value1 > value2");
	        if(value1 < value2)
	            System.out.println("value1 < value2");
	        if(value1 <= value2)
	            System.out.println("value1 <= value2");
	        
	        if((value1 == 1) && (value2 == 2))
	            System.out.println("value1 is 1 AND value2 is 2");
	        if((value1 == 1) || (value2 == 1))
	            System.out.println("value1 is 1 OR value2 is 1");
	        
	        boolean someCondition = true;
	        result = someCondition ? value1 : value2;
	        System.out.println("\nresult: " + result + "\n");
	        
	        // The Type Comparison Operator instanceof
	        Parent obj1 = new Parent();
	        Parent obj2 = new Child();
	        System.out.println("obj1 instanceof Parent: "
	            + (obj1 instanceof Parent));
	        System.out.println("obj1 instanceof Child: "
	            + (obj1 instanceof Child));
	        System.out.println("obj1 instanceof MyInterface: "
	            + (obj1 instanceof MyInterface));
	        System.out.println("obj2 instanceof Parent: "
	            + (obj2 instanceof Parent));
	        System.out.println("obj2 instanceof Child: "
	            + (obj2 instanceof Child));
	        System.out.println("obj2 instanceof MyInterface: "
	            + (obj2 instanceof MyInterface));	       
	        
	        System.out.println("\nBitwise and Bit Shift Operators\n");
            int bitmask = 0x000F;
            int val = 0x2222;
            // prints "2"
            System.out.println( "\nval:" + val );
            System.out.println( "\nval & bitmask:" + (val & bitmask) );

            //-----------------------------------------------------------
   	        System.out.println(
		 	    "============================================================="
		 	);
   	        int result_exercise = 1 + 2; // result is now 3
            System.out.println(result_exercise);

            result_exercise -= 1; // result is now 2
            System.out.println(result_exercise);

            result_exercise *= 2; // result is now 4
            System.out.println(result_exercise);

            result_exercise /= 2; // result is now 2
            System.out.println(result_exercise);

            result_exercise += 8; // result is now 10
            result_exercise %= 7; // result is now 3
            System.out.println(result_exercise);            
   	        System.out.println(
		 	    "=============================================================\n"
		 	);
   	        int i = 3;
   	        i++;
   	        System.out.println(i);    // "4"
   	        ++i;                     
   	        System.out.println(i);    // "5"
   	        System.out.println(++i);  // "6"
   	        System.out.println(i++);  // "6"
   	        System.out.println(i);    // "7"   	        
   	        System.out.println("  6 prints twice because i++ increments after the print\n");
            //-----------------------------------------------------------
	       
   	        System.out.println(
   	            "\nExpressions, Statements, and Blocks:\n" +
   	            "\nExpressions are the core of statements" +
   	            "\nStatemetns end in a ;" +	
   	            "\nStatements may be grouped into blocks\n"
   	        );
   	        System.out.println(
   	        	"=============================================================\n" +
    	        "\nControl Flow Statements" +
   	            "\ndecision-making statements (if, if-else, switch)" +
   	            "\nlooping statements (for, while, do-while)," +
   	            "\nbranching statements (break, continue, return)" +
   	            "\n=============================================================\n"
   	        );
   	        System.out.println(
    	        "=============================================================\n" +
     	        "\nif-else can test expressions based on ranges of values or conditions\n" +
     	        "\n=============================================================\n"
   	    	);
   	        int testscore = 76;
   	        char grade;

   	        if (testscore >= 90) {
   	            grade = 'A';
   	        } else if (testscore >= 80) {
   	            grade = 'B';
   	        } else if (testscore >= 70) {
   	            grade = 'C';
   	        } else if (testscore >= 60) {
   	            grade = 'D';
   	        } else {
   	            grade = 'F';
   	        }
   	        System.out.println("Grade = " + grade);
   	        //========================================================
   	        System.out.println(
   	            "=============================================================\n" +
   	     	    "\nswitch-case baded on single integer, enumerated value, or String object.\n" +
   	     	    "\n=============================================================\n"
   	   	    );
   	        int month = 8;
   	        String monthString;
   	        switch (month) {
   	            case 1:  monthString = "January";
   	                     break;
   	            case 2:  monthString = "February";
   	                     break;
   	            case 3:  monthString = "March";
   	                     break;
   	            case 4:  monthString = "April";
   	                     break;
   	            case 5:  monthString = "May";
   	                     break;
   	            case 6:  monthString = "June";
   	                     break;
   	            case 7:  monthString = "July";
   	                     break;
   	            case 8:  monthString = "August";
   	                     break;
   	            case 9:  monthString = "September";
   	                     break;
   	            case 10: monthString = "October";
   	                     break;
   	            case 11: monthString = "November";
   	                     break;
   	            case 12: monthString = "December";
   	                     break;
   	            default: monthString = "Invalid month";
   	                     break;  // NOT NEEDED
   	        }
   	        System.out.println( "Month:" + monthString + "\n");
            System.out.println(
   	   	   	        "\n=============================================================\n"
   	   	   	   	);
            
            int count = 1;
   	        
            do {
   	            System.out.println("Count is: " + count);
   	            count++;
   	        } while (count < 11);
   	        
            System.out.println(
   	   	        "\n=============================================================\n"
   	   	   	);
            for(int j=1; j<11; j++){
                System.out.println("Count is: " + j);
            }
            
            System.out.println(
       	        "\n=============================================================\n"
           	);
            System.out.println(
            	"\ninfinite loop\n" +
                "for ( ; ; ) { /*<stuff>*/ }"
            );
            System.out.println(
           	    "\n=============================================================\n" +
               	"\nCompact form of for loop: for(int x : array){ /*<stuff>*/ }\n"
            );
            int[] numbers = {1,2,3,4,5,6,7,8,9,10};
            for (int item : numbers) {
                System.out.println("Count is: " + item);
            }
            System.out.println(
            	"Breaks - labeled and unlabeled:\n" +
                "labeld break : terminates an outer statement\n" +
            	"unlabeled break: terminates innter statement\n"
            );
            System.out.println(
                "continue Statement: skip current iteration of for, while , or do-while loop\n"
            );
            System.out.println(
                "return Statement: exits from the current method\n"
            );
	} // end main
	
}
// for use to demonstrate instanceof
class Parent {}
class Child extends Parent implements MyInterface {}
interface MyInterface {}

package Lect06;

import java.util.ArrayList;

public class MyClass {
	
	// ArrayLists are mutable 
	public void test1(){
		// allocate pointer for a wug object
		ArrayList<Wug> wugs;
		// allocate memory for the wug object
		wugs = new ArrayList<>();
		// add to the list
		wugs.add( new Wug("joe") );
		// Print the wug
		System.out.println(wugs.get( 0 ));
	    // override position zero
		wugs.add( 0, new Wug("mary") );
		wugs.add( 0, new Wug("sam") );
		// Print the wug
		System.out.println(wugs.get( 0 ));	
	}

	// ArrayLists are mutable 
	public void test3(){
		// allocate pointer for a wug object
		ArrayList<String> flavors;
		// allocate memory for the wug object
		flavors = new ArrayList<>();
		// add to the list
		flavors.add( new String("joe") );
		// Print the wug
		System.out.println(flavors.get( 0 ));
	    // override position zero
		flavors.add( 0, new String("mary") );
		// Print the wug
		System.out.println(flavors.get( 0 ));
		flavors.remove( "sam" );
		System.out.println(flavors.size());
		System.out.println(flavors);
	}
	public void test2(){
		ArrayList<String> flavors;
		flavors = new ArrayList<>();
		flavors.add( "vannilla" );
		flavors.add( "chocolate" );
		flavors.add( "strawb" );
		System.out.println(flavors);
		// Now get the first element
		String s1 = flavors.get( 0 );
		System.out.println(s1);
		// Change the first element
		flavors.set(0, "mocha");
		// s1 does not change beause the assignment was by value
		System.out.println(s1);
		System.out.println(flavors);
	}
	public void test4(){
		ArrayList<Double> list = new ArrayList();
		// shows a for loop 
		// in about 30 seconds
		for (int i = 0; i < 5; i++) {
			// add to the list
		    list.add(i, Math.random() );
		    System.out.println(list.get(i));
	    }
		// foreach element
		double current_max = 20;
		for(Double n: list){
			if ( n > current_max ){
				current_max = n;
			}
		}
		System.out.println("Max"+current_max);
		
	}
	public void stest5(){
		ArrayList<Double> nums = new ArrayList();

		/* 
		 * Chapter 5 person class.. covers deep copy 
		 * methods that check position, use .equals defaults to ==
		 * .clone makes a shallow copy of an ArrayList
		 * 
		 */
		
		/*
		 * Every time someone clicks a point is added
		 * a line is drawn to the point before and after
		 * ClickDraw class
		 *  Need to create an ArrayList of Points
		 *  draw lines between paired points
		 * 
		 */
	}	
	
	static void test6( String... flavors){
		
	}
	
	public static void main(String[] argv){
		test6("foo", "bar", "foom");
		System.out.println("Today we will cover ArrayList");
		/*
		 * Static is a nasty keyword, context is King
		 *   - static fields  stay in the class, are global
		 *   - static methods stay in the class, are global
		 *   - static objects ???
		 *   
		 *   - static creates multi-thread bugs
		 *   
		 * Todays class: Arrays  (Sequences )
		 *   one dimtional arrays 
         *   array lists
		 * 
		 */
		
		 MyClass c1; // allocates the small box, points to null
		 c1 = new MyClass(); // allocates memory big boxs, updates small box
		 MyClass c2 = new MyClass(); // does the previous two things
		 c1 = c2; // shallow copy. little box c1 now points to little box c2.
		
		 /*
		  *  Some ways to store arbitrary items 
		  *  in an "ordered" list
		  *  of homogeneous elements
		  *  
		  *  -- some saw StringBuilder
		  *  
		  *  ArrayLists should be used all the time
		  *  Arrays are the old way
		  *  
		  *  they have a Length and Index
		  *  
		  *  looping though an array, stop before index = length, 
		  *  because first element is in index 0.
          *  
          *  ArrayLists - cant contain primitives (auto-boxing)
          *  
          *  Collection
          *  |
          *  |-Set:   unordered list
          *  |-List:  ordered
          *  |-Queue: adding and removing to front or back
          *  |-Deque: adictionary 
          */
         
		 
		 
          /*  
          * Arrays are built in 
          * Primitive types there is no pointer crap
          * There is no .get
          */
		 double[] scores;          // pointer to an array of double to null
         scores = new double[10];  // must specify size.  now pointer is initialize, init to zero
         double score_1 = scores[0]; 
         double score_2 = scores[1];
         String[] flavors = new String[6];
         for (int i=0; i < flavors.length; i++ ){
        	 flavors[i] = "vanilla";
         }
         System.out.println(flavors);
         
         // Arrays can be returned from a method.
         // Arrays can be paramters to a method.
		 // hard to insert crap in the middle
         /*
          * Array more efficient than ArrayList
          *   with primitives (ArrayList stores wrapper primitives)
          *   [] notation is convenient... some like it more
          * ArrayList
          *   muteable
          *   method syntax() for doing stuff
          *
          */
         /*
          * If you don't know the size of stuff, use an ArrayList
          * Most of the time.
          * 
          */
         
         /*
          *     Type... foo
          */
         
         
//		 private ArrayList<String> flavors; // seq of strings
//		 flavors = new ArrayList<String>();
//		 
//		 public ArrayList<Point> points = new ArrayList<>();
//		 public ArrayList<Person> people = new ArrayList<Person>();
		 
		 c1.test1();
		 c1.test2();
		 c1.test3();
		 c1.test4();
		 
		 
		 
		 
	}

}

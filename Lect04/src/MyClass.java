/*
 * 
 * 
 * 
 */
import java.math.BigInteger;
import java.util.Random;


public class MyClass {
	  
	private String myName = new String();
	private int myAge = 0;
	static int numInstances = 0; // true global, access via MyClass.numInstances
	
	public static void main (String[] args)
	  {
		  /*
		   * Main is usually used to run tests
		   * 
		   * 
		   *  Chapter 5, section 2 draws pics of mem allocation
		   *  
		   *  Must call new for all but String, which is special
		   *  
		   *  Method overloading
		   *    2 or more methods have same name but different parameters
		   *  
		   *  No operator overloading in java
		   *  
		   *  Constructor,  
		   *     use the name of the class and have no return type
		   *     always has same name as class
		   *     has no type returned, not even void
		   *     constructors are typical overloaded.
		   *
		   *  'new' calls the constructor
		   *  
		   *  'this' is used to refer to the object that called a method
		   *    
		   *  boolean values initialize to false by default
		   *  
		   *  Read 
		   *  Chapter 5.1 is static methods
		   *  Chapter 5.2 is memory
		   *  Chapter 5.3 is complicated
		   *  Chapter 5.4 is pitfalls
		   *  
		   *  public static int getAnswer( int p1, String p2);
		   *          ^
		   *          | Invoked using class_name.method
		   *          |  invoked not on the instance of the object.
		   *          |  can't use 'this' inside 
		   *            
		   *  From a static method, you can't access non-static crap
		   *    to get around this, make a 'New' object.
		   * ----------------------------------------------------
		   * static instance variables
		   *   - live in the class (not the instance)
		   *   - if it is 'public' it is a true 'global variable'
		   * 
		   *   * Non-static methods can access static variables
		   *   
		   *   - always make private
		   *   - prepend 'final' to make it a 'constant'.
		   *      public static final int EPOC = 1970;
		   * -----------------------------------------------------
		   * static classes
		   *   - yes
		   * -----------------------------------------------------
		   * static blocks
		   *  - yes 
		   *  - like a constructor, run onece before the class is used
		   *   
		   * -----------------------------------------------------
		   * Random Class is cool
		   * -----------------------------------------------------
		   */
		   System.out.println("main() block");
		   MyClass foo = new MyClass("foobar");
		   System.out.println("MyName:" + foo.getName() );
		   MyClass bar = new MyClass(10);
		   System.out.println("MyName:" + bar.getName() );
		   
		   // return psudo random number from 0.0 to 1.0
		   double num = Math.random();
		   // Better class is Random Class
		   Random rnd = new Random();
		   int i = rnd.nextInt(10); // Random 0 to 9
		   double d = rnd.nextDouble(); // d is >=0 and < 1
		   boolean b = rnd.nextBoolean(); // 0 or 1
		   
		   // unbloxing
		   Double price = 3234.50;
		   price = price * 1.0345; // this unboxes Double into double (wierd)
		   System.out.println(Integer.MAX_VALUE);
		   System.out.println(Long.MAX_VALUE);
		   BigInteger bi = BigInteger.ONE;
		   while ( true ) {
			   System.out.print( "Doubleing" );;
			   bi = bi.multiply( BigInteger.valueOf( 2 ) );
			   System.out.println(bi);
		   }
		   /* Look up string tokenizer
		    * Lookup the methods of Class wrappers for the basic types.
		    *
		    * non class variables are stored inside the box. ( == will work )
		    * object variables are not stored in the same box ( == will not work )
		    * if they are auto-unboxed, they will be in the same box ( == will work)
		    * 
		    * .equals() comes for free on any class, can be overloaded
		    * 
		    * null  special const, but not an object, and is default for any class
		    *    MyClass foo;
		    *    foo.equals() // error
		    *    if ( foo != null){ 
		    *       foo.equals() ;
		    *    }
		    *    
		    */
	  }
	  /*
	   *  Wack static block
	   *  Runs before anything else
	   */
	
	  static {
		  System.out.println("Static block");
	  }
	  
	  void setName(String name){
		  myName = name;
	  }
	  void setName(int name){
		  myName = "My name is:" + name;
	  }
      int getAge(){
    	  return myAge;
      }
      String getName(){
    	  return myName;
      }
      // These constructors end up calling the last one
	  MyClass(){
		  this("NONAME", 0);
	  }
	  MyClass(String name ){
		  this(name, 0);
		  
	  }
	  MyClass(int age ){
		  this("NONAME", age);
	  }
	  // This one is ultimately called
      MyClass(String name, int age ){
		  this.myName = name;
		  this.myAge = age;
		  numInstances += 1;
	  }
}

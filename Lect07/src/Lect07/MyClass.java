package Lect07;

/*
 * How did we do in the Lab02
 * At the end he will cover part a, b, and c.
 * .= is a method every single class inherits.
 * compares two objects and says if they are equal
 * Chapter07 covers this.
 * 1) where is it stored in memory, for class objects.
 * Classes are 'templates' to make objects
 * Classes are 'types'. Objects have a 'type'.
 * Inheritance: deals with classes not objects.
 * derived class base class
 * subclass superclass
 * child parent
 * derived
 * - has access to 'base' methods, (can override them?)
 * - 'is a' relationship.
 * Instantiation - making an object from a class
 * Abstract classes can't be instantiated
 * extends - creates subclass
 * 'public' accessible to anything
 * 'privately' declared class fields are not inherited by derived class
 * 'protected' declared class fields, are access to subclass, package, base
 * class.
 * 'package' not like anything else
 * 'private' methods essentially not present in subclass.
 * Overriding a Method Definition
 * 
 * In the constructor, the parent is called first.
 * You can also specify by calling:
 *      super();
 *      and 
 *      super.method();
 * 
 * overriding method can't set weaker access privilege level.
 * 
 * 'final' method modified can't be overridden 
 * 'final' class can't be a base class.
 * 'final' filed is a  constant
 * 
 * 'is a'    Inheritance
 * 'has a'   what methods and fields are available
 * 
 * 'static' fields live in the class, but are inherited, they share the same item.
 * 
 * implicit 'extends Object' when no other extends is given.
 * 
 * If the implicit super() is called 
 * but the super class does not have a zero parameter constructor
 * you get a compile time errors
 * 
 * Chapter07 covers reflexic method equals()
 * 
 * Object.getClass() returns a Class object
 *     Class c = this.getClass()
 *     
 * Object.instanceof() is an operatero that returns boolian 
 *     this instanceof ModNCounter
 *     // not commonly used
 *   
 */
public class MyClass {

	public static void main( String[] argv ) {
		MyClass a = new MyClass();
		MyClass b = new MyClass();
		b = a;

		if ( a.equals( b ) ) {
			System.out.println( "these are equal" );

		}
		Counter c = new Counter();
		c.increment();
		c.increment();
		System.out.println( "c: " + c.getValue() );
		//----------------------------------------
		System.out.println("Enter ResetableCounter");
		ResetableCounter rc = new 	ResetableCounter();
		rc.increment();
		rc.increment();
		System.out.println("rc: "+ rc.getValue());
		// our new method
		rc.reset();
		System.out.println("rc: "+ rc.getValue());
		//------------------------------------------
		ModNCounter mc = new ModNCounter(2);
		System.out.println(mc);
		mc.increment();
		System.out.println("mc: "+ mc.getValue());
		//------------------------------------------
	}
}

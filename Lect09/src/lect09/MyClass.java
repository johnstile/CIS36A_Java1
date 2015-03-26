package lect09;

/*
 * 'implements' is a promise to implement everything 
 * listed in the Ordered interface
 */
public class MyClass implements Ordered {
	/*
	 *    interfaces
	 *    - you can have multiple interfaces 
	 *    - you can't have multiple in heartens
	 *    - place holders, but implement nothing
	 *    -- They are all public and abstract
	 *    - place a ',' between multiple interfaces
	 *    - A way to loosely couple  things
	 *    - Some create the interfaces, then write the implements
	 *    
	 *    - You can have abstract classes implementing the interface
	 *   JAVA8:
	 *     'default' methods - methods with bodies in the interface
	 *           - if implementing method does not implement
	 *             then, the 'default' is used.
	 *           - The implementing class can call a specific default
	 *           if classA implements b(){
	 *              b.super.doit()    
	 *           } 
	 *     
	 *    You can extend and implement at the same time.
	 *    
	 *    Naming: interfaces start with 'I'
	 *----------------------------------------------------------
	 *  Inner classes:   classes defined inside other classes
	 *  - like an instance variable, it is part of the outer class
	 *  - inner class has access to private fields in outer class
	 *  - inner class private fields can't be accessed by outer class
	 *  
	 *  comparator
	 *  comparable
	 *  anonymous classes
	 *  
	 *  Lab Monday, due Friday
	 *  
	 *  Design Patters
	 *  = Divide program into 'Observer' and 'Observable'
	 *    Your state model extends the abstract class Observable
	 *    Bunch of method that implement Observer
     *    you create an add method to add observers 
     *    There is a getNotified method and Send
     *  class Source extends Observable
     *  class Target implements Observer
     * 
     * Model     --- state of the program
     * View      --- output
     * Control   --- input
	 *  
	 */
	@Override
	public boolean preceds( Object other ) {
		// NOTE Auto-generated method stub
		return false;
	}

	@Override
	public boolean folows( Object other ) {
		// NOTE Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo( Object other ) {
		// Returns -1 if object comes before this object
		// Returns 0 if Object is the same as this 
		// Returns 1 if Object is after this object
		
		return 0;
	}


}

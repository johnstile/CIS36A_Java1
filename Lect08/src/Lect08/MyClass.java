package Lect08;

import java.awt.Point;
import java.util.ArrayList;

public class MyClass {
	
	public static void main(String[] argv){
		System.out.println("Lectur08");
		/*
		 * Polymorphism:   
		 *    Allows code in base class to be used by a subclass
		 *    Allows the subclass to use code in the base class.  
		 *    
		 * 
		 * Discuss: static vs dynamic types
		 * Next week: interfaces
		 * 
		 * 
		 * super - refers to the super class (first line of constructor)
		 * this  - refers to this object
		 * 
		 * Late Binding:  choosing a method at run time (dynamic binding)
		 * Early Binding: choosing a method at compile time (static binding)
		 * 
		 * Book says Polymorphism is late binding.
		 * 
		 * Exceptions to Late Binding:  private, final, or static  Methods
		 * 
		 * static type = compiler uses
		 * dynamic type = runtime uses
		 * static types can: 
		 *   be the same as dynamic, 
		 *   be a super class of a dynamic type
		 *
		 * Static methods are inherited
		 * Static methods are Bound Early
		 *-------------------------------------------------------
		 *  Abstract classes:
		 * What is the different between abstract classes and interfaces?
		 * 
		 * example: Chapter7, Employee.
		 *   never an instance of Employee
		 *   
		 * 
		 * define a class that can't have an instance
		 * make a stub for a class, but don't implement it
		 * 
		 * Would it make sense to make Alien an abstract class?
		 *     Yes!!!
		 *     the getDammage() will be a stub
		 *     every type of Alien will implement getDammage()
		 * 
		 */
		
		/*
		 *  Animal is the superclass, Dog is the subclass
		 *  Demonstrating Polymorphism
		 */
		//Animal d = new Dog();
		ArrayList<Object> a = new ArrayList<>();
		a.add( new Object() );
		a.add( new String("hello there")); 
		
		// Late Binding, figures out the proper method at runtime
	    for  (Object o : a ){
	    	System.out.println(o.toString());
	    }
		
	    Point p = new Point(4,5);
	    p.move( 100, 100 );
	    a.add( p );
	    
	    /* Compiler sees this as the static type ( Ojbect)
	     *  wich does not have a move() method.
	     */
	    //a.get(2).move(3,5);  
	    
	    // Casting tells the compiler to Buz Off.
	    ( (Point) a.get(2) ).move(3,4);
	    // Casting gets past the compiler
	    // But will lead to run time errors if the method is not present.
	    
	    // Runtime: What is the most specialized class of an object?
	    
	    Superclass obj1 = new Subclass ();
	    obj1.print();
	    // prints sub
	    
//	    Subclass obj2 = new Superclass();
//	    obj2.print()
		// compile time error
	    
	    Superclass obj3 = new Superclass();
	    //((Subclass) obj3).print();
	    // Run time error (can't cast something to a derrived class)
	    
	    Subclass obj4 = new Subclass();
	    ( (Superclass) obj4 ).print();
	    // print sub,  cast does nothing, not even a warning
	    // "using the most specialized method" 

	}    

}

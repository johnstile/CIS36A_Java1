package Lect03;
public class MyClass {
	public static void main( String[] argv)
	{
		System.out.println(
		  "\nhttp://www.berkeleycitycollege.edu/wp/de/moodle-info/\n"
		+ "Read about mastering structs in c.\n"
		+ "\nA class:\n"
		+ "\tA continaer\n"
		+ "\tA template, or factory that builds things (objects)\n"
		+ "\tA metaphor for things in the world\n"
		+ "\tA type\n"
		+ "\n"
		+ "Wug w;  // Stores pointer in memory to null\n"
		+ "\tMethods and method member variables are stored in \n"
		+ "\tAny object in java can be null, so you have to test for null\n"
		+ "w = new Wug(); // Stores space for every field in class\n"
		+ "w.myAge = 1; // store 1 in the area for the field\n"
		+ "w.myName = \"Line\"; // Store pointer in the area for the field to String in memory\n"
		+ "\tThe test == tests a memory location\n"
		+ "\tCan always test primitives with ==\n"
		+ "\tCan't always test field of two objects with ==, as they are stored in diff locations\n"
		+ "\n"
		+ "a.equals(b)  // would return boolean\n\n"
		+ "Arguments to method are passed by value, not by reference\n"
		+ "A static method in java must read: http://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html\n"
		+ "A static method will modify the things it acts on\n"
		+ "Global variables have scope though the entire program\n"
		+ "\n"
		+ "this - a hidden reference to the object makeing the call.\n"
		+ "\n"
		+ "Make member fields private, so they are only modified via setter/getter\n"
		+ "\n"
		+ "Passing primitive is by value\n"
		+ "Passing an object is by reference\n"
		+ ""
		); //$NON-NLS-1$
		
		Wug w1;
		w1 = new Wug();
		
		Wug w2 = new Wug();
		
		w1.introduce();
		
		
		
	}

}

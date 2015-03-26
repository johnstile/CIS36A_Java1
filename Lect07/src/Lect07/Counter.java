package Lect07;

public class Counter {
	/*
	 * It is best to make everything private,
     * and make getters, setters
	 */
	
	// Accessible by child class
	//public int myCounter;
	
	// Not accessible by child class
	//private int myCounter;
	
	// Anything in our package can access
	protected int myCounter;

	/*
	 * Trying to create a constructor to call another
	 */
	public Counter(int n){
		this();
		System.out.println("Calling Counter(int) constructor");
		myCounter = 0;
	}
	/*
	 * This is our default constructor
	 */
	public Counter(){
		System.out.println("Calling Counter() constructor");
		myCounter = 0;
	}
	public void increment(){
		myCounter ++;
		
	}
	public int getValue(){
		return myCounter;
	}
	public void setValue(int n){
		myCounter = n;
	}
}

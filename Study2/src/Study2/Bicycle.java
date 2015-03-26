package Study2;
/*  The Java™ Tutorials 
 *     Classes and Objects
 *     http://docs.oracle.com/javase/tutorial/java/javaOO/index.html
 * 
 * You want a number of Bicycle objects, 
 *   each has a serial number 'instance variable'
 * You want a 'class field' to keep track of how many bicycle objects exist
 *   to help deside on the next serial number to assign
 *   
 *   instance methods can access:
 *      instance variables
 *      instance methods
 *      class methods
 *   class methods can access:
 *      class variables
 *      class methods
 *      Not instance variables
 *      Not instance methods
 *      Not use 'this' keyword
 *   
 *   'static' modifier indicates the 
 *   'final' modifier indicates that the value of this field cannot change
 *       constant values are spelled in uppercase letters separated by _
 *       
 */
public class Bicycle {
    
    private int cadence;
    private int gear;
    private int speed;
        
    // add an instance variable for the object ID
    private int id;
    
    // static qualifier on a variable 
    //creates a class variable for the
    // number of Bicycle objects instantiated
    private static int numberOfBicycles = 0;
    
    /*
     * Constructor sets id and increment class field
     */
	public Bicycle(
	    int startCadence, 
	    int startSpeed, 
	    int startGear
	){
	    gear = startGear;
	    cadence = startCadence;
	    speed = startSpeed;
	
	    // increment Class variable for number of Bicycles
	    // and assign ID number
	    id = ++numberOfBicycles;
	}
	// new method to return the ID instance variable
    public int getID() {
        return id;
    }
    /* static modifier in method declarations, 
     * allows the method to be invoked without an instance of the class
     * Making this a Class Method
     */
    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }
    /*
     * They add a bunch of getters and setters
     */
    public int getCadence(){
        return cadence;
    }
        
    public void setCadence(int newValue){
        cadence = newValue;
    }
        
    public int getGear(){
    return gear;
    }
        
    public void setGear(int newValue){
        gear = newValue;
    }
        
    public int getSpeed(){
        return speed;
    }
        
    public void applyBrake(int decrement){
        speed -= decrement;
    }
        
    public void speedUp(int increment){
        speed += increment;
    }
}

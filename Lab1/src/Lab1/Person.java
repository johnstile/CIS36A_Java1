/*
 * By: John Stile
 * Assignment: Lab1 (part c)
 */
package Lab1;

/*
 * By: John Stile <john@stilen.com>
 * Assignment: Lab1 (part C)
 */
import java.util.Random;

public class Person {
	private Name		myName;
	private String		hair_color	= null;			// set default to null
	private int			height;
	private int			id;							// unique to each
														// instance
	private static int	id_count;						// class variable, keep
														// track of what has
														// been
														// assigned
	private Random		rand		= new Random();
	private int			min_height	= toInches( 4, 3 );
	private int			max_height	= toInches( 7, 6 );

	/*
	 * Create several Constructors
	 * must supply first and last
	 * for constructor where hair color not specified, set to null
	 * for constructor where height is unspecified, set to random number from
	 * 4'3" to 7'6"
	 */
	Person( final String name_first,
			final String name_last,
			String new_hair_color,
			int new_height ) {
		// Increment global id count, and assign to this user
		id = ++id_count;
		// Set the name
		myName = new Name( name_first, name_last );
		;
		// no-height means pick random height
		if ( new_height == 0 ) {
			set_height( randInt( min_height, max_height ) );
		}
		else {
			height = new_height;
		}
		// No hair color means
		hair_color = new_hair_color;
	}

	Person( String name_first, String name_last ) {
		this( name_first, name_last, null, 0 );
	}

	Person( String name_first, String name_last, String new_hair_color ) {
		this( name_first, name_last, new_hair_color, 0 );
	}

	Person( String name_first, String name_last, int new_height ) {
		this( name_first, name_last, null, new_height );
	}

	/*
	 * The Person class methods name() and initials()
	 * should return the same values that the Name class methods
	 * (of the same name) return. These should be Person class
	 * methods, however.
	 */
	private String name() {
		return myName.name();
	}

	private String initials() {
		return myName.initials();
	}

	/*
	 * There should be a getter for hair that returns a String.
	 * If hair color was unspecified, return "hair color is unspecified"
	 */
	private String getHairColor() {
		if ( hair_color != null ) {
			return hair_color;
		}
		else {
			return "hair color is unspecified";
		}
	}

	/*
	 * There should be a getter for height
	 * that returns the height in inches
	 */
	private int getHeight() {
		return height;
	}

	/*
	 * There should be a getter for id
	 */
	private int getId() {
		return id;
	}

	/*
	 * convert feet and inches to inches
	 */
	private static int toInches( int feet, int inches ) {
		return ( feet * 12 ) + inches;
	}

	/*
	 * Generate a random number from min to max
	 */
	private static int randInt( int min, int max ) {
		Random rand = new Random();
		int randomNum = rand.nextInt( ( max - min ) + 1 ) + min;
		return randomNum;
	}

	private void set_height( int randInt ) {
		height = randInt;
	}

	/*
	 * Text methods
	 */
	public static void main( String[] args ) {
		/*
		 * Testing height range
		 */
		int min = 5;
		int max = 10;
		System.out.println( "Random (" + min + "," + max + "):"
				+ randInt( min, max ) );
		// Call each constructor
		Person myPerson1 = new Person( "foo", "bar" );
		Person myPerson2 = new Person( "fee", "fi", 90 );
		Person myPerson3 = new Person( "fo", "fum", "red" );
		Person myPerson4 = new Person( "ying", "yang", "red", 70 );
		// Test name()
		System.out.println( "myPerson1.name():" + myPerson1.name() );
		System.out.println( "myPerson2.name():" + myPerson2.name() );
		System.out.println( "myPerson3.name():" + myPerson3.name() );
		System.out.println( "myPerson4.name():" + myPerson4.name() );
		// Test initials()
		System.out.println( "myPerson1.initials():" + myPerson1.initials() );
		System.out.println( "myPerson2.initials():" + myPerson2.initials() );
		System.out.println( "myPerson3.initials():" + myPerson3.initials() );
		System.out.println( "myPerson4.initials():" + myPerson4.initials() );
		// Test getHairColor()
		System.out.println( "myPerson1.getHairColor():"
				+ myPerson1.getHairColor() );
		System.out.println( "myPerson2.getHairColor():"
				+ myPerson2.getHairColor() );
		System.out.println( "myPerson3.getHairColor():"
				+ myPerson3.getHairColor() );
		System.out.println( "myPerson4.getHairColor():"
				+ myPerson4.getHairColor() );
		// Test getHeight()
		System.out.println( "myPerson1.getHeight():" + myPerson1.getHeight() );
		System.out.println( "myPerson2.getHeight():" + myPerson2.getHeight() );
		System.out.println( "myPerson3.getHeight():" + myPerson3.getHeight() );
		System.out.println( "myPerson4.getHeight():" + myPerson4.getHeight() );
		// Test getId()
		System.out.println( "myPerson1.getIdt():" + myPerson1.getId() );
		System.out.println( "myPerson2.getIdt():" + myPerson2.getId() );
		System.out.println( "myPerson3.getIdt():" + myPerson3.getId() );
		System.out.println( "myPerson4.getIdt():" + myPerson4.getId() );
		// Exercise the class variable
		System.out.println( "Person.id_count:" + Person.id_count );
	}
}

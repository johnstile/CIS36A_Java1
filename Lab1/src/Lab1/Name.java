package Lab1;

/*
 * By: John Stile
 * Assignment: Lab01 (Part C)
 */
public class Name {
	private String	firstName;
	private String	secondName;
	private int		gender;	// 1=mail,2=female

	/*
	 * ctor used by People class
	 */
	Name( String firstName, String secondName ) {
		setName( firstName, secondName, 1 );
	}

	Name() {
		this( "NoFirstName", "NoSecondName" );
	}

	/*
	 * Set the name stored in object
	 * 1 is male, 2 is female
	 */
	void setName( String firstName, String secondName, int gender ) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.gender = gender;
	}

	/*
	 * Returns the name (first name followed by last name).
	 * The first letter only will be capitalized in each name part.
	 */
	String name() {
		String output = firstName.substring( 0, 1 ).toUpperCase()
				+ firstName.substring( 1 ) + " "
				+ secondName.substring( 0, 1 ).toUpperCase()
				+ secondName.substring( 1 );
		return output;
	}

	/*
	 * Returns the last name, followed by a comma, followed by first name.
	 * The first letter only will be capitalized in each name part.
	 */
	String rollCallName() {
		String output = secondName.substring( 0, 1 ).toUpperCase()
				+ secondName.substring( 1 ) + " "
				+ firstName.substring( 0, 1 ).toUpperCase()
				+ firstName.substring( 1 );
		return output;
	}

	/*
	 * Returns the initials as a single, two-character, capitalized String.
	 */
	String initials() {
		String output = firstName.substring( 0, 1 ).toUpperCase()
				+ secondName.substring( 0, 1 ).toUpperCase();
		return output;
	}

	/*
	 * Returns the pig latin version of the name, all lower case.
	 * See: http://en.wikipedia.org/wiki/Pig_Latin#Rules
	 * For instance:
	 * Nate Titterton --> atenay ittertontay
	 * Evan Johnson --> evanway ohnsonjay
	 */
	String pigLatinName() {
		String output = firstName.substring( 1 )
				+ firstName.substring( 0, 1 ).toLowerCase() + "ay" + " "
				+ secondName.substring( 1 )
				+ secondName.substring( 0, 1 ).toLowerCase() + "ay";
		return output;
	}

	/*
	 * Lets test each method in main
	 */
	public static void main( String[] argv ) {
		// Testing
		Name myName = new Name();
		myName.setName( "john", "stile", 1 );
		System.out.println( "name:        " + myName.name() );
		System.out.println( "rollcallName:" + myName.rollCallName() );
		System.out.println( "initials:    " + myName.initials() );
		System.out.println( "pigLatinName:" + myName.pigLatinName() );
	}

}

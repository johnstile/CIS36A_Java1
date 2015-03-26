package Lect03;
/*
 * Within a class order does not matter
 * within a method order does matter
 */
public class Wug {
	/*
	 *  fields - instance variables
	 */
	private int myAge = 1;
	private String myName;
	/*
	 *  methods
	 */
	// this is the introduction
	void introduce(){
		System.out.println("I'm " + getMyName() + " and I'm " + myAge + " years old.");
	}
	// compares this instance with antoher 
	boolean equals(Wug otherWug ){
		return (this.myAge == otherWug.myAge && this.getMyName().equals(otherWug.getMyName() ));
	}
	int getAge(){
		return myAge;
	}

	public void copy(Wug original){
		myAge = original.myAge;
		setMyName( original.getMyName() );
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName( String myName ) {
		this.myName = myName;
	}
	public void setAge( int i ) {
		// NOTE Auto-generated method stub
		
	}
}


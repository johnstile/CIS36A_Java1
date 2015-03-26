package Lect07;

public class ModNCounter extends Counter  {
	
	// Modulus
	private int n;
	
	ModNCounter(int m){
		// This essentially calls 
		// super();
		// NOTE: DOES NOT CALL super( int );
		
		System.out.println("Calling ModNCounter() constructor");
		this.n = m;
	}
	public void increment(){
		if ( getValue() == n){
			setValue(0);
		
		} else {
			super.increment();
		}
		
	}
	// Override the default Object.toString()
	public String toString(){
		 return "---> Hay, I am a ModNCoutner";
	}
}

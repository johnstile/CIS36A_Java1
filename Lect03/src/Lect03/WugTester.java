package Lect03;
public class  WugTester {
	public static void main( String[] args ) {
		Wug w1 = new Wug();
		w1.setAge(2);
		w1.setMyName( "Foodles" );
		
		System.out.println("-----------------------\n");
		w1.introduce();
		System.out.println("-----------------------\n");
		ageTheWug(w1);
		System.out.println("-----------------------\n");
		w1.introduce();
		System.out.println("-----------------------\n");
	}
	// objects are copied by reference
	// primitive types are copyied by value
	
	// This will modify the Wug, rather than a copy 
	static int ageTheWug(Wug w){
		w.setAge(  w.getAge() + 1 );
		return w.getAge();
	}
}

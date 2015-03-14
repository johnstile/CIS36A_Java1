package HelloWorld;

public class MotorcycleTester {
	public static void main (String args[]){
		Motorcycle m = new Motorcycle();
		m.make = "Yamaha RZ350";
		// change color to red, only edit this file.
		//m.color = "yellow";
		m.color = "red";
		System.out.println("Calling showAtts...");
		m.showAtts();
		System.out.println("_________");
		System.out.println("Stating engine....");
		m.startEngine();
		System.out.println("_________");
		System.out.println("Calling showAtts...");
		m.showAtts();
		System.out.println("_________");
		System.out.println("Starting engine...");
		m.startEngine();
		System.out.println("_________");
		System.out.println("Stoping engine ...");
		m.stopEngine();
		System.out.println("_________");
		System.out.println("Stopping engine...");
		m.stopEngine();
	}

}

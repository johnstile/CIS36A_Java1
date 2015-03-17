package alien;
/*
 * Directions: lab 2 (part B).pdf
 * 
 * Test AlienPack and AlienPack2 classes 
 * Test your new subclasses of Alien.
 * 
 * In AlienTester class,  describe which of the AlienPack/AlienPack2 classes you prefer. 
 *   Which was easier to write?  AlianPack2
 *   Which would be easier for some else to use?  AlianPack
 *   Which would be safer for someone else to use? AlianPack2
 *   
 */
public class AlienTester {
     public static void main(String[] args) {
    	 
    	int health = 5;
    	
    	// Construct 
		AlienPack ap = new AlienPack();
		AlienPack ap2 = new AlienPack2();
		
		// Construct a 6 pack of aliens
		int pack = 2;
		for (int i = 0; i < pack; i++){
			Snake a = new Snake(  health, "Snake" + i );
			ap.addAlien( a );
			ap2.addAlien( a );
		}
		for (int i = 0; i < pack; i++){
			Oger a = new Oger(  health, "Oger" + i );
			ap.addAlien( a );
			ap2.addAlien( a );
		}
		for (int i = 0; i < pack; i++){
			MarshmellowMan a = new MarshmellowMan(  health, "MarshmellowMan" + i );
			ap.addAlien( a );
			ap2.addAlien( a );
		}

		// Tests
		for ( Alien a: ap.getAliens()){
	        System.out.println(
	            "Name" + a.getName()
	            + ", Health:" + a.getHealth()
	            + ", Dammage:" + a.getDammage()
	        );
		}
		for ( Alien a: ap2.getAliens()){
	        System.out.println(
	            "Name" + a.getName()
	            + ", Health:" + a.getHealth()
	            + ", Dammage:" + a.getDammage()
	        );
		}
		/*
		 * I could not have an AlienPack2 without AlienPack, but AlienPack2 is easier to write
		 * 
		 */
		
		// TODO: How do I show is-a relationship between AlienPack and AlienPack2?
		
	}
}

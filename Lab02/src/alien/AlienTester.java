package alien;
/*
 * Directions: lab 2 (part B).pdf
 * 
 * Test AlienPack and AlienPack2 classes 
 * Test your new subclasses of Alien.
 * 
 * In AlienTester class,  describe which of the AlienPack/AlienPack2 classes you prefer. 
 *   Which was easier to write? 
 *   Which would be easier for some else to use? 
 *   Which would be safer for someone else to use?
 *   
 */
public class AlienTester {
     public static void main(String[] args) {
    	 
    	int health = 5;
    	
    	// Construct 
		AlienPack ap_snake = new AlienPack();
		AlienPack ap_snake2 = new AlienPack2();
		
		// Construct a 6 pack of Snake aliens
		int pack = 6;
		for (int i = 0; i <= pack; i++){
			Alien a = new Alien( Alien.SNAKE_ALIEN, health, "Snake-" + i );
			ap_snake.addAlien( a );
		}
	
		// Tests
		for ( Alien a: ap_snake.getAliens()){
	        System.out.println(
	            "Name" + a.getName()
	            + ", Type:" + a.getType()
	            + ", Health:" + a.getHealth()
	            + ", Dammage:" + a.getDammage()
	        );
		}
		// TODO: What are some tests I should do
		// TODO: How do I show is-a relationship between AlienPack and AlienPack2?
		
	}
}

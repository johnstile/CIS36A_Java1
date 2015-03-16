package alien;

import java.util.ArrayList;

/*
 * Directions: lab 2 (part B).pdf
 */
public class AlienPack {
	/*
	 * Rewrite AlienPack, replace Alian array with ArrayList<Alien> 
	 */
    private ArrayList<Alien> aliens;
    /*
     * change the constructor, so that it doesn’t require an initial size parameter
     */
    public AlienPack() {
        aliens = new ArrayList<Alien>();
    }
    /* 
     * add an addAlien method that doesn’t require an index parameter getAliens 
     */
    public void addAlien(Alien newAlien) {
        aliens.add(newAlien);
    }
    /* make the getAliens method work with the original return value of
     * Alien[], using the ArrayList.toArray method.
     */
    public Alien[] getAliens() {
        Alien[] temp = new Alien[aliens.size()];
        return aliens.toArray(temp);

    }

    public int calculateDamage() {
        int damage = 0;
        for (Alien a : aliens) {
            if ( a.getType() == Alien.SNAKE_ALIEN ) {
                damage += a.getDammage(); // Snake does 10 damage
            } else if ( a.getType() == Alien.OGRE_ALIEN ) {
                damage += 6; // Ogre does 6 damage
            } else if ( a.getType() == Alien.MARSHMALLOW_MAN_ALIEN) {
                damage += 1; // Marshmallow Man does 1 damage
            }
        }
        return damage;
    }
}

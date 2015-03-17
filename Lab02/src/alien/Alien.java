package alien;
/*
 * Directions: lab 2 (part B).pdf
 */
public class Alien {

    public static final int SNAKE_ALIEN = 0;
    public static final int OGRE_ALIEN = 1;
    public static final int MARSHMALLOW_MAN_ALIEN = 2;
    
    private int type; // Stores one of the three above types
    private int health; // 0=dead, 100=full strength
    private String name;
    private int inflictsDammage = 0;
    public Alien(int type, int health, String name) {
        setType(type);
        setHealth(health);
        setName(name);
    }
	private void setType(int type2) {
		this.type = type2;
	}
    public int getType() {
		return type;
	}
	private void setName(String name2) {
		this.name = name2;
	}
	public String getName(){
		return this.name;
	}
	public int getHealth(){
		return health;
	}
	public void setHealth(int h){
		if ( h <= 0 ){
		    health = 0;
		} else if ( h >= 100 ){
		    health = 100;
		} else {
			health = h;
		}
	}
}
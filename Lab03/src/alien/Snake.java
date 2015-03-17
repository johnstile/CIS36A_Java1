package alien;

public class Snake extends Alien {
	private static final int inflictsDammage = 10;
	public Snake( int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	public int getDammage(){
		return inflictsDammage;
	}

}

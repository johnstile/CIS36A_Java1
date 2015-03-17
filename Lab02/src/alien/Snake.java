package alien;

public class Snake extends Alien {
	private static final int inflictsDammage = 10;
	public Snake(int type, int health, String name) {
		super(type, health, name);
		// TODO Auto-generated constructor stub
	}
	public int getDammage(){
		return inflictsDammage;
	}

}

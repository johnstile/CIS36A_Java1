package alien;

public class MarshmellowMan extends Alien {
	private static final int inflictsDammage = 1;
	public MarshmellowMan(int type, int health, String name) {
		super(type, health, name);
		// TODO Auto-generated constructor stub
	}
	public int getDammage(){
		return inflictsDammage;
	}
}

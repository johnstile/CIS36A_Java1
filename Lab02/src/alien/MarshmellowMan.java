package alien;

public class MarshmellowMan extends Alien {
	private static final int inflictsDammage = 1;
	public MarshmellowMan(int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getDammage(){
		return inflictsDammage;
	}
}

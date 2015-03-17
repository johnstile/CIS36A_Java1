package alien;

public class Oger extends Alien {
	private static final int inflictsDammage = 6;
	public Oger(int type, int health, String name) {
		super(type, health, name);
		// TODO Auto-generated constructor stub
	}
	public int getDammage(){
		return inflictsDammage;
	}
}

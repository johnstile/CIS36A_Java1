package alien;

public class Oger extends Alien {
	private static final int inflictsDammage = 6;
	public Oger(int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	public int getDammage(){
		return inflictsDammage;
	}
}

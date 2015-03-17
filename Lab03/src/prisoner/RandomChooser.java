package prisoner;

import java.util.Random;

public class RandomChooser extends Player {
	private Random rnd = new Random();

	public RandomChooser(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	// provides the players choice for this round, returning true if the
	// player should cooperate, or false otherwise.
	public boolean cooperate() {
		// RandomChooser is unpredictable
		int random = rnd.nextInt(2); // between 0 and 1
		return ( random == 0) ? true : false;
	};
}

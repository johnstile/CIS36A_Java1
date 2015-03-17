package prisoner;

public class Competitor extends Player {

	public Competitor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	// provides the players choice for this round, returning true if the
	// player should cooperate, or false otherwise.
	public boolean cooperate() {
		// Competitor always competes
		return false;
	};
}

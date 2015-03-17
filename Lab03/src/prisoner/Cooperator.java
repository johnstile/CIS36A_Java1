package prisoner;

public class Cooperator extends Player {

	public Cooperator(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	// provides the players choice for this round, returning true if the
	// player should cooperate, or false otherwise.
	public boolean cooperate() {
		return true;
	};
}

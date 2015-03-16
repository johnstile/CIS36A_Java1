package prisoner;

public class TitForTat extends Player {
	boolean yes = false; // switch to false if opponent competes

	public TitForTat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	// provides the players choice for this round, returning true if the
	// player should cooperate, or false otherwise.
	public boolean cooperate() {
		// does what ever the compeditor does on the previous turn
		return yes;
	};
	// called by the simulation framework after each turn is completed
	// parameter reflects oppenents choice in that turn.
	public void opponentChoice(boolean opponentCooperated) {
		// switch to false if opponent competes
		yes = opponentCooperated;
	}
    public void reset(){
		super.reset();
		yes = true;
	}
}

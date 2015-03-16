package prisoner;

public class Unforgiving extends Player {
	public boolean yes = true; // switch to false if opponent competes

	public Unforgiving(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	// provides the players choice for this round, returning true if the
	// player should cooperate, or false otherwise.
	public boolean cooperate() {
		return yes;
	};
	// called by the simulation framework after each turn is completed
	// parameter reflects oppenents choice in that turn.
	public void opponentChoice(boolean opponentCooperated) {
		// switch to false if opponent competes
		if ( opponentCooperated == false ){
			yes = false;
		}
	}	
}

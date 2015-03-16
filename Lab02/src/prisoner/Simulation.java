package prisoner;

import java.util.ArrayList;

/*
 * Directions: lab 2 (part B).pdf
 */
public class Simulation {

	final static boolean PROVIDE_INFORMATION_PER_TURN = false;

	// ///////////// constructors

	public Simulation(Player p1, Player p2) {
		this(p1, p2, 200);
	}

	public Simulation(Player p1, Player p2, int numberOfTurns) {

		for (int k = 0; k < numberOfTurns; k++) {
			boolean p1cooperated = p1.cooperate();
			boolean p2cooperated = p2.cooperate();
			if (p1cooperated) {
				if (p2cooperated) {
					p1.increaseScore(3);
					p2.increaseScore(3);
				} else {
					p1.increaseScore(0);
					p2.increaseScore(5);
				}
			} else {
				if (p2cooperated) {
					p1.increaseScore(5);
					p2.increaseScore(0);
				} else {
					p1.increaseScore(1);
					p2.increaseScore(1);
				}
			}

			if (PROVIDE_INFORMATION_PER_TURN) {
				System.out.println("Turn " + k + ": " + p1 + " " + p1cooperated
						+ "(score = " + p1.score() + "), " + p2 + " "
						+ p2cooperated + "(score = " + p2.score() + ")");
			}

			p1.opponentChoice(p2cooperated);
			p2.opponentChoice(p1cooperated);
		}

		System.out.println("\nGame over, " + numberOfTurns + " turns:");
		System.out.println(" Player 1 (" + p1.getClass().getName()
				+ ") has score = " + p1.score());
		System.out.println(" Player 2 (" + p2.getClass().getName()
				+ ") has score = " + p2.score());
	}

	public static void main(String[] args) {
		/*
		 * Which kind of player wins against the most other kinds of players?
		 * 
		 * Which two kinds of players score the highest together? Which kind of
		 * player scores the highest against the range of other player types?
		 * Describe a new kind of player (that could be coded) that would play
		 * better, in sothan any of the 5 players you’ve defined. Just describe
		 * the player, don’t code it!
		 */

		Simulation s0 = new Simulation(new Player("p1"), new Player("p2"), 20);

		ArrayList<Player> players1 = new ArrayList<Player>();
		players1.add(new Player("Player1"));
		players1.add(new Competitor("Competitor1"));
		players1.add(new RandomChooser("RandomChooser1"));
		players1.add(new Unforgiving("Unforgiving1"));
		players1.add(new TitForTat("TitForTat1"));

		ArrayList<Player> players2 = new ArrayList<Player>();
		players1.add(new Player("Player2"));
		players1.add(new Competitor("Competitor2"));
		players1.add(new RandomChooser("RandomChooser2"));
		players1.add(new Unforgiving("Unforgiving2"));
		players1.add(new TitForTat("TitForTat2"));

		System.out.println("Start loop");
		for (Player p1 : players1) {
			for (Player p2 : players2) {
				Simulation s = new Simulation(p1, p2, 20);
			}
		}
		System.out.println("End loop");
	}
}
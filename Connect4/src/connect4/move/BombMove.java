package connect4.move;

import connect4.player.Player;


/**
 * This is a move to place a bomb.  There is no added functionality beyond Move.
 */
public class BombMove extends Move {

    // We need to specify this, since the constructor takes an argument
    public BombMove (int column, Player player) {
        super(column, player);
        doDamage();
        try {
			player.useBomb();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
    }
    public void doDamage(){
    	System.out.println("Ouch!");
    }
}

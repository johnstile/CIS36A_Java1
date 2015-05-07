package connect4.move;

import connect4.player.Player;


public class Move {

    private int column;
    private int row;
    private Player player;
    
    /**
     * Constructor for objects of class Move
     */
    public Move(int column, Player player) {
        this.column = column;
        this.player = player;
    }

    public int getColumn() {
        return this.column;
       
    }

    public Player getPlayer() {
        return this.player;
       
    }
    // When the move is done, store the row as well
    public int getRow() {
    	return this.row;
    }
    public void setRow(int row) {
    	this.row = row;
    }
}

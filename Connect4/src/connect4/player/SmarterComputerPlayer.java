package connect4.player;

import connect4.Board;
import connect4.move.Move;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/*
 * Class StupidComputerPlayer
 */

public class SmarterComputerPlayer extends ComputerPlayer {
	// keep track of opponents
	ArrayList<Player> opponents = new ArrayList<Player>();
	
	public SmarterComputerPlayer(String name, Color color) {
		super(name, color);
	}

	private Random randGen = new Random();

	/*
	 * Search the board for players
	 * Add them to the opponent list
	 */
	public void addOpponent(Board board){
		for (int col=0; col < board.getCols(); col++){
			for (int row=0; row < board.getRows(); row++){
				/*
				 * find non-null areas of the board
				 */
				Player p = board.getCell(row, col);
				if (p != null){
					/*
					 * I am not my own opponent
					 */
					if ( p !=  this ){
						/*
						 * Only add an opponent if we haven't seen them before.
						 */
					    if ( ! opponents.contains(p) ){
						    opponents.add(p);
					    }
					}
				}
			}
		}
	}
	public Move getMove(Board board) {
		
		// Based on who is on the board,  add to list of opponent
		addOpponent(board);
		
		// smart computer blocks a winning move
		/*
		 * Iterate over over opponents, 
		 * check for any winning moves
		 * if so, return that move.
		 */
		for(Player p: opponents){
			Integer column = blockWinningMove( board, p);
			if ( column != null ){
				return ( new Move(column, this));
			}
		}		
		// the stupid computer just chooses randomly.
		return (new Move(randGen.nextInt(board.getCols()), this));
	}
	/*
	 * Your player should always block if the other player has three in a row.
	 * Your player shouldn't be fooled when the other player has two pieces in a row with
	 * two open spaces on either end.
	 * 
	 * Takes a board which we will analyze
	 * Takes the Player which is the opponent
	 * 
	 * Returns the column to add a piece in order to block
	 * 
	 */
	public Integer blockWinningMove(Board board, Player opponent ){
	      /*
	       *   Using a fake board, try every column, as the opponent
	       *   If any result in a winner, return that move.
	       */
	       for (int column=0 ; column <  board.getCols(); column++){
	           Board fakeBoard = new Board( board);
	           Move move = new Move( column, opponent );
	           // is the move legal
	           if ( fakeBoard.possibleMove(move)){
	        	   // add piece
	        	   fakeBoard.addPiece(move);
	        	   // check if a winner
	        	   Player p = fakeBoard.winner(move);
	        	   if (p !=null){
	        		   // Found a winning move.
	        		   // We must block it!
	        	       return column;
	        	   }
	           }
	       }
	       return  null; // Return null if no winning move found.	
	}
	
	/*
	 * Your player should have a preference for the center position when all else is equal.
	 */

	/* 
	 * Your player should do one other “smart” thing; you’ll explain what you did in your write-up.
	 */

	/*
	 * Possible to use look ahead with practice boards
	 */
	
	/*
	 * Smart player has bombs
	 */

}

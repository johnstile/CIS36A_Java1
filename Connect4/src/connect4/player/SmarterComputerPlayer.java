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
	/*
	 * A smart player keeps track of their opponents
	 */
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
							System.out.println("Add opponnent: " + p.getName() );
					    	opponents.add(p);
					    }
					}
				}
			}
		}
	}
	public Move getMove(Board board) {
		Integer col; // to column the column for the move;
		
		// Based on who is on the board,  add to list of opponent
		addOpponent(board);
		
		// Top priority: smart computer detects a winning move
		col = detectWinningMove( board, this);
		if ( col != null ){
			return ( new Move(col, this));
		}
		// Second priority: smart computer blocks a winning move
		/*
		 * Iterate over over opponents, 
		 * check for any winning moves
		 * if so, return that move.
		 */
		for(Player p: opponents){
			System.out.println("Looking for win for opponent "+ p.getName() );
			col = detectWinningMove( board, p);
			if ( col != null ){
				return ( new Move(col, this));
			}
		}
        
		
		// the stupid computer just chooses randomly.
		// the smart computer favors the center position 
		// when all else is equal.
		/*
		 * Need a random number weighted for the center
		 * I personally don't like this strategy
		 */
		Move m = null;
		while ( m == null ){
		    col = getWeightedRandomColumn( board );
		    if (board.possibleMove(new Move(col,this) ) ){
		    	 m=new Move(col,this);
		    }
		}
		return (new Move(col, this));
	}
	/*
	 * I am calling the middle a zero of offset zero, and edge offset of width/2
	 * Worst case, I need to pick the edge distance
	 * Best case, I pick the middle.
	 * So I need to weight my choice toward a smaller offest
	 * One method:
	 *    picking a random reduction in edge, from 0 to edge (call it sub_edge) 
	 *      Reduces range favoring zero
	 *    picking a random offset from 0 to sub_edge
	 *      This is just shifted
	 *  
	 */
	private Integer getWeightedRandomColumn(Board board) {

		double half = board.getCols()/2;   // find the center
		double percentage =  randGen.nextInt( 100 ) / 100.0;   // used to get 0% or 100% of the half
		double smaller_range =   ( half * percentage > 1 )?  half * percentage : 1;   // makes a smaller limit
		int offset =  randGen.nextInt( (int) smaller_range );   // pick random from smaller distance from middle
		int right_or_left = randGen.nextInt(2);    // there are two ways to go
		int sign = (right_or_left > 0)? 1:-1;   // step in a direction
		Integer col = (int) half + (sign*offset);  // put it all together		
		return col;
	
	}
	
	
	/*
	 * Your player should always block if the other player has three in a row.
	 * 
	 * Your player shouldn't be fooled when the other player has two pieces in a row with
	 * two open spaces on either end.
	 * 
	 * Strategy to code:
	 *     Board::winner already exists and it is complex
	 *     Make a fake board, and try the 7 possible moves.
	 *     If one results in a winner, return that column as our next move.
	 * 
	 * - Takes a board which we will analyze
	 * - Takes the Player which is the opponent
	 * - Return the column to block a win
	 * - OR return null
	 */
	public Integer detectWinningMove(Board board, Player opponent ){
	      /*
	       *   Using a fake board, try every column, as the opponent
	       *   If any result in a winner, return that move.
	       */
	       for (int col=0 ; col <  board.getCols(); col++){
	    	   /*
	    	    * Fake board must be a perfect copy of real board
	    	    */
	    	   Board fakeBoard = new Board( board);
	           /*
	            * Move consists of a column and Player
	            */
	    	   Move move = new Move( col, opponent );
	    	   /*
	    	    * Add piece to fake board
	    	    */
	    	   fakeBoard.addPiece(move);
	    	   /*
	    	    * Look for a winner.
	    	    */
	    	   Player p = fakeBoard.winner(move);
	    	   /*
	    	    * If so, take it.
	    	    */
	    	   if (  p != null ){
	    		   System.out.println("-->Take this move");
	    		   return new Integer(col);
	    	   }
	       }
	       return  null; // Return null if no winning move found.	
	}


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

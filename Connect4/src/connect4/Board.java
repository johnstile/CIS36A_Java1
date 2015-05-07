package connect4;

import connect4.move.Move;
import connect4.player.Player;

public class Board {

	private int rows;
	private int cols;
	
	private static final int MATCHES_TO_WIN = 4;
	  
	// Used in determine the winner
	int matches = 0;
	int search_direction = -1; // default to search left
	int search_steps = 0;  // at most  4 - 1 spaces
	 
	/** The grid of spaces of type Player */
	Player[][] grid;

	/*
	 * Constructor
	 */
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		grid = new Player[rows][cols];
		// set each cell of the board to null (empty).
		reset();

	}

	public void reset() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				grid[r][c] = null;
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	/**
	 * Returns the Player whose piece occupies the given location,
	 * 
	 * @param row
	 *            int
	 * @param col
	 *            int
	 */
	public Player getCell(int row, int col) throws IndexOutOfBoundsException {
		if ((row < 0) || (col < 0) || (row >= rows) || (col >= cols)) {
			throw new IndexOutOfBoundsException();
		} else {
			return grid[row][col];
		}
	}

	// Returns true if move is possible given board state.
	public boolean possibleMove(Move move) {
		// TODO: this is a test stub, you need to rewrite this.
		
		//System.out.println("possibleMove");
		//   Move has a  Player and a column
		
		// How do we determine if the move is valid?
		// 1. at least one row is null

		// Store the column clicked
		int c = move.getColumn(); 
		//System.out.println("Column:" + c );
		
		// Store the player at the last row in column
		Player p2 = getCell( this.rows - 1, c );
		
		// If the last row in the column s free, move is possible
		return ( p2 == null ) ? true : false;
	}

	// Adds a piece to the board for a given Move
	// Side effect: records the row position of move with move.setRow()
	public void addPiece(Move move) {
		// TODO: this is a test stub, you need to rewrite this.
		
		// Move has a Player and column
		// As long as one row is free, we are guaranteed success
		if ( possibleMove(move) == true ){
			Player p = move.getPlayer();
			int  c = move.getColumn();
			// This will hold the row we add to.
			int i = 0; 
			// Find first available row
		    for ( ; i < this.rows - 1;  i ++ ){
		    	if  ( getCell( i, c ) == null ){
		    		break;
		    	}
		    }
		    System.out.println("Add to column:" + c + ", row:" +  i + " for Player:" + p );
		    grid[i][c] = p;
		    // Store position of last move
		    move.setRow(i);
		}
	}

	/*
	 *  if the board contains a winning position, returns the Player that wins.
	 *  Otherwise, returns null. You could ignore lastMove.
	 */
	public Player winner(Move lastMove) {
		// TODO: write this. Currently, there is never a winner.
		
		/* Plan:
		 * A winner exists if there are:
		 *   1. MATCHES_TO_WIN in a row,  ( -- )
		 *   2. MATCHES_TO_WIN in a column,   ( | )
		 *   3. MATCHES_TO_WIN in a diagonalForward  ( / )
		 *   4. MATCHES_TO_WIN in a diagonalBackward ( \ )
		 *   if any work, return the winning Player
		 */
		 Player p =  lastMove.getPlayer();
		 int c =  lastMove.getColumn();
		 int r =  lastMove.getRow();
	
		//System.out.println("Check for Winner");
        
		if ( isHorizontalWin(r,c,p)  )	{
        	System.out.println("Yay! Horizontal Winner");
        	return lastMove.getPlayer();
        } 
        if ( isVerticalWin(r,c,p)  )	{
        	System.out.println("Yay! Vertical Winner");
        	return lastMove.getPlayer();
        }  
        if ( isDiagonalForwardUpWin(r,c,p)  )	{
        	System.out.println("Yay! Diagonal Forward Winner");
        	return lastMove.getPlayer();
        }  
        if ( isDiagonalBackwardUpWin(r,c,p)  )	{
        	System.out.println("Yay! Diagonal Backward Winner");
        	return lastMove.getPlayer();
        } 
        return null;
	}
	/*
	 * Using recursion, all these tests look very close
	 * Tally contiguous homogeneous Player in a given direction
	 * Sum the 2 directions and compare with MATCHES_TO_WIN
	 */
	private boolean isHorizontalWin(int r, int c, Player p) {
		int numForward = consecutiveCellsForPlayer(r, c, p, 0, +1);
		int numBack = consecutiveCellsForPlayer(r, c, p, 0, -1);
		return numForward + numBack > MATCHES_TO_WIN;
	}

	private boolean isVerticalWin(int r, int c, Player p) {
		int numUp = consecutiveCellsForPlayer(r, c, p, +1, 0);
		int numDown = consecutiveCellsForPlayer(r, c, p, -1, 0);
		return numUp + numDown > MATCHES_TO_WIN;
	}

	private boolean isDiagonalForwardUpWin(int r, int c, Player p) {
		int numForwardUp = consecutiveCellsForPlayer(r, c, p, +1, +1);
		int numBackDown = consecutiveCellsForPlayer(r, c, p, -1, -1);
		return numForwardUp + numBackDown > MATCHES_TO_WIN;
	}

	private boolean isDiagonalBackwardUpWin(int r, int c, Player p) {
		int numForwardDown = consecutiveCellsForPlayer(r, c, p, -1, +1);
		int numBackUp = consecutiveCellsForPlayer(r, c, p, +1, -1);
		return numForwardDown + numBackUp > MATCHES_TO_WIN;
	}
	/*
	 * This is the bane of my existence: recursion
	 *     Return 0 or 1 + call self again
	 *     Exit condition: color does not match
	 *     Recurse condition: colors match
	 *  Direction of search determined by rowStep and columnStep
	 */
	private int consecutiveCellsForPlayer( int r, int c, Player p, int rowStep, int columnStep) {
	    /*
	     * If within the board, get Player new position 
	     */
		Player p2 = inBounds(r, c) ? getCell(r, c) : null;
		/*
		 * If color matches (method handles null Player)
		 */
		if (  sameColor(p,p2)  ) {
			/*
			 * Move to next board position
			 */
			int next_r = r + rowStep;
			int next_c = c + columnStep;
			/*
			 *   At this point they get 1 point
			 *   And output of subsequent calls to self
			 */
			return 1 + consecutiveCellsForPlayer( next_r, next_c, p, rowStep, columnStep);
		}
		/*
		 *  Stop recursion when no more matches
		 */
		return 0;
	}	 
	 /*
	  *  Find edges of the board.
	  */
	 public boolean inBounds(int r, int c){
		    if ( c < 0 || c >= cols ){
		        return false;
		    }
		    if ( r < 0 || r >= rows){
		        return false;
		    }
		    return true;
		}
    /*
     * Compare colors. player could be null 
     */
    public boolean sameColor( Player p1, Player p2 ){
	   if ( p1 == null  || p2 == null ){
		   return false;
	   }
	   if ( p1.getColor() != p2.getColor() ){
		   return false;
	   }
	   return true;
    }
} // end Board class

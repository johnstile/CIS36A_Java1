package connect4;

import java.awt.Color;

import connect4.move.Move;
import connect4.player.Player;

public class Board {

	private int rows;
	private int cols;
	private int callHorizwin = 0;

	// Used in determing the winner
	int matches = 0;
	int search_direction = -1;
	 
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
		
		System.out.println("possibleMove");
		//   Move has a  Player and a column
		
		// How do we determine if the move is valid?
		// 1. at least one row is null

		// Store the column clicked
		int c = move.getColumn(); 
		System.out.println("Column:" + c );
		
		// Store the player at the last row in column
		Player p2 = getCell( this.rows - 1, c );
		
		// If the last row in the column s free, move is possible
		return ( p2 == null ) ? true : false;
	}

	// Adds a piece to the board for a given Move
	public void addPiece(Move move) {
		// TODO: this is a test stub, you need to rewrite this.
		
		// Move has a Player and column
		// As long as one row is free, we are guaranteed
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

	// if the board contains a winning position, returns the Player that wins.
	// Otherwise, returns null. You could ignore lastMove.
	public Player winner(Move lastMove) {
		// TODO: write this. Currently, there is never a winner.
		
		// Plan:
		// A winner exists if there are 4 in a row, 4 in a column, 4 in a diagonal.
		// 
		// 1. get position of lastMove (column and row) 
		//        Added to Move setRow() and Move.getRow()
		//
		// 2. use board.getCell( column, row ) to search for contiguous Player
		//
		// 3. count contiguous horizontal, vertical, leftdiag, rightdiag
		//
		 Player p =  lastMove.getPlayer();
		 int c =  lastMove.getColumn();
		 int r =  lastMove.getRow();
	
		System.out.println("Check for Horizontal Winner");
        
		if ( isHorizontalWin(r,c,p)  )	{
        	System.out.println("Yay! Horizontal Winner");
        	return lastMove.getPlayer();
        }
        
        return null;
	}
	
	 /* False conditions:
	  *   inBounds
	  *   not null
	  *   
	  * sameColor && counter < 4
	  * samecolor  && counter >=4
	  * 
	  * Search one direction
	  * Then search other direction
	  */
	 public boolean isHorizontalWin(int r, int c,Player p){
		 callHorizwin++;
		 System.out.println("call isHorizontalWin:" + callHorizwin);
		 
		 int  c_neighbor = c + search_direction;
		 
		 // Make sure position exists on the board
		 if ( inBounds(r, c_neighbor) ){
             Player p2 = getCell(r, c_neighbor);
             // Check if colors match, also handles null 
             if ( sameColor(p, p2) ){
            	 matches++;
            	 if ( matches >= 2 ){
            		 return true;
            	 }
            	 // Compare next position
            	 return isHorizontalWin( r , c_neighbor, p);
             }
		 } else {
			 // switch directions if board position does not exist.  
			 search_direction = 1;
		 }
		 return false;
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

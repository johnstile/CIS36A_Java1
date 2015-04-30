package connect4;

import connect4.move.Move;
import connect4.player.Player;

public class Board {

	private int rows;
	private int cols;
	
	private int added_piece_col; // location of last piece added
	private int added_piece_row; // location of last piece added

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
		    grid[i][c] = move.getPlayer();
		    // Need to store position of last move
		    added_piece_col=c;
		    added_piece_row=i;
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
		//        Added: added_piece_col and added_piece_row
		//
		// 2. use board.getCell( column, row ) to search for contiguous Player
		//
		// 3. count contiguous horizontal, vertical, leftdiag, rightdiag
		//
		Player p = lastMove.getPlayer();
		int contiguous_col = 0;
		int contiguous_row = 0;
		int leftdiag = 0;
		int rightdiag = 0;

//THIS DOESN"T WORK		
//		System.out.println("Check for Horizontal Winner");
//		if ( sameNeighborHorizontal(added_piece_col, added_piece_row) == 4 ){
//			return grid[added_piece_col][added_piece_row];
//		}
		
		return null;
	}
	
	public int sameNeighborHorizontal(int col, int row){
		int count = 0; // How many contiguous matches
		int steps = 0; // How many steps searched
		
		Player p = grid[col][row];
		
		while ( count <= 4 ){
		
	
			// Begin: Search left, don't go off the board
			if ( steps <= 0  && steps >= -3 &&  (col + steps ) > 0 ){
				// search to the left
				steps--;
				System.out.println("Search steps:" + steps + ", from col:" + col + " row:" +row );
			    Player p_neighbor = grid[ col + steps ][ row  ];
			    System.out.println("color: " + p.getColor());
			    if ( p.getColor() == p_neighbor.getColor() ){
			        count++; 
			        p = p_neighbor;
			    } else {
			    	// Start search to the right
			    	steps = 1;
			    	// Reset to starting position
			    	p = grid[col][row];
			    }
			} // End: Search left
			
			// Begin: Search right
			if (steps >= 1 && steps <= 3 &&  (col + steps ) < cols   ){
				// search to the right
				steps ++;
			    Player p_neighbor = grid[ col  + steps ][ row ];
			    if ( p.getColor() == p_neighbor.getColor() ){
			        count++; 
			        p = p_neighbor;
			    } else {
			    	// End searching
			    	steps = 4;
			    	// Reset to starting position
			    	p = grid[col][row];			    	
			    }
			} // End: Search right			
		}
		return count;
	}
	

} // end Board class

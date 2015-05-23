package connect4;


import connect4.move.BombMove;
import connect4.move.Move;
import connect4.move.QuitMove;
import connect4.player.Player;
import connect4.player.ComputerPlayer;
import connect4.player.SmarterComputerPlayer;
import connect4.player.StupidComputerPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.ArrayList;

public class Connect4 extends JPanel implements MouseListener{

    // These control the size of the board.  The traditional Connect 4 board is 
    // seven spaces wide by six spaces high
    private static final int ROWS = 6;
	private static final int COLS = 7;
    private static final int pieceSize = 50;     //size of the pieces in pixels
    private static final int spacing = 10;       //spacing between adjacent pieces in pixels;
    private static final int headerHeight = 70;  // height of header for messages and column numbers
    private String message = "";
    
    private JButton myButton;
    private JPanel myPanel;
    private JButton myButtonQuit;
    private JFrame myFrame;
    private Board myBoard;
    
    private boolean noWinner = true; // instance variable marking a winner has been found

    // this contains the ordered list of players in the game
    private ArrayList<Player> players;
    private int currentPlayerIndex = 0;
    

     /** creates the connect four interface with the specified number of rows and colonms
       * @param rows int
       * @param cols int
       */   
    public Connect4(int rows, int cols ) {
        

        /*
         *   myFrame
         *       myPanel
         *         myButton
         */
        myFrame = new JFrame(); 
        myButton = new JButton("Quit");
        
        this.myBoard = new Board(rows, cols);
        
        addMouseListener(this);
        
        // the hard numbers at the end are for the menu bar at the top and side handles
        // The extra 40 is for the close button
        // Adding 20 to vertical to make room for quit button
        myFrame.setSize( myBoard.getCols() * (pieceSize + spacing) + spacing + 10 + 40,
                         myBoard.getRows() * (pieceSize + spacing) + spacing + headerHeight + 35 + 20);
        myFrame.add(this);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myFrame.setResizable( false );
        myFrame.setTitle( "Connect Four" );
        myFrame.setVisible(true);

        myButton.setLocation(0, 10);
        myButton.setPreferredSize(new Dimension(100, 20));
        /*
         * Handle the Quit button with an ActionListener
         * this uses an in-line anonymous method
         * that calls takeTurn with a QuitMove and current player and message
         */
        myButton.addActionListener ( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Player p = getCurrentPlayer();
				p.getName();
				takeTurn( new QuitMove(p, p.getName() + " quit the game!!!") );
			}
        	
        });
        
        this.add(myButton);
        
        // start a new game 
        newGame();
    }

    
    
    //////  Gameplay
    //////
    // Note, the main loop in the gameplay (players alternating turns) happens between 
    //  the play() and takeTurn() methods.  These call each other, which is a type of
    //  recursion (called mutual recursion).  
    // Call newGame() to restart the game, or start it for the first time.
//    
//    private ActionListener makeActionListener() {
//       ActionListener tmp = new ActionListener() {
//    	   
//       }
//    	
//    	return null;
//	}



	public void newGame() {
        myBoard.reset();
        players = new ArrayList<Player>();
        Player p1 = new Player("Jane", Color.black);
        //StupidComputerPlayer p2 = new StupidComputerPlayer("Robot Joe", Color.red);
        SmarterComputerPlayer p2 = new SmarterComputerPlayer("Robot Joe", Color.red);
        players.add(p1);
        players.add(p2);
        
        message = "Let's play!  " + getCurrentPlayer().getName() + " goes first.  ";
        repaint();
        play();
    }
    
	private boolean moreMovesPossible(){
		/*
		 *  Computer should quit the game if there are no more moves
		 *  Search each column for possible move. 
		 *  
		 */
		for (int i = 0; i < COLS ; i++){
		    if ( myBoard.possibleMove(new Move(i, getCurrentPlayer()))){
		    	return true;
		    }
		}
		return false;
	}
    // start the recursion to play the game.  
    private void play() {

    	if ( (getCurrentPlayer() instanceof ComputerPlayer ) ) {
    		/*
    		 *  Computer should quit the game if there are no more moves
    		 *  Search each column for possible move. 
    		 *  Returns true if any column has a possible move 
    		 */
    		System.out.println("Computer Player");
    		if (! moreMovesPossible()){
    			takeTurn( new QuitMove(getCurrentPlayer(), getCurrentPlayer().getName() +  " quit the game.  No moves possible") );
    			this.noWinner = false;
    		}
    		
            // the player is a ComputerPlayer, so can calculate its own move
            // only ComputerPlayers have a getMove method, so we have to cast getCurrentPlayer into one.
            ComputerPlayer computer = (ComputerPlayer) getCurrentPlayer();
            takeTurn(computer.getMove(myBoard));
        }

    }

    private void takeTurn(BombMove move){
 
        myBoard.addPiece(move);
        message = getCurrentPlayer().getName() + " goes in column " + move.getColumn() + ".  ";
        
    	// position of move
    	int column_move = move.getColumn();
    	int row_move =  move.getRow();
        System.out.println("Droped bomb at col:" + column_move + ", row:" + row_move );
        
        // Iterate over all neighbors
        for ( int column_position = (column_move - 1);  column_position <= column_move + 1; column_position++){
        	for ( int row_position = (row_move -1); row_position <= row_move +1 ; row_position++ ){
                // If they are valid board positions, nullify
        		if ( myBoard.inBounds(row_position, column_position) ){
	        	    	myBoard.grid[row_position][column_position] = null;	        	   
        		} 
        	}
        }
    	/*
    	 * Sort columns.
    	 * Shift pieces down, 
    	 *  move nulls to the top
    	 */
        for ( int col = (column_move - 1);  col <= column_move + 1; col++){
            // start from bottom, find first null, swap it with first non-null in same column
            int lowestNull = -1;
            for (int row = 0; row < myBoard.getRows(); ++row) {
              // are we looking for nulls or swapping?
              if (lowestNull == -1) {
                if (myBoard.getCell(row, col) == null) {
                  lowestNull = row;   // found the lowest null; now we can start swapping
                }
                continue; // we can't start swapping until we find lowest null
              }
              // if the current cell is non-empty swap with lowestNull and move lowestNull null up
              Player swapPlayer = myBoard.getCell(row, col);
              if (swapPlayer != null) {
                // swap this move with the lowest null and move it up
                myBoard.grid[lowestNull][col] = swapPlayer;
                myBoard.grid[row][col] = null;
                ++lowestNull;
              }
            }
        }
        System.out.println("bbbbbbbbbb");
    	/*
    	 * Swap players
    	 */
        advanceToNextPlayer();
        message += "It is now " + getCurrentPlayer().getName() + "'s turn.  ";
        repaint();
        play();
    }

    private void takeTurn(QuitMove move ) {
    	Player p = myBoard.getWinner();
    	if ( p != null ){
    		message += "You can't quit.  " + p + " already one!";
    		repaint();
    		return;
    	}
    	// quit();
    	this.noWinner = false;
    	this.message = move.getMessage();
    	repaint();
    }
    private void takeTurn(Move move) {
        if ( ! noWinner ){
        	return;
        }
    	
        myBoard.addPiece(move);
        message = getCurrentPlayer().getName() + " goes in column " + move.getColumn() + ".  ";
       
        /*
         * Base Case to end recursion
         */
        if ( myBoard.winner(move) != null  ) {
        	
        	System.out.println("+++++++++++++++++++++++++");
        	noWinner = false;
            message += getCurrentPlayer().getName() + " wins!  " + getCurrentPlayer().getName() + " wins!  ";
            repaint();
        	// Stop the game.  Implement "quit". 

        } else {
        	System.out.println("-----------------------------------------");
        	/*
        	 * Swap players
        	 */
            advanceToNextPlayer();
            message += "It is now " + getCurrentPlayer().getName() + "'s turn.  ";
            repaint();
            play();
        }
    }
    
    
    private void quit() {
		// TODO Auto-generated method stub
    	System.exit(0);
		
	}

	// returns the current player
    private Player getCurrentPlayer () {
        return players.get(currentPlayerIndex);
    }
    
    // advance the next player in line
    private void advanceToNextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) {
            currentPlayerIndex = 0;
        }
    }

    
    //////Listener
    //////
    public void mouseClicked(MouseEvent e) {

        // only process the click if the current player isn't a computer player
        if ( ! (getCurrentPlayer() instanceof ComputerPlayer)) {

        	// find out which column was clicked on...
            int c = myBoard.getCols();
            while ( (e.getX() < horizontalPos(c)) && (c > 0) ) {
                c--;
            }
            /*
             * Right click drops the bomb
             */
        	if ( SwingUtilities.isRightMouseButton(e) ){
        		/*
        		 * Check if we have a bomb
        		 */
        		if ( getCurrentPlayer().hasBomb() ){
        		    System.out.println("Droped a bomb");
        		    try {
						getCurrentPlayer().useBomb();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		    try {
						takeTurn( new BombMove(c, getCurrentPlayer()) );
					} catch (Exception e1) {
						System.out.println(e1);
						new Move(c, getCurrentPlayer());
					}
        		} else {
        			System.out.println("No Bomb For You! Loose a turn!");
        		}
        	} else {
        		// Normal move
                // and restart the gameplay recursion
                takeTurn( new Move(c, getCurrentPlayer()) );
        	}
            
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
    
    
    ///// GRAPHICS
    /////  override paintComponent so that the button will redraw (children of jpannel)
    public void paintComponent( Graphics g ) {
        g.setColor( Color.BLUE );
        g.fillRect( 0, 0, myFrame.getWidth(), myFrame.getHeight() );
        Player cell;

        
        // draw column header (numbers and message)
        g.setColor(Color.white);
        g.drawString(message, pieceSize, headerHeight - 25 );
        
        for (int c = 0; c < myBoard.getCols(); c++) {
            g.drawString(Integer.toString(c), horizontalPos(c) + pieceSize/2 - 4, headerHeight);
        }
        // draw pieces
        for(int r = 0; r < myBoard.getRows(); r++ ) {
            for(int c = 0; c < myBoard.getCols(); c++ ) {
                cell = myBoard.getCell(r, c);
                if (cell != null) {
                    drawPiece( g, r, c, cell.getColor() );
                } else {
                    drawPiece( g, r, c, Color.gray );
                }
            }
        }
    }
    

    
    //shows a piece at location row r and col c for given color
    private void drawPiece(Graphics g, int r, int c, Color color ) {
        g.setColor( color );
        g.fillOval( horizontalPos(c), verticalPos(r), pieceSize, pieceSize );

        g.setColor( Color.white );
        g.drawOval( horizontalPos(c) - 1, verticalPos(r) - 1, pieceSize + 1, pieceSize + 1 );

        //g.setColor( new Color( 128, 128, 0 ) );
        //g.drawOval( horizontalPos(c), verticalPos(r), pieceSize, pieceSize );
    }  
    
    // returns the horizontal pixel position of a given 0-based column index   
    private int horizontalPos(int c) {
        return (spacing +  c * (pieceSize + spacing));
    }
    
    // returns the vertical pixel position of a given 0-based row index   
    private int verticalPos(int r) {
        return (spacing + headerHeight + (myBoard.getRows() - r - 1) * (pieceSize + spacing)); 
    }
        
    

    // This method causes your program to pause for a certain number of milliseconds
    private void delay(int ms) {
        try {
            Thread.sleep (ms);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    ////// Main
    //////
    public static void main( String[] args ){
        Connect4 connect4 = new Connect4(ROWS, COLS);
    }

}

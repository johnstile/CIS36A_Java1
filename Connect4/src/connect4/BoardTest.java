package connect4;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;

// Teacher likes
import static org.junit.Assert.*;

// Import our stuff to test
import connect4.player.Player;
import connect4.move.Move;

public class BoardTest {
    @BeforeClass
    public static void setUpClass(){
    }
    @AfterClass
    public static void tearDownClass(){
    }
    @Before
    public void setUp(){
    }
    @After
    public void tearDown(){
    }
	/*
	 * Disable the default, which just fails
	 */
//	@Test
//	public void test() {
//		fail("Default test");
//	}
	
    /*
     * Make boards for testing
     */
    public static String[] EMPTY =    
    	{
      "_______",
      "_______",
      "_______"
    	};
    public static String[] B_1 =    
    	{
      "       ",
      "       ",
      " b     "
    	};    
    public static String[] B_1r0 =    
    	{ 
      "       ",
      "       ",
      "rb    "
    	};
    public static String[] FULL =
    	{
    	"rrrrrrr",
    	"rrrrrrr",
    	"rrrrrrr"
    	};
    public static String[] B_0 =
    	{
    	"       ",
    	"       ",
    	"r      "
    	};
    /*
     * Need a method to quickly create boards
     * -- Because grid was private, must change to package private
     *    to allows this to work
     */
    public Board makeBoard(String[] grid){
    	Board b = new Board( grid.length, grid[0].length() );
    	for ( int r = 0; r < grid.length; r++){
    		/*
    		 *  Packs this upside down, so the picture loks good
    		 */
    		String row = grid[ grid.length - 1 - r  ];
    		for ( int c = 0; c < row.length(); c++){
    			String p = row.substring(c, c+1);
    		    b.grid[r][c] = mockPlayer(p);
    		}
    	}
    	return b;
    }
    /* 
     * For testing, need a bunch of players
     */
    public static Player RED = new Player( "red", Color.RED);
    public static Player BLACK = new Player( "black", Color.BLACK);
    public static Player WHITE = new Player( "white", Color.WHITE);
    public Player mockPlayer( String ltr){
    	if (ltr.equals("r")){
    		return RED;
    	} else if ( ltr.equals("b")){
    		return BLACK;
    	}else if ( ltr.equals("w")){
    		return WHITE;
    	} else if ( ltr.equals(" ")){
    		return null;
    	}
    	return WHITE;
    }
    /* 
     * The testing begins
     * 
     */
    @Test
    public void addPieceTest(){
    	Board b1 = makeBoard(B_1);
    	b1.addPiece(new Move(0,RED));
    	Board b1r0 = makeBoard(B_1r0);
    	// Fail the test if these are not equal.
    	assertArrayEquals( "add piece failed", b1.grid, b1r0.grid); 
    }
    @Test
    public void possibleMoveTest(){
    	Board b0 = makeBoard(B_0);
    	assertTrue( "Can add to partial empty column",  b0.possibleMove( new Move(0,RED) ) ); 
    	Board b2 = makeBoard(FULL);
    	assertFalse( "Can't move on full column",    b2.possibleMove( new Move(0,RED) )   );
    }
     
}

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
      "_______",
      "_______"
    	};
    public static String[] B_1 =    
    	{
      "_______",
      "_______",
      "_______",
      "_b_____"
    	};    
    public static String[] B_1r0 =    
    	{ 
      "_______",
      "_______",
      "_______",
      "rb_____"
    	};
    public static String[] FULL =
    	{
    	"rrrrrrr",
    	"rrrrrrr",
    	"rrrrrrr",
    	"rrrrrrr"
    	};
    public static String[] B_0 =
    	{
    	"_______",
    	"_______",
    	"_______",
    	"r______"
    	};
    ///// Need several winners ////
    // red winner horizontal
    public static String[] B_Wh =
    	{
    	"_______",
    	"_______",
    	"_______",
    	"rrrrrrr"
    	};
    // red winner vertical
    public static String[] B_Wv =
    {
	"r______",
	"r______",
	"r______",
	"r______"
	};
    // red winner diagonal forward
    public static String[] B_Wdf =
    {
	"___r___",
	"__rb___",
	"_rbb___",
	"rbbb___"
	};
    // red winner diagonal backward
    public static String[] B_Wdb =
    {
	"_r_____",
	"_br____",
	"_bbr___",
	"_bbbr__"
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
    		 *  Packs this upside down, so the picture looks good
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
    	} else if ( ltr.equals("_")){
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
    @Test
    public void winner(){
    	
    }
    @Test
    public void isHorizontalWin(){
    	//TODO
    }
    @Test
    public void isVerticalWin(){
    	//TODO
    }
    @Test
    public void isDiagonalForwardUpWinTest(){
    	//TODO
    }
    @Test
    public void isDiagonalBackwardUpWinTest(){
    	//TODO
    }
    @Test
    public void consecutiveCellsForPlayerTest(){
    	//TODO
    }
    @Test
    public void inBoundsTest(){
    	Board b = makeBoard(B_0);
    	assertTrue("Valid board row and column", b.inBounds(0,0));
    	assertFalse("Invalid board column right edge", b.inBounds( 0,b.getCols() ));
    	assertFalse("Invalid board column left edge", b.inBounds( 0,-1 ));
    	assertFalse("Invalid board row top edge", b.inBounds( b.getRows(), 0 ));
       	assertFalse("Invalid board row bottom edge", b.inBounds( -1,b.getRows() ));    	
    }
    @Test
    /*
     * TODO: Maybe this belongs to Player rather than board
     *             Move method to player
     *             Create PlayerTest.java for the method
     */
    public void sameColorTest(){
    	Board b = makeBoard(B_0);
    	Player p0 = new Player("oneFish", Color.black);
    	Player p1 = new Player("oneFish", Color.black);
    	Player p2 = new Player("twoFish", Color.blue);
    	Player p3 = new Player(); // Had to add null constructor to Player
    	p3 = null;
    	// Compare same
    	assertTrue("Colors are same", b.sameColor( p0,p1));
    	// Compare different
    	assertFalse("Colors are different", b.sameColor( p0,p2));
    	// Compare null
    	assertFalse("Compare to Null player", b.sameColor( p0,p3));
    }
}

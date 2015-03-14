package dotsAndLines;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// This program accepts clicks and draws them connected by lines.
// We'll talk about the "extends" keyword soon.
public class DotGame extends MouseListenerDrawer {

	private final int			DOT_RADIUS		= 5;
	private ArrayList< Point >	points;
	private int					totalLines		= 0;
	/*
	 * When the user clicks close to he first dot,
	 * mark the shape as 'closed'
	 * I am using a sentinel value for this
	 */
	public boolean				closed_state	= false;
	/*
	 * Lab2 Part A, section 3.
	 * Create 2 arrayLists of lines
	 */
	private ArrayList< Line >	lines_on;
	private ArrayList< Line >	lines_off;
	private String				gameState		= new String( "None" );
	private Point p_clicked;
	public DotGame() {
		points = new ArrayList<>();
		lines_on = new ArrayList<>();
		lines_off = new ArrayList<>();
	}

	// This gets called whenever the user presses their mouse button in the
	// window
	public void mousePressed( MouseEvent event ) {
		// where did the user click?
		p_clicked = new Point( event.getX(), event.getY() );

		/*
		 * Part 2A
		 * Test for Closure:
		 * Require more than one point to set closure
		 */
		if ( points.size() > 1 ) {
			/*
			 * if set_closed is not true yet,
			 * check if it should be changed
			 */
			if ( closed_state == false ) {
				/*
				 * Determine if this point is next to the first point
				 */
				closed_state = closeTo( points.get( 0 ), p_clicked );
				if ( closed_state == true ) {
					System.out.println( "Clicked to close. Mark closed!" );
				}
			}
		}
		/*
		 * Part 2A: Don't let the user add any more dots
		 */
		if ( closed_state == false ) {
			points.add( p_clicked );
		} else {
			/*
			 * THIS IS A KEY:
			 * If the point is near an existing point, 
			 * use the existing point,
			 * because it is hard to pick the exact same point
			 */
			for ( int i = 0; i < points.size(); i++ ){
				if ( closeTo( points.get( i ), p_clicked) ){
					 System.out.println( "==================Use this point");
					 p_clicked = points.get( i );
				}
			}
		}

		// always redraw the screen
		repaint();
	}

	// This gets called whenever Java needs to draw to the window.
	// Basic method: first erase the window, then redraw it. Simple!
	public void paintComponent( Graphics g ) {
		// erase the window
		erase( g );

		// Determine quantity of points in the array
		int totalPoints = points.size();

		// draw everything
		int lastIndex = totalPoints - 1;
		for ( int i = 0; i < totalPoints; i++ ) {
			Point p = points.get( i );
			drawPoint( g, p, Color.red );
			if ( i != lastIndex ) {
				drawLine( g, p, points.get( i + 1 ) );
			}
		}
		/*
		 * Part 3: 'close' the shape
		 */
		if ( closed_state == true ) {

			// Part B: Draw line between first and last
			// this 'closes' the shape.
			//drawLine( g, points.get( 0 ), points.get( totalPoints - 1 ) );

		}
		/*
		 * Part 3: if the state is closed,
		 * fill the lists of visible/hiden lines
		 * ArrayList lines_on
		 * If the line isn't in ArrayList lines_off
		 */
		if ( closed_state == true ) {
			System.out.println( "closed_state" );

			int totalLines = ( totalPoints * ( totalPoints - 1 ) ) / 2;
			System.out.println( "totalLines:" + totalLines );

			/*
			 * State Machine:
			 * FirstRound - load lines_on with all lines
			 * Winner - when lines_off contains all the lines
			 * StillPlaying - all other states
			 * Detect state change using 'beforeState'
			 */
			String beforeState = new String( gameState );
			if ( lines_off.size() == 0 && lines_on.size() == 0 ) {
				gameState = "FirstRound";
			}
			else if ( lines_off.size() == totalLines ) {
				gameState = "Winner";
			}
			else {
				gameState = "StillPlaying";
			}
			if ( gameState.contains( beforeState ) ) {
				System.out.println( ">>>Stage changed from:" + beforeState
						+ " to:" + gameState );
			}

			/*
			 * Need temporary ArrayList< Line >
			 * Holds all lines that have a point
			 */
			ArrayList< Line > lines_have_point = new ArrayList<>();
			/*
			 * And assign lines to the ArrayLists
			 */
			for ( int i = 0; i < totalPoints; i++ ) {
				for ( int j = i + 1; j < totalPoints; j++ ) {
					// Create a Line
					Line myLine = new Line( points.get( i ), points.get( j ) );

					if ( gameState.contains(  "FirstRound" ) ) {
						/*
						 * Once the shape is closed, add all lines to visible
						 */
						System.out.println( "Add line to lines_on:" + i );
						lines_on.add( myLine );
					}
					else if ( gameState.contains( "StillPlaying")  ) {
						/*
						 * After FirstRound, toggle lines based on last point
						 * clicked
						 */
                        System.out.println( "Point Clicked:" + p_clicked );
						System.out.println( "Line:" + myLine);
						if (myLine.hasPoint( p_clicked ) == true){
							System.out.println("********Line has my point");
							lines_have_point.add( myLine );
						}
						
//						// Print the lines in ArrayList:
//						System.out.println( "lines_on:" );
//						for ( Line l : lines_on ) {
//							System.out.println( l );
//						}
//						System.out.println( "lines_off:" );
//						for ( Line l : lines_off ) {
//							System.out.println( l );
//						}
						
						// REF:
						// http://docs.oracle.com/javase/7/docs/api/java/util/List.html#contains%28java.lang.Object%29
						// ListArray 'contains' method uses equals() method to
						// evaluate if two objects are the same.
						// Need to add an Line.equals() method for this to work
						// If Line in lines_on, remove it, add to other
//						if ( lines_on.contains( myLine ) ) {
//							System.out.println( "Line already visible" );
//						}
//						else if ( lines_off.contains( myLine ) ) {
//							System.out.println( "Line already invisible" );
//						}
//						else {
//							System.out.println( "Line Not in either list" );
//						}

					}
					else if ( gameState.contains( "Winner" ) ) {
						System.out.println( "Winner" );
					}
					else {
						System.out.println( "ERROR: Should Never Get Here!" );
					}
				}
			}
			/*
			 * Evaluate ArrayList lines_have_point
			 * remove lines from one list 
			 * add to the other
			 */
			System.out.println("lines_have_point:" + lines_have_point.size());
			ArrayList<Line> toogle_off = new ArrayList<>();
			ArrayList<Line> toogle_on =  new ArrayList<>();
			for ( Line l : lines_have_point ){
				System.out.println("Evaluate l:" + l);
				System.out.println("lines_on:" + lines_on);
				//---------------------------------------------
				// AR! this doe not work!
				if ( lines_on.contains( l )){
					System.out.println("toogle_off.add()");
					toogle_off.add( l );
				}
				if ( l.equals( lines_on.get( 0 ) )){
					System.out.println("====================>Yay");
				}
				//---------------------------------------------
				if ( lines_off.contains( l )){
					System.out.println("toogle_on.add()");
					toogle_on.add(l);
				}
			}
			/*
			 * Now move the Lines
			 */
			System.out.println("toogle_on:" + toogle_on.size());
			System.out.println("toogle_off:" + toogle_off.size());
			for ( Line l: toogle_off){
				System.out.println("tooogle_off");
				lines_on.remove( l );
				lines_off.add( l );
			}
			for ( Line l: toogle_on ){
				System.out.println("tooogle_on");
				lines_off.remove( l );
				lines_on.add( l );
			}
			//lines_off.toggleList(lines_have_point);
			//lines_on.toggleList(lines_have_point);
			
			// Check the state of our arrays
			System.out.println( "lines_off.size():" + lines_off.size() );
			System.out.println( "lines_on.size():" + lines_on.size() );
			/*
			 * 	Draw a line between all points
			 */
			for ( int i = 0; i < lines_on.size(); i++ ) {
				drawLine( g, lines_on.get( i ).getPoint1(), lines_on.get( i )
						.getPoint2() );
			}
		}
	}

	// /////// point methods

	// returns true if the two points are "close"
	private boolean closeTo( Point p1, Point p2 ) {
		return ( distanceBetween( p1, p2 ) < DOT_RADIUS );
	}

	// returns the distance between two points
	private double distanceBetween( Point p1, Point p2 ) {
		return Math.sqrt( Math.pow( p1.x - p2.x, 2 )
				+ Math.pow( p1.y - p2.y, 2 ) );
	}

	// /////// drawing methods

	// this one draws a black point
	private void drawPoint( Graphics g, Point p ) {
		drawPoint( g, p, Color.black );
	}

	// this one draws a point with a certain color
	private void drawPoint( Graphics g, Point p, Color c ) {
		g.setColor( c );
		g.fillOval( p.x - DOT_RADIUS,
					p.y - DOT_RADIUS,
					DOT_RADIUS * 2,
					DOT_RADIUS * 2 );
	}

	// draws a black line
	private void drawLine( Graphics g, Point p1, Point p2 ) {
		drawLine( g, p1, p2, Color.black );
	}

	// draws a line of a certain color
	private void drawLine( Graphics g, Point p1, Point p2, Color c ) {
		g.setColor( c );
		g.drawLine( p1.x, p1.y, p2.x, p2.y );
	}

	public static void main( String[] args ) {
		DotGame me = new DotGame();
	}

}

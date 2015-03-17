package dotsAndLines;

/*
 * Lab: Lab2 PartA, Problem 2
 * By: John Stile
 * Create a class ClosedPattern based on DotsAndLines.
 * The user clicks to create dots as usual,
 * but when the user clicks on the frist dot that was created,
 * the figure becomes "closed".
 * With a closed figure:
 * a. Don't let the user make any more dots.
 * b. Draw black lines adjacent dots, and
 * treat the first and alst dot as if they where adjacent.
 * This will "close" the figure.
 * c. Draw a diferent colored line between all the toher airs of dots.
 * The Java class Color has predefined colors that you can use.
 * It would be need to do something based on the distance of the dots
 * using darken() or lighten(), perhaps?
 * Do not make any additional ArrayLists.
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D; // Gives line thickness
import java.util.ArrayList;

// This program accepts clicks and draws them connected by lines.
// We'll talk about the "extends" keyword soon.
public class ClosedPattern extends MouseListenerDrawer {

	private final int			DOT_RADIUS		= 5;
	private ArrayList< Point >	points;
	/*
	 * When the user clicks close to he first dot,
	 * mark the shape as 'closed'
	 * I am using a sentinel value for this
	 */
	public boolean				closed_state	= false;
	public Color				line_color		= new Color( 50 );
	public Color				point_color		= new Color( 50 );

	public ClosedPattern() {
		points = new ArrayList<>();
	}

	// This gets called whenever the user presses their mouse button in the
	// window
	@Override
	public void mousePressed( MouseEvent event ) {

		System.out.println( "Enter: mousePressed()" );

		// where did the user click?
		Point p_clicked = new Point( event.getX(), event.getY() );

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
		}

		// always redraw the screen
		repaint();
	}

	// This gets called whenever Java needs to draw to the window.
	// Basic method: first erase the window, then redraw it. Simple!
	@Override
	public void paintComponent( Graphics g ) {

		System.out.println( "Enter: paintComponent()" );

		// erase the window
		erase( g );

		// Determine quantity of points in the array
		int totalPoints = points.size();

		// draw everything
		int lastIndex = totalPoints - 1;
		for ( int i = 0; i < totalPoints; i++ ) {
			Point p = points.get( i );
			drawPoint( g, p, point_color );
			if ( i != lastIndex ) {
				drawLine( g, p, points.get( i + 1 ) );
			}
		}
		/*
		 * Part 2C: 'close' the shape
		 */
		if ( closed_state == true ) {

			// Part B: Draw line between first and last
			// this 'closes' the shape.
			drawLine( g, points.get( 0 ), points.get( totalPoints - 1 ) );

		}
		/*
		 * Normal colors
		 */
		if ( closed_state == false ) {
			point_color = Color.red;
			line_color = Color.black;
		}
		else {
			/*
			 * Part 2C: Draw different color line between all other pairs of
			 * dots
			 * Using for loop in for loop.
			 * i is the output loop
			 * j is the inner loop
			 * By initializing j = i+1 we only perform half the matrix.
			 * k is a continuous counter
			 */
			int k = 0;
			int totalLines = ( totalPoints * totalPoints ) / 2;
			for ( int i = 0; i < totalPoints; i++ ) {

				drawPoint( g, points.get( i ), point_color );

				for ( int j = i + 1; j < totalPoints; j++ ) {

					/*
					 * This counter used to pick a new color
					 */
					k++;

					/*
					 * Adjacent points are black.
					 * Other points are a rainbow.
					 * First and last points are considered Adjacent
					 */
					if ( ( j == i + 1 ) || ( j == totalPoints - 1 ) ) {
						line_color = Color.black;
					}
					else {
						line_color = getRainbowColor( k );
					}
					/*
					 * Draw the line
					 */
					drawLine( g, points.get( i ), points.get( j ) );
				}
			}
		}
	}

	// /////// color methods

	// returns the perspective color in the rainbow
	private Color getRainbowColor( int k ) {
		/*
		 * REF: http://krazydad.com/tutorials/makecolors.php
		 * Observed a color chart,
		 * As one cycles though the rainbow,
		 * Red, green, and blue follow the same repeating pattern, 0 to max to 0
		 * however, each color is but out of phase by 1/3.
		 * By using sin() to oscillate from 1 to -1,
		 * shifting the phase such that each color is 1/3 off another
		 * and converting all values to positive,
		 * I can make a complete visual spectrum..
		 */

		// Generate a phase shift for each color.
		double red_phase = 0 * Math.PI / 3;
		double green_phase = 2 * Math.PI / 3;
		double blue_phase = 4 * Math.PI / 3;

		// Get the sign of k, shifted by the colors phase
		double red = Math.sin( red_phase + k );
		double green = Math.sin( green_phase + k );
		double blue = Math.sin( blue_phase + k );

		// Can only use positive numbers
		red = Math.abs( red );
		green = Math.abs( green );
		blue = Math.abs( blue );

		System.out.println( "k:" + k + ", red:" + red + ", green:" + green
				+ ", blue:" + blue );
		/*
		 * Color(float r, float g, float b, float a)
		 * Creates an sRGB color with the specified
		 * red, green, blue, and alpha
		 * values in the range (0.0 - 1.0).
		 */
		return new Color( ( float ) red, ( float ) green, ( float ) blue );
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
		drawPoint( g, p, line_color );
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
		drawLine( g, p1, p2, line_color );
	}

	// draws a line of a certain color
	private void drawLine( Graphics g, Point p1, Point p2, Color c ) {

		// g.setColor( c );
		// g.drawLine( p1.x, p1.y, p2.x, p2.y );
		/*
		 * Graphic class does not have a line width (thickness)
		 * Casting to Graphics2D gives this feature
		 */
		Graphics2D g2 = ( Graphics2D ) g;
		g2.setStroke( new BasicStroke( 3 ) );
		g2.setColor( c );
		g2.draw( new Line2D.Float( p1.x, p1.y, p2.x, p2.y ) );
	}

	public static void main( String[] args ) {
		ClosedPattern me = new ClosedPattern();
	}

}

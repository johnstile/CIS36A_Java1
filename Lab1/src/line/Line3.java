package line;

/*
 * By: John Stile <john@stilen.com>
 * Assignment: Lab1 (part B)
 */
import java.awt.*;

public class Line3 {

	Point	p1, p2;

	/*
	 * It is a good idiom to have many constructors that call one
	 * to consolidate init logic in one place
	 */
	
	// Default constructor, calls the other constructor
	Line3() {
		this( 0, 0, 0, 0 );
	}

	// This constructor lets the user set all points
	Line3( int x1, int y1, int x2, int y2 ) {
		p1 = new Point( x1, y1 );
		p2 = new Point( x2, y2 );
	}

	// returns the slope of the line. This is a ratio of rise over run.
	double slope() {
		System.out.println( "p1.y - p2.y:" + ( p1.y - p2.y ) );
		System.out.println( "p1.x - p2.x:" + ( p1.x - p2.x ) );
		double slope = ( double ) ( p1.y - p2.y ) / ( p1.x - p2.x );
		System.out.println( "slope:" + slope );
		return slope;

	}

	// returns true if the point given as parameters is on the line
	// algorithm: check that the lines between this point and our
	// other points have the same slope.
	boolean pointOnLine( int x, int y ) {
		// first slope is between the passed in point and x1,y1
		double slope1 = ( double ) ( y - p1.y ) / ( x - p1.x );
		// slope between parameter point and x2,y2
		double slope2 = ( double ) ( y - p2.y ) / ( x - p2.x );
		System.out.println( "slope1:" + slope1 + ", slope2:" + slope2 );
		// if the slopes are equal, then the point is on the line
		return ( slope1 == slope2 );
	}

	// who remembers this stuff? http://planetmath.org/anglebetweentwolines
	// does.
	double angleTo( Line1 otherLine ) {
		double differenceInSlopes = slope() - otherLine.slope();
		double denominator = 1 + ( slope() * otherLine.slope() );
		double angleInDegrees = Math.abs( differenceInSlopes / denominator );
		return angleInDegrees;
	}

	// Use main() to test your Line1 class
	public static void main( String[] args ) {
		System.out.println( "testing Line3" );
		// Set myLine to contain a reference to a new line object.
		Line3 myLine = new Line3();
		// Initialize myLine's x1 and y1 to the point (5, 10),
		// and initialize myLine's x2 and y2 to the point (45, 40).

		// First try
		// myLine.p1 = new Point( 5,10 );
		// myLine.p2 = new Point(45,40 );

		// Better to have a constructor that can take all the arguments at once
		// myLine(5, 10, 45, 40);

		// Better to have the class call this Point constructor
		myLine.p1.x = 5;
		myLine.p1.y = 10;
		myLine.p2.x = 45;
		myLine.p2.y = 40;

		// Print the line's slope, which should be 1 (or, 45 degrees).
		System.out.println( "Slope of myLIne: " + myLine.slope() );

		// check that (10,15) is on the line
		if ( myLine.pointOnLine( 10, 15 ) ) {
			System.out.println( "Point is on the line" );
		}
		else {
			System.out.println( "Point is not on the line" );
		}
		// check that the angle between this line and another line
		// defined by (5,10) and (10,20) is about 1/3
		Line1 otherLine = new Line1();
		otherLine.x1 = 5;
		otherLine.y1 = 10;
		otherLine.x2 = 10;
		otherLine.y2 = 20;
		System.out.println( "The angle between myLine and otherLine is about:"
				+ myLine.angleTo( otherLine ) );
	}
}

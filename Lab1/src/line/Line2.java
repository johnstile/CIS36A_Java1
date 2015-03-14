package line;

/*
 * By: John Stile <john@stilen.com>
 * Assignment: Lab1 (part B)
 * Given: a y-intercept and slope (or rise over run), only one line passes
 * though this.
 * Line2 class uses slope intercept to define a line.
 * Use integer for the intercept.
 * Use double for slope
 */
// Line class with points stored.
// You should change this to use an internal representation of *slope* and
// *y-intercept*. So, the instance variables will change, and some or all
// of the method declarations.
public class Line2 {

	// int x1, y1, x2, y2;
	double	slope;
	int		intercept;

	// returns the slope of the line. This is a ratio of rise over run.
	// double getSlope() {
	// double slope = (y1 - y2)/(x1 - x2);
	// return slope;
	// }

	// returns true if the point given as parameters is on the line
	// algorithm: check that the lines between this point and our
	// other points have the same slope.
	boolean pointOnLine( int x, int y ) {
		// // first slope is between the passed in point and x1,y1
		// double slope1 = (y-y1)/(x-x1);
		// // slope between parameter point and x2,y2
		// double slope2 = (y-y2)/(x-x2);
		// // if the slopes are equal, then the point is on the line
		// return (slope1==slope2);
		/*
		 * this line has a point (0,b) and slope
		 * slope = y / x
		 * intercept is y at x=0
		 * For a given y,
		 * x = (y * slope) - intercept
		 */
		Double x_online = ( y * slope ) - intercept;
		/*
		 * the x values must be equal for this point to be on this line
		 */
		return ( x_online.intValue() == x ) ? true : false;
	}

	// who remembers this stuff? http://planetmath.org/anglebetweentwolines
	// does.
	double angleTo( Line1 otherLine ) {
		double differenceInSlopes = slope - otherLine.slope();
		double denominator = 1 + ( slope * otherLine.slope() );
		double angleInDegrees = Math.abs( differenceInSlopes / denominator );
		return angleInDegrees;
	}

	// Use main() to test your Line1 class
	public static void main( String[] args ) {
		System.out.println( "testing Line2" );
		// Set myLine to contain a reference to a new line object.
		Line2 myLine = new Line2();
		// Initialize myLine to have a slope of 1 and a y-intercept of 5. This
		// is the same line you initialized in Line1
		myLine.slope = 1;
		myLine.intercept = 5;

		// Print the line's slope, which should be 1 (or, 45 degrees).
		System.out.println( "Slope of myLine is:" + myLine.slope );

		// check that (10,15) is on the line
		boolean onLine = myLine.pointOnLine( 10, 15 );
		if ( onLine ) {
			System.out.println( "Point 10,15 is on the line!" );
		}
		else {
			System.out.println( "Point 10,15 is not on the line!" );
		}

		// check that the angle between this line and another line
		// defined by (5,10) and (10,20) is about 1/3
		Line1 myLine2 = new Line1();
		myLine2.x1 = 5;
		myLine2.x2 = 10;
		myLine2.y1 = 10;
		myLine2.y2 = 20;
		double mySlope2 = myLine2.slope();
		double myAngleTo = myLine.angleTo( myLine2 );
		System.out.println( "myLine angleTo myLine2 is:" + myAngleTo );

	}
}

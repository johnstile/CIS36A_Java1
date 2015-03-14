package dotsAndLines;

import java.awt.*; // gets Point
import java.util.ArrayList;

public class Line {
	public static final Point	getPoint2	= null;
	// Line has 2 points
	private Point				point1;
	private Point				point2;

	// Only one constructor
	public Line( Point p, Point q ) {
		// System.out.println("Line Constructor Called!");
		point1 = p;
		point2 = q;
	}

	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public String toString() {
		return ( "point1:" + getPoint1() + ",point2:" + getPoint2() );
	}

	public boolean equals( Line l ) {
		// Debugging
		if ( point1.equals( l.getPoint1() ) ) {
			System.out.println( "Match Point1" );
		}
		if ( point2.equals( l.getPoint2() ) ) {
			System.out.println( "Match Point2" );
		}
		// End Debugging
		boolean foundIt = false;
		if (  
		    point1.equals( l.getPoint1() )
			&&  point2.equals( l.getPoint2())  
		){
			System.out.println( "SETTING TO TRUE" );
			foundIt = true;
		}
		return foundIt;
	}

	public boolean hasPoint( Point p ) {
		boolean found = false;
		if ( p.equals( point1 ) ){
			found = true;
		}
		if ( p.equals( point2)  ) {
			found = true;
		}
		return found;
	}
}

package dotsAndLines;

import java.awt.*; // gets Point

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

	@Override
	public String toString() {
		return ( "point1:" + getPoint1() + ",point2:" + getPoint2() );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		return hasPoint(other.getPoint1()) && hasPoint(other.getPoint2());
	}

	public boolean hasPoint(Point p) {
		return p.equals(point1) || p.equals(point2);
	}
}

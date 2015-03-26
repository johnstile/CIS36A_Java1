package lect09;

import java.awt.Point;

public class ComparablePoint extends Point implements Comparable<Point> {

	public int compareTo( Point p) {
//      // One way to sort
//		if ( this.x == p.x ){
//			return 0;
//		} else if ( this.x < p.x){
//			return -1;
//		} else {
//			return 1;
//		}
		return this.x - p.x;
	}

}

package shape;

public class Line extends OneDimensionalShape {
	private int shapeID=1;
	private Point point1;
	private Point point2;
	public Line( Point p1,  Point p2 ){
	    point1 = p1;
	    point2 = p2;
	}
	@Override
	public int getLength() {
		int x1 = point1.getX();
		int y1 = point1.getY();
		int z1 = point1.getZ();
		int x2 = point2.getX();
		int y2 = point2.getY();
		int z2 = point2.getZ();
		// Formula: Pythagorean Theorem
		// x^2 + y^2 = z^2
		int x = Math.abs(x1 - x2);
		int y = Math.abs(y1 - y2);
		int z = Math.abs(z1 - z2);
		double d = Math.sqrt(  (x*x ) + (y*y)  +  (z*z) );
		return (int) d;
	}
	@Override
	public void move(int x, int y, int z) {
		point1.setX( point1.getX() + x );
		point2.setX( point2.getX() + x );
	}
	@Override
	public String toString() {
		String s = new String(
				"shapeID:" + shapeID
				+ ", point1: x:" + point1.getX()
				+ " y:" +  point1.getY()
				+ " z:" + point1.getZ()
				+ ", point2: x:" + point2.getX()
				+ " y:" +  point2.getY()
				+ " z:" + point2.getZ()				
		);
		return s;
	}
}

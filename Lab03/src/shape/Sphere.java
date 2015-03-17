package shape;

public class Sphere extends ThreeDimensionalShape {
	private int shapeID=3;
	private Point point ;
	private int radius;
	public Sphere(Point p4, int r) {
		point = p4;
		radius = r;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	@Override
	public double getArea() {
		// A = 4 * 	π  * r^2
		double a = 4 * Math.PI * radius * radius;
		return a;
	}
	@Override
	public double getVolume() {
		// V = (4/3) *  π * r^3
		double v = (4/3) * Math.PI + (radius * radius * radius);
		return v;
	}
	@Override
	public void move(int x, int y, int z) {
		 point.setX(  point.getX() + x );
		 point.setY(  point.getY() + y );
		 point.setZ(  point.getZ() + z );
	}
	@Override
	public String toString() {
		String s = new String(
				"shapeID:" + shapeID
				+ ", point: x:" + point.getX()
				+ " y:" +  point.getY()
				+ " z:" + point.getZ()
				+ ", radius:" + radius
		);
		return s;
	}
}

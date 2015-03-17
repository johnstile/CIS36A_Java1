package shape;

public class Circle extends TwoDimentionalShape {
	private int shapeID=2;
	private Point point;
	private int radius;
	public Circle( Point p, int r ){
        point = p;
        radius = r;
	}
	@Override
	public double getArea() {
		double area = Math.abs( 2 * Math.PI * radius ) ;
		return 0;
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

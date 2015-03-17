package shape;

public class Point extends ZeroDimentionalShap {
	private int shapeID = 0;
	private int x;
	private int y;
	private int z;
  
	public Point(int i, int j, int k) {
		this.move(i, j, k);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	@Override
	public void move(int x, int y, int z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	@Override
	public String toString() {
		String s = new String(
				"shapeID:" + shapeID
				+ ", point1: x:" + getX()
				+ " y:" +  getY()
				+ " z:" + getZ()
		);
		return s;
	}
	
}

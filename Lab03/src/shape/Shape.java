package shape;

public abstract class Shape {
    private int shapeID;
    public int getID(){
    	return shapeID;
    }
    public abstract void move(int x, int y, int z);
    public abstract String toString();
}

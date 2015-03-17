package shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ShapeTester {
	public static void main(String[] args) {
		System.out.println("===Tests As Developed==="  );
		Point p1 = new Point( 0,0,0);
		Point p2 = new Point( 4,4,4);
		p2.move(1, 1, 1);
		Line l1 = new Line(p1,p2);
		System.out.println("Line Length: " + l1.getLength() );
		l1.move(1,1,1);
		Point p3 = new Point(2,2,2);
		Circle c1 = new Circle( p3, 2 );
		c1.move(1,1,1);
		System.out.println("Circle Area: " + c1.getArea() );
		Point p4 = new Point(2,2,2);
		Sphere s1 = new Sphere(  p4, 2 );
		System.out.println("Sphere Area:" + s1.getArea() );
		System.out.println("Sphere Volume:" + s1.getVolume() );
		
		System.out.println("===Tests toString==="  );
		System.out.println("Point: " + p1 );
		System.out.println("Line:: "+ l1);
		System.out.println("Circle: " + c1);	
		System.out.println("Sphere: " + s1);
		
		System.out.println("===Polymorphism Tests==="  );
		ArrayList<Shape> shapeList = new ArrayList<>();
		Shape[] shapeArray = { p1, l1, c1, s1 };
		shapeList.addAll( Arrays.asList(shapeArray) );
//		shapeList.add( p1 );
//		shapeList.add( l1 );
//		shapeList.add( c1 );
//		shapeList.add( s1 );
		System.out.println("Location:");
		printShape(shapeList);
		System.out.println("Move:");
	    moveShape(shapeList);
	    System.out.println("Location:");
	    printShape(shapeList);
	}
	private static void moveShape(ArrayList<Shape> shapeList) {
		final Random rnd = new Random();
		int x = rnd.nextInt(10);
		int y = rnd.nextInt(10);
		int z = rnd.nextInt(10);
		for ( Shape s : shapeList ){
	       s.move(x, y, z);
		}
	}
	public static void printShape( ArrayList<Shape> shapeList){
		for ( Shape s : shapeList ){
			// print current location, move shape, print 
			if ( s instanceof ZeroDimentionalShap ){
				ZeroDimentionalShap zds = (ZeroDimentionalShap)s;
				System.out.println( zds );
			} else
			if ( s instanceof OneDimensionalShape ){
				OneDimensionalShape ods = (OneDimensionalShape)s;
				System.out.println( ods + ", length is "  + ods.getLength() );
			} else
			if ( s instanceof  TwoDimentionalShape){
				TwoDimentionalShape tds = ( TwoDimentionalShape)s;
				System.out.printf("%s area is %f\n", tds, tds.getArea()  );
			} else
				if ( s instanceof  ThreeDimensionalShape){
					ThreeDimensionalShape tds = ( ThreeDimensionalShape)s;
					System.out.printf("%s area is %f\n", tds, tds.getArea()  );
					System.out.printf("%s volume is %f\n",  tds, tds.getVolume() );
			}
		}
	}
}

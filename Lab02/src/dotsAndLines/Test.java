package dotsAndLines;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Line> lineList = new ArrayList<Line>();
		lineList.add(new Line(new Point(0, 0), new Point(1, 1)));
		lineList.add(new Line(new Point(1, 1), new Point(2, 2)));

		System.out.println(lineList.contains(new Line(new Point(0, 0),
				new Point(1, 1))));
		System.out.println(lineList.contains(new Line(new Point(1, 0),
				new Point(1, 1))));
		DotGame me = new DotGame();
	}

}
